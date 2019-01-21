package by.bsac.server.api.service.dao;

import by.bsac.server.api.date.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.*;


@Repository
public class TimetableDAOImpl implements TimetableDAO {

    private final EntityManager sessionFactory;

    @Autowired
    public TimetableDAOImpl(EntityManager sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Collection<Faculty> getListFacultyAndGroups() {



        Collection<Faculty> list= sessionFactory.createQuery(
                "SELECT  f from Faculty f "
                        ,Faculty.class)
                .getResultList();
        return  list;
    }

    @Override
    public Collection<Record> getListRecords() {
//        Collection <Record> records;

        List<Record> list=sessionFactory.createQuery(
                "select r from Record r "
                ,Record.class)
                 .getResultList();
        return list;
    }

    @Override
    public Collection<Chair> getLisChairsAndLecturers() {
//        Collection<Chair> chairs;
        List<Chair> list=sessionFactory.createQuery(
                "select ch from Chair ch "
                ,Chair.class).getResultList();


//        chairs=new LinkedHashSet<>(list);


        return (list);
    }

    @Override
    public Collection<Subject> getListSubjects() {

//        Collection<Subject> subjects;
        List<Subject> list=sessionFactory.createQuery(
                "select su from Subject su "
                ,Subject.class)
                .getResultList();


//        subjects=new LinkedHashSet<>(list);
        return (list);
    }
}
