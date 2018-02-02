package by.bsac.server.api.servise;


import by.bsac.server.api.date.dto.FacultyDTO;
import by.bsac.server.api.date.entity.Faculty;
import by.bsac.server.api.servise.dao.TimetableDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TimetableServerImpl implements TimetableServise {

    @Autowired
    private TimetableDAO timetableDAO;

    public void setTimetableDAO(TimetableDAO timetableDAO) {
        this.timetableDAO = timetableDAO;
    }

    @Override
    public List<FacultyDTO> getFacultyList() {
        final List<Faculty> listFaculty = timetableDAO.getListFaculty();


        List<FacultyDTO> facultyDTOS=new ArrayList<>();
        for (Faculty fac:listFaculty) {
         //   System.out.println(  fac);
        }
        
        for (int i=0 ; i<listFaculty.size();i++) {
            FacultyDTO dto=new FacultyDTO();
            dto.setNameFaculty(listFaculty
                    .get(i)
                    .getNameFaculty());
            dto.setIdFaculty(listFaculty
                    .get(i)
                    .getIdFaculty());

//            List<GroupDTO> groupDTOS=new ArrayList<>();
//            List<Group> listGroup=timetableDAO.getLisGroup();
//            for (Group group: listGroup) {
//                GroupDTO groupDTO = new GroupDTO();
//                groupDTO.setIdGroup(group.getIdGroup());
//                groupDTO.setNameGroup(group.getNameGroup());
//                groupDTO.setEduLevel(group.getEduLevel());
//                groupDTO.setIdFaculty(group.getIdFaculty());
//                groupDTO.setIdFlow(group.getIdFlow());
//                groupDTOS.add(groupDTO);

//            }
//            dto.setGroupsByIdFaculty(groupDTOS);
            facultyDTOS.add(dto);


        }

        return facultyDTOS;
    }
}
