package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
    private static final SessionFactory SESSION_FACTORY = crearSessionFactory();

    private SessionFactoryProvider() {
    }

    private static SessionFactory crearSessionFactory() {
        String password = System.getenv("PASSWORD");
        if (password == null || password.isBlank()) {
            throw new IllegalStateException(
                    "Configura PASSWORD con la contraseña de la base de datos de Supabase "
                            + "en las variables de entorno de la configuración Main de IntelliJ."
            );
        }
        return new Configuration().configure("hibernate.cfg.dev.xml")
                .setProperty("hibernate.connection.password", password)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
