package by.bsac.server.api.service.dao.interfaces;

import by.bsac.server.api.date.entity.Flow;

import java.util.List;

public interface FlowDAO {
    void add(Flow flow);

    void addAll(List<Flow> listFlow);

    void update(Flow flow);

    Flow getById(Short idFlow);

    List<Flow> getAll();

    void delete(Flow flow);

    List<Flow> getAllWithSimilarName(String nameFlow);
}
