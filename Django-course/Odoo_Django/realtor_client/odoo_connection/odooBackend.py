import xmlrpc.client
from django.contrib.auth.backends import BaseBackend
from .models import OdooUser

class OdooBackend(BaseBackend):
    def __init__(self):
        url_common = f'http://localhost:8069/xmlrpc/2/common'
        url_model = f'http://localhost:8069/xmlrpc/2/object'
        self.db_odoo = 'projet'
        self.common = xmlrpc.client.ServerProxy(url_common)
        self.model = xmlrpc.client.ServerProxy(url_model)
        uid = self.common.authenticate(self.db_odoo, 'eugene.krabs@he2b.be', 'money', {})
        password = 'money'

        hasRight_realtor =self.model.execute_kw(self.db_odoo,uid,password,"realtor.appartement","check_access_rights",["read"],{"raise_exception": False},)
        hasRight_res_partner =self.model.execute_kw(self.db_odoo,uid,password,"res.partner","check_access_rights",["read"],{"raise_exception": False},)
        if hasRight_realtor and hasRight_res_partner and not OdooUser.objects.filter(odoo_id=uid).exists():
            OdooUser.objects.create(odoo_id=uid, password=password)


    # def authenticate(self, request, username=None, password=None):
    #     user = User.objects.filter(username=username).first()
    #     if user:
    #         if user.check_password(password):
    #             return user
    #         return None

    #     odoo_uid = self.common.authenticate(self.db_odoo, username, password, {})
    #     if not str(odoo_uid).isdigit():
    #         return None

    #     user = User.objects.create(username=username, email=username)
    #     user.set_password(password)
    #     user.save()
    #     OdooUser.objects.create(odoo_id=odoo_uid, user=user, password=password)
    #     return user

    # def get_user(self, user_id):
    #     try:
    #         return User.objects.get(pk=user_id)
    #     except User.DoesNotExist:
    #         return None