package com.tatharo.crm.persistence.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import com.tatharo.crm.persistence.model.User;

public class UserRepository extends GenericRepository<User>{
    public List<User> getAll() {
        String sql = "SELECT c FROM Consumer c";
        TypedQuery<User> query = getEntityManager().createQuery(sql, User.class);
        return query.getResultList();
    }
}
