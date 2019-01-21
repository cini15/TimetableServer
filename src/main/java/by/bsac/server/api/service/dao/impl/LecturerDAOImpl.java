package by.bsac.server.api.service.dao.impl;

import by.bsac.server.api.date.entity.Chair;
import by.bsac.server.api.date.entity.Lecturer;
import by.bsac.server.api.service.dao.interfaces.LecturerDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LecturerDAOImpl extends AbstractDAO<Lecturer,Short> implements LecturerDAO {

    private static final Logger log= LoggerFactory.getLogger(LecturerDAOImpl.class);
    protected LecturerDAOImpl() {
        super(Lecturer.class);
    }

    @Override
    public List<Lecturer> getLecturerListByChair(Chair chair) {
        log.debug("getLecturerListByChair "+ chair);
        return manager.createQuery("select lec from Lecturer lec where lec.chairByIdChair = :chair",Lecturer.class)
                .setParameter("chair",chair)
                .getResultList();
    }

    @Override
    public List<Lecturer> getAllWithSimilarName(String nameLecturer) {
        log.debug("getAllWithSimilarName "+ nameLecturer);
        return manager.createQuery("select lec from Lecturer lec where lec.nameLecturer like :name",Lecturer.class)
                .setParameter("name",nameLecturer+"%")
                .getResultList();
    }
}
