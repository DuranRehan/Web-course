from django.urls import path
from . import views

app_name = 'odoo_connection'
urlpatterns = [
path('', views.index, name='index'),

]
