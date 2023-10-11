from odoo import models, fields

class Tag(models.Model):
    _name= "todo.task.tag"
    _description = "To-do Tag"

    name = fields.Char('name')
    task_ids = fields.Many2many('todo.task', string='Tasks')

    _sql_constraints = [('todo_task_tag_name_unique','UNIQUE (name)','Tag name already exists!')]
