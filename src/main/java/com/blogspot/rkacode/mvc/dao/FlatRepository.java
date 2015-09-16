package com.blogspot.rkacode.mvc.dao;
//
//import com.blogspot.rkacode.mvc.entity.Flat;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface FlatRepository extends CrudRepository<Flat, String> {
//
//    Flat findByName(String name);
//
//}

import com.blogspot.rkacode.mvc.entity.Flat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

@Repository
public class FlatRepository {

    @Autowired
    EntityManager entityManager;

    public Flat findById(String flatId) {
        return entityManager.find(Flat.class, flatId);
    }

    public void save(Flat flat) {
        entityManager.persist(flat);
    }

    public Flat findByName(String name) {

        try {
            return (Flat) entityManager.createQuery("from Flat f where f.name = name")
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
}