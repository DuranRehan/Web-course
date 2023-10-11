from odoo import models, fields,api

class TodoTask(models.Model):
    _inherit = "todo.task"

    effort_estimate = fields.Integer('Effort Estimate')
    tag_ids = fields.Many2many('todo.task.tag', string='Tags')
    desc = fields.Text('Description')
    state = fields.Selection([('draft','New'),('open','Started'),('done','Closed')], default='draft',string="State")
    docs = fields.Html('Documentation')
    date_created = fields.Datetime('Create Date and Time', default=lambda self: fields.Datetime.now())
    image = fields.Binary('Image')

    
    @api.onchange('user_id')
    def _onchange_user(self):
        self.team_ids = None
        return {
            'warning': {
                'title': "Team cleared",
                'message': "Team was cleared because you changed the responsible user",
            }
        }
    @api.constrains('name')
    def _check_name_size(self):
        for record in self:
            if len(record.name) < 5:
                raise models.ValidationError("Title must have 5 characters!")