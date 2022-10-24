
from multiprocessing import context
from pydoc import plain
from django.shortcuts import render,redirect
import bcrypt
from .models import *
from django.contrib import messages
def root(request):
    return render(request,'login.html')

def allplant(request):
    #num_visits = request.session.get('num_visits')
    #self.request.session['num_visits'] = num_visits + 1
    #counter=plant.users_who_visit.all().count()
    context = {
        'allplanet':Plant.objects.all()
    }
    return render(request,'main.html',context)

def newplant(request):
    return render(request,'newtree.html')

def details(request,id):
    user=User.objects.get(id=request.session['user_id'])
    plant=Plant.objects.get(id=id)
    context = {
        'plant':Plant.objects.get(id=id),
        'user':user,
        'likebook':plant.users_who_visit.all(),
    }
    return render(request,'details.html',context)
def mytree(request):
    # p=Plant.objects.all()
    # b=User.objects.get(id=id)
    # p.planted_by.id
    context = {
        'allplanet':Plant.objects.all(),
    }
    return render(request,'mytress.html',context)
def editpage(request,id):
    context = {
        'plant':Plant.objects.get(id=id),
    }
    return render(request,'edit.html',context)
def reg(request):
    errors = User.objects.basic_validator(request.POST)
    users=User.objects.all()
    for user in users:
        if user.email==request.POST['email']:
            errors['email']="this email aleady exsist"

    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/')
    password= request.POST['password']
    pw_hash= bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
    print(pw_hash)  
    User.objects.create (
        first_name=request.POST['first_name'],
        last_name=request.POST['last_name'],
        email=request.POST['email'],
        password=pw_hash ,
       
    )
    name1=User.objects.last()
    request.session['user_name']=name1.first_name
    request.session['user_id'] = name1.id

    return redirect('/allplant')

def login(request):
    user = User.objects.filter(email=request.POST['email2']) 
    if user:
        logged_user=user[0]


        if bcrypt.checkpw(request.POST['password2'].encode(),logged_user.password.encode()):
            request.session['user_id'] = logged_user.id
            request.session['user_name']= logged_user.first_name
            return redirect('/allplant')
        else:
            messages.error(request,"Your email or password is wrong try ag!")
            return redirect('/')
    else:
        messages.error(request,"Your email or password is wrong try ag!")
        
    return redirect('/')

    #addplant
def addplant(request):
    errors = Plant.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/newplant')
    user=User.objects.get(id=request.session['user_id'])
   
    Plant.objects.create(
        species=request.POST['species'],
        location=request.POST['location'],
        reason=request.POST['reason'],
        date_planed=request.POST['date'],
        planted_by=user,
    )
    pp= Plant.objects.last()
    
    return redirect('/allplant')

def delete(request,id):
    plant=Plant.objects.get(id=id)
    plant.delete()
    return redirect('/mytree')

def update(request,id):
    errors = Plant.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect(f'/editpage/{id}')
    p=Plant.objects.get(id=id)
    p.species=request.POST['species']
    p.location=request.POST['location']
    p.reason=request.POST['reason']
    p.date_planed=request.POST['date']
    p.save()
    return redirect('/allplant')
    

def logout(request):
    del request.session['user_id']
    del request.session['user_name']
    return redirect('/')

def addvisit(request,id):
    plant=Plant.objects.get(id=id)
    user=User.objects.get(id=request.session['user_id'])
    plant.users_who_visit.add(user)
    
    return redirect (f'/details/{id}')