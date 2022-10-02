from django.shortcuts import render,HttpResponse,redirect
from .models import Users
def hello(request):
    context = {
    	"all_the_users": Users.objects.all()
    }   
    return render(request,"DojoSurvey.html",context)
def create_user(request):

    Users.objects.create(first_name=request.POST["name1"],last_name=request.POST["name2"],email=request.POST["name3"],age=request.POST["name4"])
    return redirect("/")
