package by.bsac.server.api.servise.dao.impl;

import by.bsac.server.api.date.entity.Chair;
import by.bsac.server.api.servise.dao.interfaces.ChairDAO;
import org.springframework.stereotype.Repository;


@Repository
public class ChairDAOImpl extends AbstractDAO<Chair,Byte> implements ChairDAO {
    protected ChairDAOImpl() {
        super(Chair.class);
    }
}
