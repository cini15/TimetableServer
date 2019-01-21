package by.bsac.server.api.service.dao.interfaces;

import by.bsac.server.api.date.entity.Chair;

import java.util.List;

public interface ChairDAO {
    void add(Chair chair);

    void addAll(List<Chair> listChair);

    void update(Chair chair);

    void updateAll(List<Chair> listChair);

    Chair getById(Byte idChair);

    List<Chair> getAll();

    void delete(Chair chair);
}
