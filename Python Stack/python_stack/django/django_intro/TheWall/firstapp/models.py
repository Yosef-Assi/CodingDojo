from django.db import models

import re
class UserManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['first_name']) < 2:
            errors["first_name"] = "First name should be at least 2 characters"
        if len(postData['last_name']) < 2:
            errors["last_name"] = "Last name should be at least 2 characters"
        if postData['cpassword']!=postData['password']:
            errors["cpassword"] = "The Confirm password not like Password"
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email']):            
            errors['email'] = "Invalid email format"
        if len(postData['password']) < 8:
            errors["password"] = "The Password should be at least 8 characters"
       

        return errors

class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email= models.CharField(max_length=255)
    password= models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects=UserManager()

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

    
