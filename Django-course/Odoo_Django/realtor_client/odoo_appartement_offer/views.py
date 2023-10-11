from django.shortcuts import render, redirect
from django.urls import reverse
from django.http import HttpResponseRedirect
from .models import Appartement  
from django.contrib import messages

# Create your views here.

def index(request):
    context = {
        'appartements': Appartement.getAppartements(),
    }
    return render(request, 'odoo_offer/index.html', context)

def updateOffer(request):
    if request.method == 'POST':
        appartement_id = request.POST['appartement_id']
        offer = request.POST['offer']
        lname = request.POST['lname']
        fname = request.POST['fname']
        email = request.POST['email']
        status = Appartement.updateOffer(email,fname,lname, offer,appartement_id)
        if status['code'] == 'error':
            messages.error(request,status['message'])
        else:
            messages.success(request,'Offer updated successfully.')
            
    return redirect('odoo_offer:catalogue')

