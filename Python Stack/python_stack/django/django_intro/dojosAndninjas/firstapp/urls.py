#from django.contrib import admin
from django.urls import path
from . import views

urlpatterns = [
    path('', views.root),
    path('ninja',views.create_ninja),
    path('dojo',views.create_dojos),
    path('delete',views.delete_dojo),
    

]