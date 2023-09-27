package com.example.ProjectBoot.dao;
//убрал импорты
import com.example.ProjectBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override //убрал transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }
    public User show(int id){
        TypedQuery<User> q = entityManager.createQuery("select u from User u where u.id = :id", User.class);

        q.setParameter("id", id);
        return q.getResultList().stream().findAny().orElse(null);
    }


    public void update(int id, User updatedUser){ //убрал transactional
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.contains(show(id)) ? show(id) : entityManager.merge(show(id)));
    }

}
