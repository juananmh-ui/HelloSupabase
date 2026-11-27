# HelloSupabase

Práctica de Java con Hibernate y PostgreSQL en Supabase.

Al ejecutar `org.example.Main`, se guarda un equipo llamado «Equipo Supabase» y se muestra el listado de la tabla `ad.equipo`. Cada ejecución añade un registro nuevo.

## Requisitos

- JDK 27 y Maven.
- Una conexión PostgreSQL con la tabla `ad.equipo` ya creada: `id` entero autogenerado, `nombre` VARCHAR(100) obligatorio, `categoria` VARCHAR(32) y `disponible` BOOLEAN.

## Ejecución en IntelliJ

1. Abrir el proyecto desde `pom.xml` y cargar sus dependencias Maven.
2. Seleccionar el JDK 27.
3. Revisar la dirección y el usuario de conexión en `src/main/resources/hibernate.cfg.dev.xml`.
4. En la configuración de ejecución `Main`, añadir la variable de entorno `PASSWORD` con la contraseña de la base de datos.
5. Ejecutar `org.example.Main`.

`SessionFactoryProvider` carga `hibernate.cfg.dev.xml` y toma la contraseña de `PASSWORD`. La configuración utiliza `validate`, por lo que la tabla debe existir antes de ejecutar el programa.

Las contraseñas, la configuración local de IntelliJ y los archivos compilados no se incluyen en el repositorio.
