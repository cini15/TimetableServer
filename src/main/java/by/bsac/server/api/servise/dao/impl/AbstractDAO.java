package by.bsac.server.api.servise.dao.impl;

import by.bsac.server.api.servise.dao.interfaces.GenericDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


public class AbstractDAO<P, T> implements GenericDAO<P, T> {

    private static final Logger log= LoggerFactory.getLogger(AbstractDAO.class);
    private final Class<P> clazz;

    @Autowired
    private EntityManager manager;


    protected AbstractDAO(Class<P> clazz) {
        this.clazz = clazz;
    }
    @Transactional
    @Override
    public void add(P object) {
        log.debug("add: " + object);
        if (manager.contains(object)) {
            manager.merge(object);
        } else
            manager.persist(object);
        manager.flush();
    }
    @Transactional
    @Override
    public void addAll(List<P> listObject) {
        log.debug("addAll: " + listObject);
        for (P p : listObject) {
            manager.persist(p);
        }
    }

    @Override
    public P getById(T id) {
        log.debug("getById: " + id);
        return manager.find(clazz, id);
    }

    @Override
    public List<P> getAll() {
        log.debug("getAll");
        TypedQuery<P> query;
        query = manager.createQuery("select P from "
                + clazz.getSimpleName()
                + " P", clazz);
        return query.getResultList();
    }
    @Transactional
    @Override
    public void update(P object) {
        log.debug("update: " + object);
        manager.merge(object);
        manager.flush();
    }
    @Transactional
    @Override
    public void updateAll(List<P> listObject) {
        log.debug("updateAll"+listObject);
        for (P p : listObject) {
            manager.merge(p);
        }
    }
    @Transactional
    @Override
    public void delete(P object) {
        log.debug("delete: " + object);
        manager.remove(manager.contains(object) ? object : manager.merge(object));
        manager.flush();
    }



    @Transactional
    @Override
    public void deleteAll(List<P> listObject) {
        log.debug("deleteAll");
        for (P object : listObject) {
            manager.remove(manager.contains(object) ? object : manager.merge(object));
        }
        manager.flush();
    }
}
