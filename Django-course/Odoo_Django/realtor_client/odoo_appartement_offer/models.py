from django.db import models
from odoo_connection.odooBackend import OdooBackend
from odoo_connection.models import OdooUser
# Create your models here.
class Appartement(models.Model):
    
    def getAppartements():
        backend = OdooBackend()
        uid = OdooUser.objects.get().odoo_id
        password = OdooUser.objects.get().password
        data = backend.model.execute_kw(backend.db_odoo,uid,password,"realtor.appartement","search",[[]],)
        appartements = backend.model.execute_kw(backend.db_odoo,uid,password,"realtor.appartement", 'read',[data], {'fields': ['name', 'desc','image','date_disponibility','minimal_price','buyer_bid']})

        for appartement in appartements:
            products = backend.model.execute_kw(backend.db_odoo,uid,password,'product.product','search', [[['appartement_id', 'ilike', appartement['id']]]])
            details = backend.model.execute_kw(backend.db_odoo,uid,password,'product.product', 'read', [products, ['name', 'free_qty']])
            for detail in details:
                appartement['qte'] = detail['free_qty']
                appartement['details_name'] = detail['name']
        return appartements

    def updateOffer(email,fname,lname,offer,appartement_id):
        backend = OdooBackend()
        uid = OdooUser.objects.get().odoo_id
        password = OdooUser.objects.get().password
        try:
            user_exist = backend.model.execute_kw(backend.db_odoo,uid,password,'res.partner', 'search_count',[[['email', '=', email],['name','=',fname+ " " + lname]]])
            if user_exist == 0:
                partner = backend.model.execute_kw(backend.db_odoo,uid,password, 'res.partner', 'create', [{'name':fname+ " " + lname,'email':email}])
            else:
                partner = backend.model.execute_kw(backend.db_odoo,uid,password,'res.partner', 'search',[[['email', '=', email]]])

            appartement = backend.model.execute_kw(backend.db_odoo,uid,password,"realtor.appartement", 'search',[[['id', '=', appartement_id]]],)
            actual_offer = backend.model.execute_kw(backend.db_odoo,uid,password,"realtor.appartement", 'read',[appartement], {'fields': ['buyer_bid']})
            if actual_offer[0]['buyer_bid'] > int(offer):
                return {'code':'error','message':"The offer is too low, the actual offer is "+str(actual_offer[0]['buyer_bid'])+" €"}
            backend.model.execute_kw(backend.db_odoo,uid,password,"realtor.appartement", 'write', [int(appartement_id), {'buyer_bid': offer,'buyer':partner}])
            return {'code':'success','message':'Offer updated successfully.'}
        except:
            return {'code':'error','message': 'An error occured. Please try again. If the problem persists, contact the administrator.'}
        