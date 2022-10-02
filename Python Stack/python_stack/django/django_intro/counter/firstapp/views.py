from django.shortcuts import render,HttpResponse,redirect

# Create your views here.
def index(request):
    if 'count' in request.session:
        request.session['count']=request.session['count']+1
    else:
        request.session['count']=1
    return render(request,"index.html")
def index2(request):
    if 'count2' in request.session:
        request.session['count2']=request.session['count2']+1
    else:
       request.session['count2']=1

    return render(request,"index.html")

def destroy_session(request):
    del request.session['count']
    return redirect('/counter')

def increment2(request):
    request.session['count']+=1
    return redirect('/counter')

def reset(request):
    request.session['count']=0
    return redirect('/counter')