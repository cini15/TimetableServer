package by.bsac.server.api.servise.dao.impl;

import by.bsac.server.api.date.entity.Faculty;
import by.bsac.server.api.servise.dao.impl.AbstractDAO;
import by.bsac.server.api.servise.dao.interfaces.FacultyDAO;
import org.springframework.stereotype.Repository;

@Repository
public class FacultyDAOImpl extends AbstractDAO<Faculty, Byte> implements FacultyDAO {
    public FacultyDAOImpl() {
        super(Faculty.class);
    }
}
