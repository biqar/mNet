package org.jugbd.mnet.dao;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Bazlur Rahman Rokon on 7/5/14.
 */
public interface CrudDao<T, PK extends Serializable> {
    T create(T t);

    T find(PK id);

    T update(T t);

    void delete(PK t);

    long count();

    List<T> findAll();

    public EntityManager getEntityManager();
}
