from django.shortcuts import render
from django.http import HttpResponse
from django.contrib.auth import logout
# Create your views here.
def index(request):
    context = {}
    return render(request, 'odoo_connection/index.html', context)

def logout_view(request):
    logout(request)