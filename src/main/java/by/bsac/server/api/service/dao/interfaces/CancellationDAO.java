package by.bsac.server.api.service.dao.interfaces;

import by.bsac.server.api.date.entity.Cancellation;

import java.util.List;

public interface CancellationDAO {
    void add(Cancellation object);

    void addAll(List<Cancellation> listCancellation);

    void update(Cancellation object);

    void updateAll(List<Cancellation> listCancellation);

    void delete(Cancellation object);

    void deleteAll(List<Cancellation> listCancellation);

    Cancellation getById(Integer id);

    List<Cancellation> getAll();
}
