from django.urls import path
from . import views

urlpatterns = [
    path('/', views.main),
    path('/addmessage', views.addmessage),
    path('/logout', views.logout),
    path('/createcomment', views.command),
    path('/deletemessage', views.delmessage),

   
]