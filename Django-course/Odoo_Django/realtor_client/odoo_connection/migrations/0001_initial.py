# Generated by Django 4.1.4 on 2022-12-21 14:04

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='OdooUser',
            fields=[
                ('odoo_id', models.BigIntegerField(primary_key=True, serialize=False)),
                ('password', models.CharField(max_length=255)),
            ],
        ),
    ]
