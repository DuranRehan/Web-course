from django.urls import path
from . import views

app_name = 'odoo_offer'
urlpatterns = [
path('', views.index, name='catalogue'),
path('updateOffer', views.updateOffer, name='updateOffer'),
]
