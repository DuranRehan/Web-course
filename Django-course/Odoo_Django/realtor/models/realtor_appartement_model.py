from odoo import models, fields,api
from odoo.exceptions import ValidationError
from dateutil.relativedelta import relativedelta

class Appartement(models.Model):
    _name = "realtor.appartement"
    _description = "Appartement à vendre"

    name = fields.Char('Appartament name', required=True)
    desc = fields.Char('Description')
    image = fields.Binary('Image')
    date_disponibility = fields.Date('Date de disponibilité')
    minimal_price = fields.Integer('Prix attendu')
    superficy_appartement= fields.Integer('Surface de l\'appartement')
    superficy_terrace= fields.Integer('Surface de la terasse')
    superficy= fields.Integer('Surface totale', compute='_compute_superficy')
    buyer = fields.Many2one('res.partner', string='Acheteur')
    buyer_bid= fields.Integer('Meilleure offre')
    product_line = fields.One2many('product.template', 'appartement_id', string='Appartement product')

    _sql_constraints = [('realtor_appartement_name_unique','UNIQUE (name)','Appartement name already exists!')]
    @api.constrains('min_price')
    def _check_min_price(self):
        for appart in self:
            if appart.minimal_price < 0:
                raise ValidationError('Prix doit etre strictement positive')

    @api.constrains('superficy_appart')
    def _check_superficy_appart(self):
        for appart in self:
            if appart.superficy_appartement <= 0:
                raise ValidationError('Superifcie doit etre positive')

    @api.constrains('superficy_terrace')
    def _check_superficy_terrace(self):
        for appart in self:
            if appart.superficy_terrace < 0:
                raise ValidationError('Superficie de la terrace peut pas etre negative')

    @api.depends('superficy_appartement', 'superficy_terrace')
    def _compute_superficy(self):
        for appart in self:
            appart.superficy = appart.superficy_appartement + appart.superficy_terrace
    
    @api.constrains('date_disponibility')
    def _check_date_disponibility(self):
        for appart in self:
            if appart.date_disponibility < fields.Date.today() + relativedelta(months=3):
                raise ValidationError('Date de disponibilité doit etre au moins 3 mois plus tard d\'ici')

    @api.constrains('buyer_bid')
    def _check_buyer_bid(self):
        for record in self:
            if record.buyer_bid < record.minimal_price*0.9:
                raise ValidationError('L\'offre doit être au moins de 90% du prix minimal')