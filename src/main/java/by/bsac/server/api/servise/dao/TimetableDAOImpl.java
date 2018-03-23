package by.bsac.server.api.servise.dao;

import by.bsac.server.api.date.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

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

        Query<Faculty> q = session.createQuery(
                "SELECT  f from Faculty f " +
                "left join fetch f.groupsByIdFaculty gr " +
                "left join fetch gr.flowByIdFlow",Faculty.class);

        List<Faculty> list=q.getResultList();
        faculties =new LinkedHashSet<>(list);

        session.close();

        return faculties;
    }

    @Override
    public Collection<Record> getListRecords() {
        Collection <Record> records;

        Session session = sessionFactory.openSession();

        Query<Record> q=session.createQuery(
                "select r from Record r " +
                "left join fetch r.classroomByIdClassroom " +
                "left join fetch r.subjectForByIdSubjectFor " +
                "left join fetch r.subjectTypeByIdSubjectType " +
                "left join fetch r.cancellationsByIdRecord "
                ,Record.class);

        List<Record> list=q.list();

        records=new LinkedHashSet<>(list);
        session.close();
        return records;
    }

    @Override
    public Collection<Chair> getLisChairsAndLecturers() {
        Collection<Chair> chairs;

        Session session=sessionFactory.openSession();
        Query<Chair> q=session.createQuery(
                "select ch from Chair ch "
                ,Chair.class);

        List<Chair> list=  q.getResultList();

        chairs=new LinkedHashSet<>(list);
        session.close();

        return chairs;
    }


}
