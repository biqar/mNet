package org.jugbd.mnet.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Bazlur Rahman Rokon on 7/5/14.
 */
public class CrudDaoImpl<T, PK extends Serializable> implements CrudDao<T, PK> {
    private static final Logger log = LoggerFactory.getLogger(CrudDaoImpl.class);

    protected Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public CrudDaoImpl() {
        log.debug("CrudDaoImpl()");
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass
                .getActualTypeArguments()[0];
    }

    @Override
    public T create(T t) {
        log.debug("create() -{}", t.toString());

        this.entityManager.persist(t);
        this.entityManager.flush();
        this.entityManager.refresh(t);
        return t;
    }

    @Override
    public T find(PK id) {
        log.debug("find() by id - {}", id);

        return this.entityManager.find(entityClass, id);
    }

    @Override
    public T update(T t) {
        log.debug("update() -{}", t.toString());

        return this.entityManager.merge(t);
    }

    @Override
    public void delete(PK id) {
        log.debug("delete() by id - {}", id);

        T ref = this.entityManager.getReference(entityClass, id);
        this.entityManager.remove(ref);
    }

    @Override
    public long count() {
        log.debug("count()");

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        // create the query with result of type long
        CriteriaQuery countCriteria = builder.createQuery(entityClass);
        countCriteria.from(entityClass);
        Root<T> entityRoot = (Root<T>) countCriteria.getRoots().toArray()[0];
        // now add the count projection
        countCriteria.select(builder.count(entityRoot));
        return (Long) entityManager.createQuery(countCriteria).getSingleResult();
    }

    @Override
    public List<T> findAll() {
        log.debug("findAll() ");

        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<T> criteriaQuery = cb.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        TypedQuery<T> query = this.entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        log.debug("getEntityManager()");
        return entityManager;
    }
}
