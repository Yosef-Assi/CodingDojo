#from django.contrib import admin
from django.urls import path,include
from . import views

urlpatterns = [
    path("",views.root),

    path("blogs/",views.new),
    path("blogs/new/",views.new),

    path("blogs/create/",views.create),
    path("blogs/<int:num>/",views.show),
    path("blogs/<int:num>/edit/",views.edit),
    path("blogs/<int:num>/delete/",views.destroy),
    path("blogs/json/",views.json),

   # path('admin/', admin.site.urls),
]