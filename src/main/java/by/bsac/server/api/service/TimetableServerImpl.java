package by.bsac.server.api.service;


import by.bsac.server.api.date.entity.*;
import by.bsac.server.api.service.dao.TimetableDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.*;

@Controller
public class TimetableServerImpl implements TimetableServise {

    private final TimetableDAO timetableDAO;

    @Autowired
    public TimetableServerImpl(TimetableDAO timetableDAO) {
        this.timetableDAO = timetableDAO;
    }

    @Override
    public List<Faculty> getFacultyList() {

        List<Faculty> faculty = (List<Faculty>) timetableDAO.getListFacultyAndGroups();

        return faculty;
    }

    @Override
    public List<Record> getRecordsList() {

        List<Record> records= (List<Record>) timetableDAO.getListRecords();

        return records;
    }

    @Override
    public List<Chair> getChairsList() {

        List<Chair> chairs= (List<Chair>) timetableDAO.getLisChairsAndLecturers();

      return chairs;
    }

    @Override
    public List<Subject> getSubjectsList() {

        List<Subject> subjects= (List<Subject>) timetableDAO.getListSubjects();

        return subjects;
    }
}
