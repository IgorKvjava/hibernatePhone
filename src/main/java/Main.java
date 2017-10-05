import ua.kvelinskyi.Commands.CommandCRUD;
import ua.kvelinskyi.Commands.CommandListUsers;
import ua.kvelinskyi.Dao.impl.GenericDaoHibernateImpl;
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

        CommandListUsers commandListUsers = new CommandListUsers();
        CommandCRUD commandCRUD = new CommandCRUD();
        System.out.println("1-----------------------------------------");

//        UsersEntity usersEntity = new UsersEntity("login2", "password", "userName", "user");
//        commandCRUD.CreateUser(usersEntity);

//        PhoneBookEntity phoneBookEntity = new PhoneBookEntity();
        System.out.println("2-----------------------------------------");
        HibernateSessionFactory.getInstance().createEntityManager();
        List list = commandListUsers.listAllUsers();
        HibernateSessionFactory.getInstance().getEntityManager().close();

        System.out.println("3-----------------------------------------");
        HibernateSessionFactory.getInstance().createEntityManager();
        List list2 = commandListUsers.listAllUsers();
       // HibernateSessionFactory.getInstance().getEntityManager().close();
        list.forEach(System.out::println);
        list2.forEach(System.out::println);

        HibernateSessionFactory.getInstance().EndSessionFactory();


    }
}