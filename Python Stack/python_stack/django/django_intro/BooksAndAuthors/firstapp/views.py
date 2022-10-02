from turtle import title
from django.shortcuts import render,HttpResponse,redirect

from firstapp.models import *

def root(request):
    context = {
    	"all_the_book": Book.objects.all()
    }   
   
    return render(request,"Book.html",context)

def author(request):
    context = {
    	"all_the_author": Author.objects.all()
    }   
   
    return render(request,"Author.html",context)

def create_book(request):

    Book.objects.create(title=request.POST["title"],desc=request.POST["desc"])
    return redirect("/")
    
def create_author(request):
    Author.objects.create(first_name=request.POST["fname"],last_name=request.POST["lname"],notes=request.POST["notes"])
    return redirect("/author")

def show(request,id):
    # sexth.authors.all()
    show_book=Book.objects.get(id=id)
    # show_authors=Author.objects.get(id=request.POST["select1"])
    # show_book.authors.add(show_authors)
    context = {
    	"showbook":Book.objects.get(id=id), 
        "Authors":show_book.authors.all(),
        "all_the_author": Author.objects.all(),
        

    }  
    
    return render(request,"ShowBooks.html",context)

def createbookauth(request):
    show_book=Book.objects.get(id=request.POST["ids"])
    show_authors=Author.objects.get(id=request.POST["select1"])
    show_book.authors.add(show_authors) 
    
    return redirect("/")


def showauth(request,id):
    # sexth.authors.all()
    show_auth=Author.objects.get(id=id)
    # show_authors=Author.objects.get(id=request.POST["select1"])
    # show_book.authors.add(show_authors)
    context = {
    	"showbook":Author.objects.get(id=id), 
        "Authors":show_auth.books.all(),
        "all_the_books": Book.objects.all(),
    }  
    
    return render(request,"ShowAuhors.html",context)
def createauth(request):
    show_author=Author.objects.get(id=request.POST["ids"])
    show_book=Book.objects.get(id=request.POST["select1"])
    show_author.books.add(show_book)
    
    return redirect("/author")