package by.bsac.server.api.servise;


import by.bsac.server.api.date.dto.FacultyDTO;
import by.bsac.server.api.date.dto.GroupDTO;
import by.bsac.server.api.date.entity.Faculty;
import by.bsac.server.api.date.entity.Group;
import by.bsac.server.api.date.entity.Record;
import by.bsac.server.api.servise.dao.TimetableDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class TimetableServerImpl implements TimetableServise {

    @Autowired
    private TimetableDAO timetableDAO;

    public void setTimetableDAO(TimetableDAO timetableDAO) {
        this.timetableDAO = timetableDAO;
    }

    @Override
    public List<FacultyDTO> getFacultyList() {
        final Collection<Faculty> listFaculty = timetableDAO.getListFacultyAndGroups();


        List<FacultyDTO> facultyDTOS=new ArrayList<>();
        
        for (Faculty faculty:listFaculty) {
            FacultyDTO dto=new FacultyDTO();

            dto.setNameFaculty(faculty
                    .getNameFaculty());
            dto.setIdFaculty(faculty
                    .getIdFaculty());

            Collection<GroupDTO> groupDTOS=new HashSet<GroupDTO>();
            Set<Group> listGroup= new HashSet<>( faculty.getGroupsByIdFaculty());
            for (Group group: listGroup) {
                GroupDTO groupDTO = new GroupDTO();
                groupDTO.setIdGroup(group.getIdGroup());
                groupDTO.setNameGroup(group.getNameGroup());
                groupDTO.setEduLevel(group.getEduLevel());
                groupDTO.setIdFaculty(group.getIdFaculty());
                groupDTO.setIdFlow(group.getIdFlow());
                groupDTOS.add(groupDTO);

            }
            dto.setGroupsByIdFaculty(groupDTOS);
            facultyDTOS.add(dto);


        }


        return facultyDTOS;
    }

    @Override
    public List<Record> getRecordsList() {
        List<Record> records= new ArrayList<>();
        List<Record> test= (List<Record>) timetableDAO.getListRecords();

        return records;
    }
}
