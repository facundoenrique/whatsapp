Para ejecutar el proyecto se necesita descargar 
PostgreSQL 9.6 o superior (https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)
JDK 11
IDE a elección

El proyecto está construido con Gradle, por lo que se va a encargar de descargar automáticamente 
todas las dependencias necesarias para su ejecución.
Para la creación de la base de datos y sus tablas hay un script dentro de resources/database/create_groups.sql


cURL para realizar pruebas
curl --location --request POST 'localhost:8080/whatsapp/api/groups/' \
--header 'Content-Type: application/json' \
--data-raw '{
"userId":13456,
"groupId":10,
"message":"Hola",
"dateSend":"2017-07-03T22:35:29.771+05:30"
}'

