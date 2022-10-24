from django.urls import path
from . import views

urlpatterns = [
    path('', views.root),
    path('reg',views.reg),
    path('login',views.login),
    path('allplant',views.allplant),
    path('newplant',views.newplant),
    path('addplant',views.addplant),
    path('details/<int:id>',views.details),
    path('mytree',views.mytree),
    path('delete/<int:id>',views.delete),
    path('update/<int:id>',views.update),
    path('editpage/<int:id>',views.editpage),
    path('logout',views.logout),
    path('addvisit/<int:id>',views.addvisit),
]
