from django.urls import path
from . import views

urlpatterns = [
    path('', views.root),
    path('author', views.author),
    path('book', views.create_book),
    path('authors', views.create_author),
    path('books/<int:id>', views.show),
    path('createbookauth',views.createbookauth),
    path('authors/<int:id>', views.showauth),
    path('createauth',views.createauth),






]