from django.shortcuts import render,HttpResponse,redirect
from .models import *
from first.models import *
# Create your views here.

def main(request):
    context = {
        "getallmessages":Message.objects.all(),
        "getallcommant":Comment.objects.all(),
    }
    if 'user_id' in request.session:
        return render(request,'comment.html',context)
    else:
        return render(request,'login.html',context)

def addmessage(request):
    Message.objects.create(
        message=request.POST['textarea'],
        users=User.objects.get(id=request.session['user_id'])
    )
    
    return redirect('/wall')

def logout(request):
    del request.session['user_id']
    return redirect('/')

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
