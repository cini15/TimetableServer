package by.bsac.server.api.service.dao.impl;

import by.bsac.server.api.date.entity.Chair;
import by.bsac.server.api.date.entity.Subject;
import by.bsac.server.api.service.dao.interfaces.SubjectDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDAOImpl extends AbstractDAO<Subject,Short> implements SubjectDAO {

    private static final Logger log= LoggerFactory.getLogger(SubjectDAOImpl.class);
    protected SubjectDAOImpl() {
        super(Subject.class);
    }


    @Override
    public List<Subject> getSubjectListByChair(Chair chair) {
        log.debug("getSubjectListByChair "+ chair);
        return manager.createQuery("select sub from Subject sub where sub.chairByIdChair = :chair",Subject.class)
                .setParameter("chair",chair)
                .getResultList();
    }

    @Override
    public List<Subject> getSubjectListByChairAndEduLevel(Chair chair, byte eduLevel) {
        log.debug("getSubjectListByChairAndEduLevel chair: "+ chair+ " eduLevel: "+ eduLevel);
        return manager.createQuery("select sub from Subject sub where sub.eduLevel = :eduLvl and  sub.chairByIdChair = :chair",Subject.class)
                .setParameter("eduLvl",eduLevel)
                .setParameter("chair",chair)
                .getResultList();
    }

    @Override
    public List<Subject> getAllWithSimilarName(String nameSubject) {
        log.debug("getAllWithSimilarName "+ nameSubject);
        return manager.createQuery("select sub from Subject sub where sub.nameSubject like :simName",Subject.class)
                .setParameter("simName",nameSubject+"%")
                .getResultList();
    }
}
