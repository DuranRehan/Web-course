# -*- coding: utf-8 -*-
import logging
from odoo import models, fields, api, exceptions

class TodoTask(models.Model):

    # Override attributes
    _name = 'todo.task'  # Model name
    _logger = logging.getLogger(__name__)  # for logger

    # My Fields
    name = fields.Char('name', required=True)
    is_done = fields.Boolean()
    active = fields.Boolean(default=True)
    date_deadline = fields.Date()
    user_id = fields.Many2one(
        'res.users', 'Responsible', default=lambda self: self.env.user)
    team_ids = fields.Many2many('res.partner', string='Team')

    # Set false to active field
    @api.depends('is_done', 'active')
    def do_clear_done(self):
        if (not self.active):
            raise exceptions.UserError('This task is already not active')
        self.active = False
        self._logger.info('#---------------------------------------------------#')
        self._logger.info('do_clear_done button triggered, task %s is now inactive', self.name)
        self._logger.info('#---------------------------------------------------#')
    # Override write method

    def write(self, vals):
        if not self.active:
            vals['active'] = True
            self._logger.info('#---------------------------------------------------#')
            self._logger.info('Task %s has been updated, task %s is now active', self.name, self.name)
            self._logger.info('#---------------------------------------------------#')
        return super(TodoTask, self).write(vals)
