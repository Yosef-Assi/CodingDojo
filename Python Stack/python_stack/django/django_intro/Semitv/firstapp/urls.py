# from django.contrib import admin
from django.urls import path
from . import views

urlpatterns = [
    path('',views.root),
    path('shows/new',views.show),
    path('newshow',views.createshow),
    path('show/<int:id>',views.newshow),
    path('shows',views.shows),
    path('show/<int:id>/edit',views.editshow),
    path('shows/<int:id>/update',views.update),
    path('shows/<int:id>/destroy',views.destroy),

    
]