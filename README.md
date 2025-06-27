# SkillLink

## Guía de Instalación y Uso

### Requisitos Previos

✅ Asegúrate de tener instalados los siguientes programas en tu sistema antes de comenzar:

**Java Development Kit (JDK)** </br>
Recomendado: Java 17 o superior </br>
[Descargar Oracle JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

**Apache Maven** </br>
Herramienta para compilar y gestionar dependencias del proyecto </br>
[Descargar Apache Maven](https://maven.apache.org/download.cgi)

**MySQL Workbench** </br>
Para gestionar la base de datos localmente o conectarte a la remota (Railway) </br>
Requiere tener acceso a las credenciales de la base de datos </br>
[Descargar MySQL Workbench](https://dev.mysql.com/downloads/workbench/)

**Git** </br>
Para clonar y sincronizar el repositorio </br>
[Descargar Git para Windows (o tu sistema operativo)](https://git-scm.com/download/win)

**IDE recomendada: IntelliJ IDEA (o VS Code con soporte para Java)** </br>
Para ejecutar y editar el proyecto fácilmente </br>
[Descargar IntelliJ IDEA Community Edition (gratuita)](https://www.jetbrains.com/idea/download/?section=windows)

### Instalación

Sigue estos pasos para instalar y configurar el proyecto en tu máquina local:

1. En Git Bash clona el repositorio:

   ```bash
   git clone https://github.com/dierez00/SkillLink---Jedi.git
   ```

2. Navega al directorio del proyecto:

   ```bash
   cd backend
   ```

### Uso

Para iniciar el proyecto en un entorno de desarrollo:

Abre IntelliJ IDEA y selecciona Open para abrir la carpeta del proyecto.

IntelliJ detectará automáticamente el proyecto como un proyecto Maven. Si no lo hace, puedes ir a:

```mathematica
File > Project Structure > Modules > + > Import Module > selecciona pom.xml
```
Espera a que se descarguen las dependencias (verás una barra de progreso abajo).

Configura las variables de entorno necesarias o el archivo application.properties con los datos de conexión a tu base de datos MySQL (local o remota). Un ejemplo básico:

```properties
spring.datasource.url=jdbc:mysql://localhost/skilllink_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

Ejecuta la clase principal del proyecto (que contiene @SpringBootApplication). Se encuentra en:

```css
src/main/java/com/skilllink/backend/BackendApplication.java
```

Una vez iniciado, el backend estará corriendo en:

```arduino
http://localhost:8081
```

### Pruebas con Postman

Para probar los endpoints de la API, puedes utilizar Postman. Ya hemos preparado una colección con las peticiones necesarias.

✅ Pasos para usar la colección:
Descarga la colección desde este enlace:

[Descargar colección Postman](https://github.com/dierez00/SkillLink---Jedi/blob/main/backend/SkillLink.postman_collection.json)

1. Abre Postman y haz clic en Import (esquina superior izquierda).
2. Selecciona el archivo .json descargado de la colección.
3. Asegúrate de que el backend esté ejecutándose en tu máquina local (http://localhost:8081).
4. Ejecuta las peticiones incluidas en la colección para probar los endpoints.


### Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

```
backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── skilllink/
│   │   │           └── backend/
│   │   │               ├── config/                 # ⚙️ Configuración de seguridad y JWT
│   │   │               ├── controller/             # 🎮 Controladores REST (EventoController, UsuarioController, etc.)
│   │   │               ├── dto/                    # 📦 Clases DTO (entrada y salida)
│   │   │               ├── entity/                 # 🧩 Entidades JPA mapeadas a tablas (Usuario, Evento, etc.)
│   │   │               │   ├── categoria/
│   │   │               │   ├── desafio/
│   │   │               │   ├── evento/
│   │   │               │   ├── habilidad/
│   │   │               │   ├── mentoria/
│   │   │               │   ├── mentoriaCategoria/
│   │   │               │   ├── perfil/
│   │   │               │   ├── perfilHabilidad/
│   │   │               │   ├── proyecto/
│   │   │               │   ├── proyectoTecnologia/
│   │   │               │   ├── registroEvento/
│   │   │               │   ├── tecnologia/
│   │   │               │   └── usuario/
│   │   │               ├── repository/             # 🗃️ Interfaces JPARepository
│   │   │               ├── service/                # 🧠 Servicios de negocio (VerificarService, etc.)
│   │   │               └── BackendApplication.java # 🚀 Clase principal (punto de entrada Spring Boot)
│   │   └── resources/
│   │       ├── application.properties              # 🔧 Configuración general (DB, puertos, etc.)
│   │       ├── static/
│   │       └── templates/
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml                                         # 📦 Dependencias Maven
└── README.md

```

### Contribución

Si deseas contribuir al proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama para tu funcionalidad o corrección de errores:

   ```bash
   git checkout -b mi-nueva-funcionalidad
   ```

3. Realiza tus cambios y haz un commit:

   ```bash
   git commit -m "Agrega mi nueva funcionalidad"
   ```

4. Sube tus cambios a tu fork:

   ```bash
   git push origin mi-nueva-funcionalidad
   ```

5. Abre un Pull Request en el repositorio original.
