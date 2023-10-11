from django.db import models

# Create your models here.

class OdooUser(models.Model):
    odoo_id = models.BigIntegerField(primary_key=True)
    password = models.CharField(max_length=255)