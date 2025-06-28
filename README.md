# SkillLink
![Java](https://img.shields.io/badge/Java-17%2B-blue?logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-Backend-success?logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Project_Builder-orange?logo=apachemaven)
![Node.js](https://img.shields.io/badge/Node.js-16%2B-green?logo=node.js&logoColor=white)
![Express](https://img.shields.io/badge/Express.js-Microservice-black?logo=express&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-Message_Broker-ff6600?logo=rabbitmq&logoColor=white)
![React](https://img.shields.io/badge/React-Frontend-61DAFB?logo=react&logoColor=white)
![TypeScript](https://img.shields.io/badge/TypeScript-4.x-blue?logo=typescript)
![Vite](https://img.shields.io/badge/Vite-Bundler-646CFF?logo=vite&logoColor=white)
![Git](https://img.shields.io/badge/Git-Version_Control-f05033?logo=git&logoColor=white)

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

**Node.js **</br>
Entorno de ejecución utilizado tanto en el frontend como en un microservicio del backend. Es requerido para ejecutar scripts, administrar paquetes y manejar tareas de desarrollo modernas. Requiere versión 16 o superior. </br>
Descargar Node.js

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
=======
# ✨ SkillLink ✨

---

### ¡Bienvenido a SkillLink! Tu plataforma todo en uno para crear, gestionar y consumir cursos online.
 
#### ¿Qué problema resolvemos?

En el panorama actual del aprendizaje online, observamos una creciente necesidad de una plataforma que no solo ofrezca cursos, sino que empodere a los usuarios para crear, organizar y acceder al conocimiento de manera eficiente y centralizada. Muchas soluciones existentes son fragmentadas, complejas para los creadores o limitan la interacción. SkillLink nace para cerrar esta brecha, proporcionando un ecosistema intuitivo y robusto donde el proceso de compartir y adquirir habilidades se simplifica, fomentando una comunidad dinámica y un acceso sin precedentes al aprendizaje.

#### ¿Cómo lo logramos?

Este monorepo alberga una potente aplicación backend desarrollada con Spring Boot y un frontend dinámico construido con React.js (TypeScript) y Vite. Esta combinación nos permite ofrecer una experiencia fluida, segura y escalable, diseñada para llevar tu experiencia de aprendizaje y enseñanza al siguiente nivel.

---

## 🚀 Backend: El Corazón de SkillLink

Nuestro backend, construido con la robustez de **Spring Boot**, es el cerebro detrás de SkillLink, gestionando toda la lógica de negocio, la seguridad y la interacción con la base de datos.

### 🛠️ Guía de Instalación y Uso

Sigue estos sencillos pasos para poner en marcha el backend en tu entorno local.

#### Requisitos Previos

Antes de empezar, asegúrate de tener estas herramientas esenciales instaladas:

* **Java Development Kit (JDK)**:
    * Recomendado: **Java 17 o superior**.
    * [Descargar Oracle JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

* **Apache Maven**:
    * Indispensable para compilar el proyecto y gestionar sus dependencias.
    * [Descargar Apache Maven](https://maven.apache.org/download.cgi)

* **MySQL Workbench**:
    * Para una gestión eficiente de tu base de datos local o para conectarte a una remota (como Railway). ¡Recuerda que necesitarás las credenciales!
    * [Descargar MySQL Workbench](https://dev.mysql.com/downloads/workbench/)

* **Git**:
    * Para clonar este repositorio y mantenerlo sincronizado.
    * [Descargar Git](https://git-scm.com/downloads)

* **IDE Recomendada: IntelliJ IDEA** (o VS Code con soporte para Java):
    * Facilita la ejecución y edición del proyecto.
    * [Descargar IntelliJ IDEA Community Edition (gratuita)](https://www.jetbrains.com/idea/download/?section=windows)

#### Instalación

1.  Abre tu terminal (Git Bash, preferiblemente) y clona el repositorio:

    ```bash
    git clone [https://github.com/dierez00/SkillLink---Jedi.git](https://github.com/dierez00/SkillLink---Jedi.git)
    ```

2.  Navega al directorio del backend:

    ```bash
    cd SkillLink---Jedi/backend
    ```

### 🏃 Uso

Para iniciar el proyecto en un entorno de desarrollo:

1.  Abre **IntelliJ IDEA** y selecciona **"Open"** para abrir la carpeta del proyecto `backend`.
2.  IntelliJ debería detectar automáticamente el proyecto como Maven. Si no es así, puedes configurarlo manualmente:
    `File > Project Structure > Modules > + > Import Module > selecciona pom.xml`
3.  Espera a que IntelliJ descargue todas las dependencias necesarias. Verás una barra de progreso en la parte inferior.
4.  **Configura la conexión a tu base de datos**: Edita el archivo `src/main/resources/application.properties` con tus credenciales de MySQL (local o remota).

    ```properties
    spring.datasource.url=jdbc:mysql://localhost/skilllink_db
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    ```

5.  Ejecuta la clase principal del proyecto, que contiene `@SpringBootApplication`:
    `src/main/java/com/skilllink/backend/BackendApplication.java`

¡Listo! El backend estará operativo y escuchando en: http://localhost:8081

### 🧪 Pruebas de API con Postman

Hemos facilitado las pruebas de la API con una colección de Postman preconfigurada.

1.  Descarga la colección desde aquí:
    [Descargar colección Postman](https://github.com/dierez00/SkillLink---Jedi/blob/main/backend/SkillLink.postman_collection.json)

2.  Abre **Postman** y haz clic en **"Import"** (esquina superior izquierda).
3.  Selecciona el archivo `.json` que acabas de descargar.
4.  Asegúrate de que tu backend esté ejecutándose en `http://localhost:8081`.
5.  ¡Explora y ejecuta las peticiones para probar todos los endpoints de la API!

### 📂 Estructura del Proyecto

El backend de SkillLink está organizado de manera lógica para facilitar su mantenimiento y escalabilidad:

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
│   │   │               ├── dto/                    # 📦 Clases DTO (entrada y salida de datos)
│   │   │               ├── entity/                 # 🧩 Entidades JPA mapeadas a tablas de la BD (Usuario, Evento, etc.
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
│   │   │               ├── emums                   # 🔢 Enumeraciones y constantes (roles y niveles de habilidad)
│   │   │               ├── errors                  # ⚠️ Excepciones y manejo de errores
│   │   │               ├── mapper                  # 🔄 Conversión entre Entity ↔ DTO (mapeo de objetos)
│   │   │               ├── repository/             # 🗃️ Interfaces JPARepository para interacción con la DB
│   │   │               ├── service/                # 🧠 Servicios de negocio (VerificarService, etc.)
│   │   │               └── BackendApplication.java # 🚀 Clase principal (punto de entrada de Spring Boot)
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
=======
├── pom.xml                                         # 📦 Archivo de configuración de dependencias Maven
└── README.md
```
---

## 💻 Frontend: La Interfaz de Usuario de SkillLink

El frontend de SkillLink, desarrollado con **React.js (TypeScript) y Vite**, ofrece una experiencia de usuario fluida e intuitiva para explorar y gestionar cursos.

### 🛠️ Guía de Instalación y Uso

#### Requisitos Previos

Asegúrate de tener instalados los siguientes programas en tu sistema:

* **Node.js**:
    * Versión **16 o superior** recomendada.
    * [Descargar Node.js](https://nodejs.org/)

* **npm**:
    * Tu gestor de paquetes de elección para el frontend.
    * [Descargar npm](https://www.npmjs.com/) (viene con Node.js)

* **bun** (Opcional):
    * Un runtime y gestor de paquetes alternativo para una experiencia aún más rápida.
    * [Descargar bun](https://bun.sh/)

* **Git**:
    * Para clonar este repositorio.
    * [Descargar Git](https://git-scm.com/)

#### Instalación

1.  Clona el repositorio en tu máquina:

    ```bash
    git clone [https://github.com/dierez00/SkillLink---Jedi.git](https://github.com/dierez00/SkillLink---Jedi.git)
    ```

2.  Navega al directorio del frontend:

    ```bash
    cd SkillLink---Jedi/frontend/SkillLink
    ```

3.  Instala las dependencias. Puedes usar `npm` o `bun`:

    ```bash
    npm install
    ```

    O con `bun`:

    ```bash
    bun install
    ```

### 🏃 Uso

Para iniciar el frontend en modo desarrollo:

```bash
npm run dev
```
O con `bun`:

```bash
bun run dev
```
Esto iniciará el servidor de desarrollo y podrás acceder a la aplicación en tu navegador, usualmente en:
```
http://localhost:5173
```

#### ⚙️ Scripts Disponibles

Estos son los comandos clave para trabajar con el frontend:

   * `npm run dev` / `bun run dev`: Inicia el servidor de desarrollo.

   * `npm run build` / `bun run build`: Genera una versión optimizada para producción.

   * `npm run preview` / `bun run preview`: Previsualiza la versión de producción generada localmente.

   * `npm run lint` / `bun run lint`: Ejecuta el linter para mantener la calidad del código.

#### 📂 Estructura del Proyecto

El frontend está cuidadosamente estructurado para una fácil navegación y escalabilidad:

```
SkillLink/
├── public/                 # Archivos estáticos (favicon, imágenes públicas)
├── src/                    # Código fuente del proyecto
│   ├── assets/             # 🎨 Imágenes, íconos SVG, fuentes, logos
│   │   ├── icons/
│   │   └── images/
│   ├── components/         # 🧩 Componentes reutilizables organizados por tipo
│   │   ├── common/         # Header, Footer, Layouts simples
│   │   ├── features/       # Componentes específicos por funcionalidad/dominio
│   │   ├── layouts/        # Layouts principales (DashboardLayout, AuthLayout)
│   │   ├── modals/         # Modales centralizados
│   │   └── ui/             # Componentes atómicos y reutilizables (Button, Input)
│   ├── context/            # 🧠 Context API providers para gestión de estado global
│   ├── hooks/              # 🪝 Custom hooks reutilizables
│   ├── lib/                # 🧰 Helpers y funciones utilitarias
│   ├── pages/              # 🧭 Rutas de React Router
│   ├── services/           # 🌐 Clientes de API, funciones para llamadas a endpoints
│   ├── types/              # 📐 Tipos globales de TypeScript para asegurar la consistencia de datos
│   ├── App.tsx
│   ├── main.tsx
│   ├── styles.css
│   └── vite-env.d.ts
├── .gitignore
├── eslint.config.js
├── index.html
├── package.json
├── package-lock.json
├── README.md
├── tsconfig.json           # Configuración de TypeScript
├── tsconfig.app.json
├── tsconfig.node.json
└── vite.config.ts
```
