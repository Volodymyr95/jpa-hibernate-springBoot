package com.example.demo.reposity;

import com.example.demo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public User upsert(User user) {
        return entityManager.merge(user);
    }

    public List<User> getAll() {
        return entityManager.createQuery("Select user From User user ").getResultList();
    }

    public List<User> getByAge(int age) {
        Query query = entityManager.createQuery("SELECT user FROM User user WHERE user.age=:age");
        query.setParameter("age", age);

        return query.getResultList();
    }

    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
