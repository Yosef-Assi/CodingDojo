from django.db import models

# Create your models here.
class Book(models.Model):
        title = models.CharField(max_length=255)
        created_at = models.DateTimeField(auto_now_add=True)
        updated_at = models.DateTimeField(auto_now=True)
        desc = models.CharField(max_length=255) 

class Author(models.Model):
        first_name = models.CharField(max_length=255)
        last_name = models.CharField(max_length=255)
        books = models.ManyToManyField(Book, related_name="authors")
        notes=models.CharField(max_length=255)