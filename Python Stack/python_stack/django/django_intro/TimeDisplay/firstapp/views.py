from django.shortcuts import render,HttpResponse,redirect,render
from time import gmtime, strftime


def display(request):
    return redirect("/time_display")
def timedisplay(request):
    context = {
        "time2": strftime("%I:%M:%S:%p", gmtime()),
        "time": strftime("%b %d, %Y", gmtime()),

    }
    return render(request,'index.html', context)

    
    


# Create your views here.
