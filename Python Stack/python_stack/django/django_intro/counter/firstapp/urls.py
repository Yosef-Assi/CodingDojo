from django.urls import path
from . import views

urlpatterns = [
    path('counter/', views.index),
    path('', views.index2),
    path('destroy_session/',views.destroy_session),
    path('increment2/',views.increment2),
    path('reset/',views.reset)
]