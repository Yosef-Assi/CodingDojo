
from django.shortcuts import render,redirect
import bcrypt
from .models import *
def root(request):
    return render(request,'login.html')
def main(request):
    context = {
        "getallmessages":Message.objects.all(),
        
    }
    if 'user_id' in request.session:
        return render(request,'comment.html',context)
    else:
        return render(request,'login.html',context)

def wall(request):
    
    context = {
        "getallmessages":Message.objects.all(),
        "getallcommant":Comment.objects.all(),
    }
    if 'user_id' in request.session:
        return render(request,'comment.html',context)
    else:
        return render(request,'login.html',context)


def reg(request):

    password= request.POST['password']
    pw_hash=bcrypt.hashpw(password.encode(),bcrypt.gensalt()).decode()
    print(pw_hash)  
    User.objects.create(
        first_name=request.POST["first_name"],
        last_name=request.POST["last_name"],
        email=request.POST["email"],
        password=pw_hash
    )
    user1=User.objects.last()
    request.session['user_id']=user1.id
    request.session['user_name']=user1.first_name
    



    return redirect('/')
    
def login(request):
    user = User.objects.filter(email=request.POST['email2']) 
    if user:
        logged_user=user[0]


        if bcrypt.checkpw(request.POST['password2'].encode(),logged_user.password.encode()):
            request.session['user_id'] = logged_user.id
            request.session['user_name']= logged_user.first_name
            
            return redirect('/wall')

    return redirect('/login')
def addmessage(request):
    Message.objects.create(
        message=request.POST['textarea'],
        users=User.objects.get(id=request.session['user_id'])
    )
    
    return redirect('/wall')

def logout(request):
    del request.session['user_id']
    return redirect('/login')

def command(request):
    Comment.objects.create(
        comment=request.POST['textarea2'],
        users=User.objects.get(id=request.session['user_id']),
        messages=Message.objects.get(id=request.POST['hide'])
    )
    return redirect('/wall')


def delmessage(request):
    
    mymessage=Message.objects.get(id=request.POST['hide2'])
    z=mymessage.created_at.strftime("%H %M %S")
    print(z)
    mymessage.delete()
    return redirect('/wall')
