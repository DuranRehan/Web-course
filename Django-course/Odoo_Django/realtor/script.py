import xmlrpc.client
url = "http://localhost:8069"
db = "projet"

common = xmlrpc.client.ServerProxy("{}/xmlrpc/2/common".format(url))
models = xmlrpc.client.ServerProxy("{}/xmlrpc/2/object".format(url))
username = input("Username: ")
if username=="admin":
    uid = common.authenticate(db, "eugene.krabs@he2b.be", "money", {})
    password = "money"
else:
    password = input("Password or api key: ")
    uid = common.authenticate(db, username, password, {})

hasRight = models.execute_kw(
    db,
    uid,
    password,
    "realtor.appartement",
    "check_access_rights",
    ["read"],
    {"raise_exception": False},
)

if hasRight:
    field = input("[Tape /q to exit]\n What are you loocking for : \n")
    while field != "/q":
        appartements = models.execute_kw(
            db,
            uid,
            password,
            "realtor.appartement",
            "search_read",
            [[["name", "like", field]]],
        )
        if len(appartements) == 0:
            print("No search found")
        else:
            for appartement in appartements:
                products = models.execute_kw(
                    db, 
                    uid, 
                    password,
                    'product.product',
                    'search', 
                    [[['appartement_id', 'ilike', appartement['id']]]])
                details = models.execute_kw(db, 
                    uid, 
                    password,
                    'product.product', 'read', [products, ['name', 'free_qty', 'default_code']])
                for detail in details:
                    print("#--------------------------#####---------------------------#")
                    print("Titre: " , detail['name'])
                    print("Référence: ", detail['default_code'])
                    print("Quantité disponible: " , str(detail['free_qty']))
                    print("Titre: " + appartement["name"])
                    print("Description: " + appartement["desc"])
                    print("Date de disponibilitÃ©: " + appartement["date_disponibility"])
                    print("Prix attendu: " + str(appartement["minimal_price"]))
                    print("Surface de l'appartement: "+ str(appartement["superficy_appartement"]))
                    print("Surface de la terasse: " + str(appartement["superficy_terrace"]))
                    print("Surface totale: " + str(appartement["superficy"]))
                    print("Meilleure offre: " + str(appartement["buyer_bid"]))
                    print("#--------------------------#####---------------------------#")
        field = input("[Tape /q to exit]\n What are you loocking for : \n")
