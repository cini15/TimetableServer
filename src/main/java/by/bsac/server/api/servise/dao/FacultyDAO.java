package by.bsac.server.api.servise.dao;

import by.bsac.server.api.date.entity.Faculty;
import by.bsac.server.api.servise.dao.impl.AbstractDAO;
import org.springframework.stereotype.Repository;

@Repository
public class FacultyDAO extends AbstractDAO<Faculty, Byte> {
    public FacultyDAO() {
        super(Faculty.class);
    }
}
