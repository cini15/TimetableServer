package by.bsac.server.api.servise.dao;

import by.bsac.server.api.date.entity.Faculty;
import by.bsac.server.api.date.entity.Group;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class TimetableDAOImpl implements TimetableDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Faculty> getListFaculty() {

        List<Faculty> faculties;

        Session session = sessionFactory.openSession();

//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Faculty> query = builder.createQuery(Faculty.class);
//        Root<Faculty> facultyRoot = query.from(Faculty.class);
//


//        query.select(facultyRoot);
        Query<Faculty> q = session.createQuery("from Faculty f  ");



        faculties = q.getResultList();
        session.close();

        return faculties;
    }

    @Override
    public List<Group> getLisGroup() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Group.class);
        List<Group> list = criteria.list();
        session.close();
        return list;
    }
}
