from django.shortcuts import render, get_object_or_404

from task.forms import TaskForm
from .models import Task
from developer.models import Developer
from django.views.generic import ListView
from django.http import HttpResponseRedirect
from django.urls import reverse
from django.contrib.auth.mixins import LoginRequiredMixin,PermissionRequiredMixin

def index(request):
    return render(request, 'task/index.html')

def delete(request, task_id):
    task = get_object_or_404(Task, pk=task_id)
    task.delete()
    return HttpResponseRedirect(reverse('task:index'))

def create(request):
    form = TaskForm(request.POST)
    if form.is_valid():
        Task.objects.create(
            title=form.cleaned_data['title'],
            description=form.cleaned_data['description'],
            assignee =form.cleaned_data['assignee'],
        )
    return HttpResponseRedirect(reverse('task:index'))

class IndexView(LoginRequiredMixin,PermissionRequiredMixin,ListView):
    model = Task
    template_name = "task/index.html"
    context_object_name = 'tasks'
    permission_required = 'task.task_management' 
    def get_context_data(self, **kwargs):
        context = super(IndexView, self).get_context_data(**kwargs)
        context['form'] = TaskForm(initial={'assignee': Developer.objects.first()})
        return context


