package com.revolhope.deepdev.myjavalibrary.db.jdbc;

import java.io.Serializable;

public interface IDatabase<ID extends Serializable, T>
{
    T findById(ID id);
    boolean exists(T entity);
    void persist(T entity);
    void update(T entity);
    void delete(T entity);
}
