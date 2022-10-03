from django.db import models
from first.models import *
# Create your models here.
class Message(models.Model):
    message = models.CharField(max_length=255)
    users=models.ForeignKey(User,related_name="messages",on_delete = models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


class Comment(models.Model):
    comment = models.CharField(max_length=255)
    users=models.ForeignKey(User,related_name="commentsuser",on_delete = models.CASCADE)
    messages=models.ForeignKey(Message,related_name="messagesuser",on_delete = models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)