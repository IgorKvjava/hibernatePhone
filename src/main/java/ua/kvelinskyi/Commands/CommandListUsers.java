package ua.kvelinskyi.Commands;

import ua.kvelinskyi.Dao.impl.GenericDaoHibernateImpl;
import ua.kvelinskyi.Dao.interfaces.GenericDao;
import ua.kvelinskyi.entitys.UsersEntity;
import java.util.List;

public class CommandListUsers {

    public List listAllUsers (){
        GenericDaoHibernateImpl<UsersEntity,Integer>  genericDaoHibernate = new GenericDaoHibernateImpl<>(UsersEntity.class);
        List<UsersEntity> usersEntitiesList;
        usersEntitiesList = genericDaoHibernate.getAll();
        return usersEntitiesList;
    }

}
