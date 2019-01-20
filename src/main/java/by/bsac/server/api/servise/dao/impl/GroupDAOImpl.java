package by.bsac.server.api.servise.dao.impl;

import by.bsac.server.api.date.entity.Faculty;
import by.bsac.server.api.date.entity.Flow;
import by.bsac.server.api.date.entity.Group;
import by.bsac.server.api.servise.dao.interfaces.GroupDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupDAOImpl extends AbstractDAO<Group,Short> implements GroupDAO {
    private static final Logger log= LoggerFactory.getLogger(GroupDAOImpl.class);
    protected GroupDAOImpl() {
        super(Group.class);
    }

    @Override
    public List<Group> getGroupListByFaculty(Faculty faculty) {
        log.debug("getGroupListByFaculty "+faculty);
        return manager.createQuery("select gr from Group gr where gr.facultyByIdFaculty= :faculty",Group.class)
                .setParameter("faculty",faculty)
                .getResultList();
    }

    @Override
    public List<Group> getGroupListByFacultyAndEduLevel(Faculty faculty, byte eduLevel) {
        return null;
    }

    @Override
    public List<Group> getGroupListByFlow(Flow flow) {
        return manager.createQuery("select gr from Group gr where gr.flowByIdFlow= :flow",Group.class)
                .setParameter("flow",flow)
                .getResultList();
    }

    @Override
    public List<Group> getAllWithSimilarName(String nameLecturer) {
        return manager.createQuery("select gr from Group gr where gr.nameGroup like :simName",Group.class)
                .setParameter("simName",nameLecturer+"%")
                .getResultList();
    }
}
