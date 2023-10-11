from django.shortcuts import render, get_object_or_404
from .models import Developer
from django.http import HttpResponse, HttpResponseRedirect
from django.urls import reverse
from .forms import TaskForm,ShortDeveloperForm#,DeveloperForm
from django.views.generic import DetailView, ListView
from django.contrib.auth.mixins import LoginRequiredMixin


# def index(request):
#     context = {
#         'developers': Developer.objects.all(),
#         'form': DeveloperForm,
#     }
#     return render(request, 'developer/index.html', context)
#
# def detail(request, developer_id):
#     developer = get_object_or_404(Developer, pk=developer_id)
#     return render(request, 'developer/detail.html', {'developer': developer})


def create(request):
    form = ShortDeveloperForm(request.POST)
    if form.is_valid():
        Developer.objects.create(
            first_name=form.cleaned_data['first_name'],
            last_name=form.cleaned_data['last_name'],
            username=form.cleaned_data['username'],
            password=form.cleaned_data['password'],
        )
    return HttpResponseRedirect(reverse('developer:index'))


def delete(request,id):
    developer = get_object_or_404(Developer, pk=id)
    developer.delete()
    return HttpResponseRedirect(reverse('developer:index'))


class IndexView(LoginRequiredMixin,ListView):
    model = Developer
    template_name = "developer/index.html"
    context_object_name = 'developers'

    def get_context_data(self, **kwargs):
        context = super(IndexView, self).get_context_data(**kwargs)
        context['form'] =  ShortDeveloperForm 
        return context


class DevDetailVue(LoginRequiredMixin,DetailView):
    model = Developer
    template_name = 'developer/detail.html'
    def get_context_data(self, **kwargs):
        context = super(DevDetailVue, self).get_context_data(**kwargs)
        form = TaskForm(initial={'assignee': get_object_or_404(Developer, pk=self.kwargs['pk'])})
        form.fields['assignee'].disabled = True
        context['form'] = form
        return context
