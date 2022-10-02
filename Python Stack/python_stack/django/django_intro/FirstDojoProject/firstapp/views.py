from django.shortcuts import render,HttpResponse,redirect
from django.http import JsonResponse

def root(request):
    return redirect("/blogs")
def new(request):
    return HttpResponse("placeholder to display a new form to create a new blog")

def create(request):
    return redirect("/")

def show(request,num):
    return HttpResponse(f"placeholder to display blog number: {num}")
def edit(request,num):
     return HttpResponse(f" placeholder to edit blog {num}")
def destroy(request,num):
    return redirect("/blogs")
def json(request):
    return JsonResponse({"title": "My First Blog","content":"lorem , ipusm pla pla pla pla ", "status": True})