from django.urls import path
from . import views

urlpatterns = [
    path('',views.main),
    path('login', views.root),
    path('reg',views.reg),
    path('addmessage',views.addmessage),
    path('wall',views.wall),
    path('logout',views.logout),
    path('createcomment',views.command),
    path('login2',views.login),
    path('deletemessage',views.delmessage),
]
