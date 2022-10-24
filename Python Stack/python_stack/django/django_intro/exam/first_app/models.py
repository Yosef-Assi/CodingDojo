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




class PlantManager(models.Manager):
     def basic_validator(self, postData):
        errors = {}
        if len(postData['species']) < 5 or postData['species'] == None:
            errors["species"] = "species should present and at least 5 characters"
        if len(postData['location']) < 2 or postData['location'] == None:
            errors["location"] = "location should present and at least 2 characters"
        if len(postData['reason']) > 50 or postData['reason'] == None:
            errors["reason"] = "reason should present and at max 50 characters"
        return errors

class Plant(models.Model):
    species = models.CharField(max_length=255)
    location = models.CharField(max_length=255)
    reason= models.CharField(max_length=255)
    planted_by= models.ForeignKey(User,related_name="planted",on_delete = models.CASCADE)
    date_planed= models.DateField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    users_who_visit=models.ManyToManyField(User,related_name="visit_user")
    objects=PlantManager()
