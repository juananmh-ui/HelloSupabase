package org.example;

public class Main {
    public static void main(String[] args) {
        try (var sessionFactory = SessionFactoryProvider.getSessionFactory()) {
            sessionFactory.inTransaction(session -> {
                Equipo equipo = new Equipo();
                equipo.setNombre("Equipo Supabase");
                equipo.setCategoria("Supabase");
                equipo.setDisponible(false);
                session.persist(equipo);
            });

            sessionFactory.inSession(session -> {
                var equipos = session.createQuery("from Equipo order by id", Equipo.class).list();
                equipos.forEach(System.out::println);
                System.out.println("Total de equipos: " + equipos.size());
            });
        }
    }
}
