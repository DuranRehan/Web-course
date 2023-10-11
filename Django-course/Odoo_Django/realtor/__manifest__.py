# -*- coding: utf-8 -*-
{
    'name': "realtor",

    'summary': """
        allows you to view/add/delete/modify apartments.""",

    'description': """
        allows you to view/add/delete/modify apartments.
    """,

    'author': "56055",
    'website': "http://www.yourcompany.com",

    # Categories can be used to filter modules in modules listing
    # Check https://github.com/odoo/odoo/blob/14.0/odoo/addons/base/data/ir_module_category_data.xml
    # for the full list
    'category': 'Administration',
    'version': '0.1',

    # any module necessary for this one to work correctly
    'depends': ['base','stock'],

    # always loaded
    'data': [        
        'security/security.xml',
        'security/settings.xml',
        'security/ir.model.access.csv',

        'views/views.xml',
        'views/templates.xml',
        'views/appartement_view.xml',
    ],
    # only loaded in demonstration mode
    'demo': [
        'demo/demo.xml',
        'demo/demo_stock.xml',
    ],
    'application': True,
}
