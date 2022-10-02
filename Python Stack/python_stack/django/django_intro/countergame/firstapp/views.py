
from django.shortcuts import render,HttpResponse,redirect
import random 	

def root(request):
    
    rand=random.randint(1, 100) 
    request.session['rand']=rand
    
    return render(request,"index.html")
    
def result2(request):
    Counter=0
    request.session['rand2']=int(request.POST['rand2'])
    if int(request.POST['rand2']) < request.session['rand'] :
        request.session['result']="LOW!"
        Counter+=1
    elif int(request.POST['rand2'])> request.session['rand'] :
        request.session['result']="High!"
        Counter+=1
    elif int(request.POST['rand2']) == request.session['rand'] :
        request.session['result']="YouWin"
    else:
        request.session['result']="none"
    request.session['count']=Counter
    return redirect("/")

def rest(request):
    del request.session['rand']
    del request.session['rand2']
    return redirect("/")