package by.bsac.server.api.servise.dao;

import by.bsac.server.api.date.entity.Chair;
import by.bsac.server.api.date.entity.Faculty;
import by.bsac.server.api.date.entity.Group;
import by.bsac.server.api.date.entity.Record;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Repository
public class TimetableDAOImpl implements TimetableDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Collection<Faculty> getListFacultyAndGroups() {

        Collection<Faculty> faculties;

        Session session = sessionFactory.openSession();

        Query<Faculty> q = session.createQuery("SELECT  f from Faculty f left join fetch f.groupsByIdFaculty gr left join fetch gr.flowByIdFlow",Faculty.class);


        faculties =new HashSet<>(q.list());

        session.close();

        return faculties;
    }

    @Override
    public Collection<Record> getListRecords() {
        Collection <Record> list;

        Session session = sessionFactory.openSession();

        Query<Record> q=session.createQuery("select r from Record r " +
                "left join fetch r.classroomByIdClassroom " +
                "left join fetch r.subjectForByIdSubjectFor " +
                "left join fetch r.subjectTypeByIdSubjectType " +
                "left join fetch r.cancellationsByIdRecord",Record.class);

        list=new HashSet<>(q.list());
        session.close();
        return list;
    }

    @Override
    public Collection<Chair> getLisChairs() {
        return null;
    }
}
