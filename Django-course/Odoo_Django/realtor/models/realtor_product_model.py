from odoo import models, fields,api

class Product(models.Model):
    
    _inherit = 'product.template'
    appartement_id = fields.Many2one('realtor.appartement', string='appartement_id')
