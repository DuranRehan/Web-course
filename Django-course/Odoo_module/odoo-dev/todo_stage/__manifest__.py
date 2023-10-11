# -*- coding: utf-8 -*-
{
    'name': "todo_stage",

    'summary': """
        petite description""",

    'description': """
        La description longue du module
    """,

    'author': "Duran Rehan 56055",
    'website': "https://git.esi-bru.be/56055",

    # Categories can be used to filter modules in modules listing
    # Check https://github.com/odoo/odoo/blob/14.0/odoo/addons/base/data/ir_module_category_data.xml
    # for the full list
    'category': 'Test',
    'version': '0.1',

    # any module necessary for this one to work correctly
    'depends': ['todo_app'],

    # always loaded
    'data': [
        'security/ir.model.access.csv',
        'views/views.xml',
        'views/templates.xml',
        'views/todo_menu.xml',
        'views/todo_view.xml',
        'demo/demo.xml',
    ],
    # only loaded in demonstration mode
    'demo': [
        'demo/demo.xml',
    ],
    'application': True,
}
