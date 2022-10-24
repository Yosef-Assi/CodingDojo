# Generated by Django 2.2.4 on 2022-10-06 07:09

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('first_app', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Plant',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('species', models.CharField(max_length=255)),
                ('location', models.CharField(max_length=255)),
                ('reason', models.CharField(max_length=255)),
                ('date_planed', models.DateField()),
                ('created_at', models.DateTimeField(auto_now_add=True)),
                ('updated_at', models.DateTimeField(auto_now=True)),
                ('planted_by', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='planted', to='first_app.User')),
            ],
        ),
    ]
