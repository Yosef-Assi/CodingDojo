from django.urls import path
from . import views

urlpatterns = [
    path('', views.root),
    path('result/',views.result2),
    path('rest/',views.rest)
]
