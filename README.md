# webProyect
Este es un modelo de `README.md` diseñado para un proyecto profesional de Spring Boot. He estructurado la información pensando en tu flujo de trabajo (Fedora/Bazzite) y siguiendo las mejores prácticas de documentación de software.

---

# 🦷 Consultorio Santa Rosa: Sistema de Agendamiento para Odontología

DentalCare es una API REST robusta construida con **Spring Boot** y **PostgreSQL**, diseñada específicamente para que un odontólogo independiente pueda gestionar su agenda y permitir que los pacientes reserven citas de forma autónoma y eficiente.

## 🛠️ Tecnologías Principales

* **Backend:** Java 25 / Spring Boot 3.x
* **Base de Datos:** PostgreSQL
* **Persistencia:** Spring Data JPA (Hibernate)
* **Seguridad:** Spring Security & JWT (Opcional para el admin)
* **Documentación:** SpringDoc OpenAPI (Swagger)
* **Gestión de Dependencias:** Maven/Gradle

---

## 🚀 Requisitos Previos

> [!NOTE]
> Asegúrate de tener instalados los siguientes paquetes en tu contenedor o sistema:

* **JDK 25**.
* **Maven** 3.9+.
* **PostgreSQL** (o una instancia de Docker/Podman corriendo).

---

## ⚙️ Configuración del Entorno

1. **Clonar el repositorio:**
```bash
git clone https://github.com/tu-usuario/dental-care-system.git
cd dental-care-system

```


2. **Configurar la base de datos:**
Crea una base de datos llamada `dental_db` en PostgreSQL.
3. **Variables de entorno:**
Modifica el archivo `src/main/resources/application.properties` o utiliza variables de entorno:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/dental_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update

```



> [!TIP]
> Si prefieres no instalar PostgreSQL localmente en tu sistema Fedora, puedes levantar un contenedor rápidamente con Podman:
> `podman run --name postgres-dental -e POSTGRES_PASSWORD=pass -p 5432:5432 -d postgres`

---

## 📋 Endpoints Principales (API)

| Método | Endpoint | Descripción |
| --- | --- | --- |
| **GET** | `/api/v1/disponibilidad` | Consulta horarios libres del odontólogo. |
| **POST** | `/api/v1/citas` | Crea una nueva solicitud de cita. |
| **GET** | `/api/v1/pacientes/{id}/citas` | Historial de citas de un paciente. |
| **PATCH** | `/api/v1/citas/{id}/cancelar` | Cancela una cita existente. |

---

## 🛠️ Ejecución y Desarrollo

Para ejecutar la aplicación en modo desarrollo:

```bash
./mvnw spring-boot:run

```

> [!IMPORTANT]
> Una vez iniciada la aplicación, puedes acceder a la interfaz de **Swagger** para probar los endpoints en:
> `http://localhost:8080/swagger-ui/index.html`

---

## 🧪 Pruebas

Para ejecutar la suite de pruebas unitarias e integración:

```bash
./mvnw test

```

> [!CAUTION]
> Asegúrate de que el perfil de `test` esté configurado para usar una base de datos H2 o una instancia de PostgreSQL de pruebas para evitar borrar datos reales.

---

## 🛣️ Roadmap

* [ ] Integración con notificaciones por correo electrónico (Spring Mail).
* [ ] Implementación de recordatorios vía WhatsApp.
* [ ] Panel de administración en React/Angular para el odontólogo.

---

**Desarrollado con ❤️ para la gestión odontológica moderna.**

---

¿Te gustaría que desarrolle la estructura de alguna entidad específica (como la lógica para calcular los slots de tiempo disponibles) o que te ayude con el archivo `docker-compose.yaml` para tu entorno de Bazzite?
