from django.urls import path
from . import views

urlpatterns = [
    path('', views.root),
    path('reg', views.reg),
    path('login',views.login),
    path('pal',views.pal),
    path('logout',views.logout),
]