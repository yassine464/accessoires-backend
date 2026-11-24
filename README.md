# Mini Projet [sprint 03] – Backend (Spring Boot 3.2 + MySQL + JWT)

**Étudiant :** Yassine Khazri
**Entités :** `Accessoire` et `Marque` (un accessoire appartient à une marque)

Les données sont enregistrées dans une base **MySQL** et exposées par des api REST développées avec **Spring Boot**.
Les api sont sécurisées par **JSON Web Token (JWT)** (bonus).

## Structure

| Projet | Port | Rôle |
|---|---|---|
| `users-microservice` | 8081 (`/users`) | authentification : `POST /users/login` renvoie le JWT dans l'en-tête `Authorization` |
| `accessoires-api` | 8082 (`/accessoires`) | api REST des accessoires et des marques, sécurisée par le JWT |

> `accessoires-api` utilise le port 8082 car le port 8080 peut être occupé par un autre programme
> (par exemple Oracle Database). Le port est défini dans `server.port` de `application.properties`
> et dans `src/app/config.ts` du frontend.

## Prérequis
- JDK 17 ou plus, Maven (ou STS / IntelliJ)
- MySQL démarré (XAMPP par exemple), utilisateur `root` sans mot de passe
  (sinon modifier `application.properties`)
- Les bases `users_db` et `accessoires_db` sont créées automatiquement

## Lancer (dans cet ordre)
Un terminal par projet :
```
cd users-microservice
mvn spring-boot:run

cd accessoires-api
mvn spring-boot:run
```
Au premier démarrage, les données de départ sont insérées (marques, accessoires, utilisateurs).

## Utilisateurs
| Login | Mot de passe | Rôles |
|---|---|---|
| admin | 123 | ADMIN, USER : toutes les opérations |
| yassine | 123 | USER : consultation seulement |

## Règles de sécurité
- Toutes les opérations nécessitent un token JWT valide
- **ADMIN** : consulter, ajouter, modifier, supprimer
- **USER** : consulter seulement (GET)

## Endpoints de accessoires-api
Token : `Authorization: Bearer <jwt>`

| Méthode | URL | Rôle |
|---|---|---|
| GET | `/accessoires/api/all` | ADMIN, USER |
| GET | `/accessoires/api/getbyid/{id}` | ADMIN, USER |
| GET | `/accessoires/api/accsmarque/{idMarque}` | ADMIN, USER |
| POST | `/accessoires/api/addacc` | ADMIN |
| PUT | `/accessoires/api/updateacc` | ADMIN |
| DELETE | `/accessoires/api/delacc/{id}` | ADMIN |
| GET | `/accessoires/marque` (liste dans `_embedded.marques`) | ADMIN, USER |
| POST / PUT / DELETE | `/accessoires/marque` , `/accessoires/marque/{id}` | ADMIN |

## Test rapide avec PowerShell
```
$r = Invoke-WebRequest -Uri http://localhost:8081/users/login -Method POST -ContentType "application/json" -Body '{"username":"admin","password":"123"}'
$jwt = $r.Headers["Authorization"]
Invoke-RestMethod -Uri http://localhost:8082/accessoires/api/all -Headers @{Authorization="Bearer $jwt"}
```

## Frontend
Voir le repository FrontEnd (Angular).