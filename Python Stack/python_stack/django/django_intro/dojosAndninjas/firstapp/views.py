from django.shortcuts import render,HttpResponse,redirect
from .models import *

def root(request):
    
    context = {
    	"all_the_dojo": Dojo.objects.all()
    }   
   
    return render(request,"index.html",context)

def create_ninja(request):
    selected_dojo=Dojo.objects.get(id=request.POST["dojo_id"])
    Ninja.objects.create(first_name=request.POST["fname"],last_name=request.POST["lname"],dojo=selected_dojo)
    return redirect("/")

def create_dojos(request):

    Dojo.objects.create(name=request.POST["name"],city=request.POST["city"],state=request.POST["state"],desc="No Value")
    return redirect("/")

def delete_dojo(request):
    
    delete_dojo=Dojo.objects.get(id=int(request.POST['hide']))
    delete_dojo.delete()
    return redirect("/")