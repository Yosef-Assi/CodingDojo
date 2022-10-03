from django.shortcuts import render,HttpResponse,redirect
import bcrypt
from .models import *
from django.contrib import messages

# Create your views here.
def root(request):
    return render(request,'login.html')

def pal(request):
    if 'userid' in request.session:
        return redirect('wall/')
    else:
        return redirect('/')

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
    request.session['rename']=name1.first_name
    request.session['user_id'] = name1.id

    return redirect('/pal')

def login(request):
    user = User.objects.filter(email=request.POST['email2']) 
    if user:
        logged_user=user[0]


        if bcrypt.checkpw(request.POST['password2'].encode(),logged_user.password.encode()):
            request.session['user_id'] = logged_user.id
            request.session['rename']= logged_user.first_name
            
            return redirect('/pal')

    return redirect('/')

def logout(request):
    del request.session['userid']
    del request.session['rename']
    return redirect('/')
