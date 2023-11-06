# Contexto del proyecto
Parte backend de aplicación creada para gestión de imagenes en la cual se puede guardar, editar, borrar y visualizar sus imagens favoritas.

Enlace para la parte frontend:

https://github.com/crismouta/MyFavoriteImages_Front.git

# Vistas

Home

![home](https://github.com/crismouta/MyFavoriteImages_Back/assets/82060703/98de95dc-f418-48fd-945b-f456dce17488)

Galeria

![galeria](https://github.com/crismouta/MyFavoriteImages_Back/assets/82060703/375bb00f-0960-44d0-b4f1-8fbe590c2406)

Vista

![vista](https://github.com/crismouta/MyFavoriteImages_Back/assets/82060703/a481f8fc-9609-4eb2-aefd-0b1d5973aab7)


# Características generales

-  Visualización de galeria de imagenes con título y descripción.
-  Visualización de cada imagen al darle click tanto a la imagen como a su título.
-  Añadir nuevas imagenes a la galeria.
-  Añadir título y description de la imagen.
-  Editar título y description de la imagen tanto en la galeria como en la vista de la imagen.
-  Cambiar la imagen tanto en la galeria como en la vista de la imagen.
-  Borrar imagenes tanto en la galeria como en la vista de la imagen.


# Instalación


`clonar el repositorio: https://github.com/crismouta/MyFavoriteImages_Back.git`

`configurar las variables de entorno necesarias para conexión con Base de Datos PostgreSQL en el archivo 'src/resources/main/application.properties'.`

- SPRING_DATASOURCE_URL  - url necesaria para conexión con Base deDatos en PostgreSQL

- SPRING_DATASOURCE_USERNAME - nombre de usuario del gestor de base de datos de PostgreSQL (pgAdmin)

- SPRING_DATASOURCE_PASSWORD - contraseña del gestor de base de datos de PostgreSQL (pgAdmin)

`configurar las variables de entorno necesarias para conexión con Cloudinary tanto en el archivo 'src/main/resources/application.properties' como en 'src/test/resources/application.properties'.`

- CLOUDINARY_NAME - nombre de la cuenta que proporciona Cloudinary al crearse una cuenta

- CLOUDINARY_API_KEY - api key que proporciona Cloudinary al crearse una cuenta

- CLOUDINARY_API_SECRET - api secret que proporciona Cloudinary al crearse una cuenta


## Running app

`Ejecutar la aplicación Java desde tu IDE favorito`

## Running Tests

`Ejecutar el entorno de tests Junit desde tu IDE favorito`

## Metodología de trabajo, arquitectura y técnicas

-   MVC
-   Patrón de diseño Repository
-   Servicios
-   Test


## Herramientas y tecnologías utilizadas
- Java
- Spring Boot
- Junit
- PostgreSQL
- PgAdmin 4
- Cloudinary
- Postman
- Intellij


### Autora

-   Cris Mouta
