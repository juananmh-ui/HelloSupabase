package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
    private static final SessionFactory SESSION_FACTORY = crearSessionFactory();

    private SessionFactoryProvider() {
    }

    private static SessionFactory crearSessionFactory() {
        String username = System.getenv("USERNAME");
        String password = System.getenv("PASSWORD");
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            throw new IllegalStateException(
                    "Configura USERNAME y PASSWORD con el usuario y la contraseña de la base de datos "
                            + "en las variables de entorno de la configuración Main de IntelliJ."
            );
        }
        return new Configuration()
                .configure()
                // Para MySQL local, usar configure("hibernate.cfg.dev.xml") en lugar de configure().
                .setCredentials(username, password)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
