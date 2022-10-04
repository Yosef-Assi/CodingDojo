from django.shortcuts import render,HttpResponse,redirect
import bcrypt
from .models import *
from django.contrib import messages
# Create your views here.

def root(request):
    return render(request,'login.html')
def books(request):
    user=User.objects.get(id=request.session['user_id'])
    context = {
        'allbooks':Book.objects.all(),
        'user':user
    }
    return render(request,'books.html',context)

def favbooks(request,id):
    user=User.objects.get(id=request.session['user_id'])
    # print(user.likes_books.get(id=id).__dict__)
    book=Book.objects.get(id=id)
    # print(book.users_who_like.all().values())

    context = {
        'book':book,
        'likebook':book.users_who_like.all(),
        'user':user
    }
    return render(request,'favbooks.html',context)
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

    return redirect('/books')

def login(request):
    user = User.objects.filter(email=request.POST['email2']) 
    if user:
        logged_user=user[0]


        if bcrypt.checkpw(request.POST['password2'].encode(),logged_user.password.encode()):
            request.session['user_id'] = logged_user.id
            request.session['user_name']= logged_user.first_name
            return redirect('/books')
        else:
            messages.error(request,"Your email or password is wrong try ag!")
            return redirect('/')
    return redirect('/')

def addbook(request):
    errors = Book.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/books')
    user=User.objects.get(id=request.session['user_id'])
    
    Book.objects.create(
        title=request.POST['title'],
        desc=request.POST['desc'],
        uploaded_by=user,
    )
    last=Book.objects.last()
    last.users_who_like.add(user)
    return redirect('/books')

def logout(request):
    del request.session['user_id']
    return redirect('/')

def addfav(request,id):
    book=Book.objects.get(id=id)
    user=User.objects.get(id=request.session['user_id'])
    book.users_who_like.add(user)

    return redirect('/books')

def unfav(request,id):
    book=Book.objects.get(id=id)
    user=User.objects.get(id=request.session['user_id'])
    book.users_who_like.remove(user)

    return redirect(f'/favbooks/{id}')

def update(request,id):
    if request.POST['up'] == 'Update':
        book=Book.objects.get(id=id)
        book.title=request.POST['title']
        book.desc=request.POST['desc']
        book.save()
        messages.success(request,"Update Complete !")
        return redirect(f'/favbooks/{id}')

    elif request.POST['up'] == 'Delete':
        book=Book.objects.get(id=id)
        book.delete()
        return redirect('/books')

def addfav2(request,id):
    book=Book.objects.get(id=id)
    user=User.objects.get(id=request.session['user_id'])
    book.users_who_like.add(user)

    return redirect(f'/favbooks/{id}')
