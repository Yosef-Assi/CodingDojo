from multiprocessing import context
from django.shortcuts import render,redirect
import bcrypt
from .models import *
from django.contrib import messages

def root(request):
    return render(request,'login.html')
def movies(request):
    user=User.objects.get(id=request.session['user_id'])
    context = {
        'allmovie':Movie.objects.all(),
        'user':user
    }
    return render(request,'movies.html',context)

def admin(request):

    user=User.objects.get(id=request.session['user_id'])
    if user.user_type == 'admin':
        context = {
            'alluser':User.objects.all(),
            'user':User.objects.all()
        }
        return render(request,'admin.html',context)
    else:
        return redirect('/')

def gomovie(request):
    context = {
        'allmovie':Movie.objects.all()
    }
    return render(request,'addmovie.html',context)

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

    return redirect('/movies')

def login(request):
    user = User.objects.filter(email=request.POST['email2']) 
    if user:
        logged_user=user[0]


        if bcrypt.checkpw(request.POST['password2'].encode(),logged_user.password.encode()):
            request.session['user_id'] = logged_user.id
            request.session['user_name']= logged_user.first_name
            return redirect('/movies')
        else:
            messages.error(request,"Your email or password is wrong try ag!")
            return redirect('/')
    return redirect('/')

def addmovie(request):
    user=User.objects.get(id=request.session['user_id'])
    if request.POST['go'] == 'AddMovie':

        Movie.objects.create(
            title=request.POST['title'],
            year=request.POST['year'],
            uploaded_by=user
             )
        movie=Movie.objects.last()
        movie.users_who_like.add(user)
        return redirect('/gomovie')
    else:
        return redirect('/movies')

def addfav(request,id):
    user=User.objects.get(id=request.session['user_id'])
    movie=Movie.objects.get(id=id)
    movie.users_who_like.add(user)
    return redirect('/movies')
   

def delfav(request,id):
    user=User.objects.get(id=request.session['user_id'])
    movie=Movie.objects.get(id=id)
    movie.users_who_like.remove(user)
    return redirect('/movies')
   
def delmov(request,id):
    movie=Movie.objects.get(id=id)
    movie.delete()
    return redirect('/movies')

def logout(request):
    del request.session['user_id']
    return redirect('/')