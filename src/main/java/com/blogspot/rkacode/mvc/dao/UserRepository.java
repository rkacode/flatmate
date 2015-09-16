package com.blogspot.rkacode.mvc.dao;
//
//import com.blogspot.rkacode.mvc.entity.User;
//import org.springframework.data.repository.CrudRepository;
//
//public interface UserRepository extends CrudRepository <User, String> {
//
//    User findByEmail(String email);
//
//
//}

import com.blogspot.rkacode.mvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

@Repository
public class UserRepository {

    @Autowired
    EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }

    public User findByEmail(String email) {
        try {
            return (User) entityManager.createQuery("from User u where u.email = :email")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public User findById(String userId) {
        return entityManager.find(User.class, userId);
    }
}