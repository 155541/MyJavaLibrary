package com.revolhope.deepdev.myjavalibrary.db.jdbc;

public interface IDatabase<ID, T extends Serializable>
{
    T findById(ID id);
    boolean exists(T entity);
    void persist(T entity);
    void update(T entity);
    void delete(T entity);
}
