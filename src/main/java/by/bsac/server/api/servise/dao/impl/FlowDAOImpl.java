package by.bsac.server.api.servise.dao.impl;

import by.bsac.server.api.date.entity.Flow;
import by.bsac.server.api.servise.dao.interfaces.FlowDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlowDAOImpl extends AbstractDAO<Flow,Short> implements FlowDAO {
    private static final Logger log= LoggerFactory.getLogger(FlowDAOImpl.class);
    protected FlowDAOImpl() {
        super(Flow.class);
    }

    @Override
    public List<Flow> getAllWithSimilarName(String nameFlow) {
        return null;
    }
}
