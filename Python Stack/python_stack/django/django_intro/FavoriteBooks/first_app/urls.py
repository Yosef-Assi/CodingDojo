from django.urls import path
from . import views

urlpatterns = [
    path('',views.root),
    path('reg',views.reg),
    path('books',views.books),
    path('login',views.login),
    path('addbook',views.addbook),
    path('logout',views.logout),
    path('favbooks/<int:id>',views.favbooks),
    path('addfav/<int:id>',views.addfav),
    path('unfav/<int:id>',views.unfav),
    path('update/<int:id>',views.update),
        path('addfav2/<int:id>',views.addfav2),




]