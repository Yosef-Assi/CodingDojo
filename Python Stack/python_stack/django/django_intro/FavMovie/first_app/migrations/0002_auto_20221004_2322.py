# Generated by Django 2.2.4 on 2022-10-04 20:22

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('first_app', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='movie',
            name='year',
            field=models.CharField(max_length=5),
        ),
    ]