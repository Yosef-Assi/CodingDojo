from django.shortcuts import render,HttpResponse,redirect

def hello(request):
    request.session['name']=9852
    return render(request,"DojoSurvey.html")
def create_user(request):
    name = request.POST['name']
    select1 = request.POST.get('select8')
    select2 = request.POST['select2']
    textarea=request.POST['textarea']
    Car=request.POST['vehicle']
    fav=request.POST['fav_language']
    context = {
    	"name" : name,
    	"select1" : select1,
        "select2": select2,
        "textarea":textarea,
        "Car":Car,
        "fav":fav,
    }
    return render(request,"DojoSurvey2.html",context)
