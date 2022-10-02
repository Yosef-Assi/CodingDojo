#from django.contrib import admin
from django.urls import path
from . import views

urlpatterns = [
    path("",views.display),
    path("time_display/",views.timedisplay),
 #   path('admin/', admin.site.urls),
]