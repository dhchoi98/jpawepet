package com.wepet.jpawepet;

import com.wepet.jpawepet.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepository {
    @PersistenceContext
    EntityManager em;

    public Long save(User user){
        em.persist(user);
        return user.getId();
    }

    public User findUserById(Long id){
        return em.find(User.class,id);
    }
}
