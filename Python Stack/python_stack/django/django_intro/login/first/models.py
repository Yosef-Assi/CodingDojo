from django.db import models
import re
import datetime

class LoginManager(models.Manager):
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
        if postData['birthDay'] > str(datetime.date.today()):
            errors["birthDay"] = "The birthday should be at past"
       

        return errors
        

class Login(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email= models.CharField(max_length=255)
    password= models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    birthday= models.DateField(null=True)
    objects=LoginManager()