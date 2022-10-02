from django.shortcuts import render,redirect
from django.contrib import messages

from .models import Show


def root(request):
    return redirect('shows/new')
def show(request):    
    return render(request,'show.html')

def newshow(request,id):
    context = {
        "shows":Show.objects.get(id=id)
    }
    return render(request,'newshow.html',context)
def createshow(request):
    errors=Show.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for k, v in errors.items():
            messages.error(request, v)
        return redirect('/shows/new')
    else:
        t1=Show.objects.create(title=request.POST['title'],network=request.POST['network'],relasedate=request.POST['relasedate'],description=request.POST['description'])
        ids=t1.id
            # context= {
            #     "createid":Show.objects.last(),
            #     "showid":Show.objects.get(id=id),
            # }
        return redirect(f"/show/{ids}")

def shows(request):
    context = {
        "allshows":Show.objects.all()
    }
    return render(request,'allshow.html',context)

def editshow(request,id):
    context = {
        "editshow":Show.objects.get(id=id)
    }
    return render(request,'edit.html',context)

def update(request,id):
    errors=Show.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for k, v in errors.items():
            messages.error(request, v)
        return redirect('/show/'+str(id)+'/edit')
    show=Show.objects.get(id=id)
    show.title=request.POST['title']
    show.network=request.POST['network']
    show.relasedate=request.POST['relasedate']
    show.description=request.POST['description']
    show.save()
    #birthday = datetime.datetime.strptime(userinput, '%d-%m-%Y').date()
    return redirect(f"/show/{id}")


def destroy(request,id):
    show=Show.objects.get(id=id)
    show.delete()
    return redirect("/shows")