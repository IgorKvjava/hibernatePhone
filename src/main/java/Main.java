import ua.kvelinskyi.Commands.CommandCRUD;
import ua.kvelinskyi.Commands.CommandListUsers;
import ua.kvelinskyi.HibernateSessionFactory;
import ua.kvelinskyi.entitys.PhoneBookEntity;
import ua.kvelinskyi.entitys.UsersEntity;

import java.util.List;

public class Main {

    public static void main(final String[] args) throws Exception {

        /*SessionFactory sessionFactory = (SessionFactory)
                Persistence.createEntityManagerFactory
                        ("org.hibernate.tutorial.jpa");
        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();
        UsersEntity user = new UsersEntity();
        user.setUserName("Rulon");
        user.setRole("Admin");
        user.setLogin("admin1");
        user.setPassword("1");
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        entityManager.close();*/

        HibernateSessionFactory hibernateSessionFactory = new HibernateSessionFactory();
        CommandListUsers commandListUsers = new CommandListUsers();
        CommandCRUD commandCRUD = new CommandCRUD();
        System.out.println("1-----------------------------------------");
        UsersEntity usersEntity = new UsersEntity("login2", "password", "userName", "user");
        commandCRUD.CreateUser(usersEntity);
        System.out.println("2-----------------------------------------");
        List list = commandListUsers.listAllUsers();

        list.forEach(System.out::println);
        hibernateSessionFactory.shutdown();


    }
}