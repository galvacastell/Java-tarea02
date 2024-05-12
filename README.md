# Java-tarea02

1) Diagrama de arquitectura general:
   ![usuario3](https://github.com/galvacastell/Java-tarea02/assets/166955374/94141050-8c11-4803-9fd2-f48488da4d0e)
   
2) Decisiòn de arquitectura:
   Se eligió API Gateway para aprovechar la centralización de la lógica de enrutamiento y gestión, seguridad y control.
   Se eligió Config Server para centralizar la parametrización.
3) Descripción de cada microservicio y su funcionalidad.
   a) MsUsuario, microservicio de usuarios para realizar CRUD del user, se conecta a PostgreSQL
   b) MsCuenta, microservicio de cuenta para realizar CRUD de cuentas del cliente, se conecta a PostgreSQL
   c) config-Server, se conecta a github para centralizar los parametros de BD
   d) auth-server, para ejecutar oauth2 y JWT en BD h2 de java
   e) gateway, para enrutar los servicios, solo se modifico puerto.
4) Instrucciones, dirigirse a la carpeta SQL y ejecutar los archivos (segùn extensiòn) en el orden de la imagen:
   ![ejecutar](https://github.com/galvacastell/Java-tarea02/assets/166955374/ef59a5f9-b708-4f88-8b2f-7269d52c1aeb)

   A continuaciòn crear las imagenes de los servicios y carga los app en docker.
5) 
