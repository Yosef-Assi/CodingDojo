from django.shortcuts import render,HttpResponse,redirect
import bcrypt
from .models import *
from django.contrib import messages

# Create your views here.
def root(request):
    return render(request,'login.html')

def pal(request):
    return render(request,'main.html')

def reg(request):
    errors = Login.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/')
    password= request.POST['password']
    pw_hash= bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
    print(pw_hash)  
    Login.objects.create (
        first_name=request.POST['first_name'],
        last_name=request.POST['last_name'],
        email=request.POST['email'],
        password=pw_hash ,
        birthday=request.POST['birthDay']
    )
    name1=Login.objects.last()
    request.session['rename']=name1.first_name
    
    return redirect('/pal')

def login(request):
    

    user = Login.objects.filter(email=request.POST['email2']) 
    if user:
        logged_user=user[0]


        if bcrypt.checkpw(request.POST['password2'].encode(),logged_user.password.encode()):
            request.session['userid'] = logged_user.id
            request.session['rename']= logged_user.first_name
            
            return redirect('/pal')

    return redirect('/')

def logout(request):
    del request.session['userid']
    del request.session['rename']
    return redirect('/')
