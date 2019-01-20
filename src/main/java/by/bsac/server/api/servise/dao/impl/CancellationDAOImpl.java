package by.bsac.server.api.servise.dao.impl;

import by.bsac.server.api.date.entity.Cancellation;
import by.bsac.server.api.servise.dao.interfaces.CancellationDAO;
import org.springframework.stereotype.Repository;

@Repository
public class CancellationDAOImpl extends AbstractDAO<Cancellation, Integer> implements CancellationDAO {
    protected CancellationDAOImpl() {
        super(Cancellation.class);
    }
}
