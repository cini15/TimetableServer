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
    private TransformEntityToDTO transformEntityToDTO;

    @Autowired
    private TimetableDAO timetableDAO;

    public void setTimetableDAO(TimetableDAO timetableDAO) {
        this.timetableDAO = timetableDAO;
    }

    public void setTransformEntityToDTO(TransformEntityToDTO transformEntityToDTO) {
        this.transformEntityToDTO = transformEntityToDTO;
    }

    @Override
    public List<FacultyDTO> getFacultyList() {
        final Collection<Faculty> listFaculty = timetableDAO.getListFacultyAndGroups();

        List<FacultyDTO> facultyDTOS;

        facultyDTOS = transformEntityToDTO.getListFacultyDTO(listFaculty);

        return facultyDTOS;
    }

    @Override
    public List<RecordDTO> getRecordsList() {
        Collection<Record> records=timetableDAO.getListRecords();

        List<RecordDTO> recordDTOS;

        recordDTOS= transformEntityToDTO.getListRecordDTO(records);



        return recordDTOS;
    }

    @Override
    public List<ChairDTO> getChairsList() {

        Collection<Chair> chairs=timetableDAO.getLisChairsAndLecturers();

        List<ChairDTO> chairDTOS;

        chairDTOS=transformEntityToDTO.getListChairDTO(chairs);
        return chairDTOS;
    }


}
