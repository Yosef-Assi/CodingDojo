from django.db import models
import datetime

class ShowManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid field
        if len(postData["title"]) < 2:
            errors["title"] = "Show title should be at least 2 characters"
        if len(postData["network"]) < 3:
            errors["network"] = "Show nework should be at least 3 characters"
        if len(postData['description']) < 10  and len(postData['description']) != 0:
            errors["description"] = "Show description should at least 10 characters or 0"
        if postData['relasedate'] > str(datetime.date.today()):
            errors["relasedate"] = "Show relasedate should be older than todys date"
        return errors


class Show(models.Model):
    title=models.CharField(max_length=255)
    network=models.CharField(max_length=255)
    relasedate=models.DateField(blank=True, null=True)
    description=models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects=ShowManager()
    