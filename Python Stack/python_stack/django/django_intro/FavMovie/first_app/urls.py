from django.urls import path
from . import views

urlpatterns = [
    path('', views.root),
    path('reg',views.reg),
    path('login',views.login),
    path('movies',views.movies),
    path('gomovie',views.gomovie),
    path('addmovie',views.addmovie),
    path('addfav/<int:id>',views.addfav),
    path('admin',views.admin),
    path('delfav/<int:id>',views.delfav),
    path('delmov/<int:id>',views.delmov),
    path('logout',views.logout)

]