package by.bsac.server.api.servise;


import by.bsac.server.api.date.TransformEntityToDTO;
import by.bsac.server.api.date.dto.*;
import by.bsac.server.api.date.entity.*;
import by.bsac.server.api.servise.dao.TimetableDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.*;

@Controller
public class TimetableServerImpl implements TimetableServise {

    @Autowired
    private TimetableDAO timetableDAO;

    @Override
    public Collection<Faculty> getFacultyList() {

        Collection<Faculty> faculty = timetableDAO.getListFacultyAndGroups();

        return faculty;
    }

    @Override
    public Collection<Record> getRecordsList() {

        Collection<Record> records=timetableDAO.getListRecords();

        return records;
    }

    @Override
    public Collection<Chair> getChairsList() {

        Collection<Chair> chairs=timetableDAO.getLisChairsAndLecturers();

      return chairs;
    }

    @Override
    public Collection<Subject> getSubjectsList() {

        Collection<Subject> subjects=timetableDAO.getListSubjects();

        return subjects;
    }
}
