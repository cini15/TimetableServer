package by.bsac.server.api.service.dao.interfaces;

import java.util.List;

public interface GenericDAO<E,T> {
    void add(E object);

    void addAll(List<E> listObject);

    void update(E object);

    void updateAll(List<E> listObject);

    void delete(E object);

    E getById(T id);

    List<E> getAll();

    void deleteAll(List<E> listObject);
}
