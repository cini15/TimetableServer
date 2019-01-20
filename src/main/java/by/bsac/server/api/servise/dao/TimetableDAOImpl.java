package by.bsac.server.api.servise.dao;

import by.bsac.server.api.date.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

//        Collection<Faculty> faculties;

        Collection<Faculty> list= sessionFactory.createQuery(
                "SELECT  f from Faculty f " +
                        "left  join fetch f.groupsByIdFaculty gr " +
                        "left  join fetch  gr.flowByIdFlow",Faculty.class)
                .getResultList();
//        faculties =new LinkedHashSet<>(list);

        return new LinkedHashSet<>(list);
    }

    @Override
    public Collection<Record> getListRecords() {
//        Collection <Record> records;

        List<Record> list=sessionFactory.createQuery(
                "select r from Record r " +
                "left join fetch r.classroomByIdClassroom " +
                "left join fetch r.subjectForByIdSubjectFor " +
                "left join fetch r.subjectTypeByIdSubjectType " +
                "left join fetch r.cancellationsByIdRecord "
                ,Record.class)
                 .getResultList();
        return new LinkedHashSet<>(list);
    }

    @Override
    public Collection<Chair> getLisChairsAndLecturers() {
//        Collection<Chair> chairs;
        List<Chair> list=sessionFactory.createQuery(
                "select ch from Chair ch "
                ,Chair.class).getResultList();


//        chairs=new LinkedHashSet<>(list);


        return new LinkedHashSet<>(list);
    }

    @Override
    public Collection<Subject> getListSubjects() {

//        Collection<Subject> subjects;
        List<Subject> list=sessionFactory.createQuery(
                "select su from Subject su "
                ,Subject.class)
                .getResultList();


//        subjects=new LinkedHashSet<>(list);
        return new LinkedHashSet<>(list);
    }
}
