package by.bsac.server.api.date;

import by.bsac.server.api.date.dto.*;
import by.bsac.server.api.date.entity.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TransformEntityToDTOImpl implements TransformEntityToDTO{

    @Override
    public  List<FacultyDTO> getListFacultyDTO(Collection<Faculty> faculties){

        List<FacultyDTO> facultyDTOS =new ArrayList<>();


        for (Faculty faculty:faculties) {
            FacultyDTO dto = new FacultyDTO();

            dto.setNameFaculty(faculty
                    .getNameFaculty());
            dto.setIdFaculty(faculty
                    .getIdFaculty());

            Collection<GroupDTO> groupDTOS = new ArrayList<>();
            Set<Group> listGroup = new HashSet<>(faculty.getGroupsByIdFaculty());

            for (Group group : listGroup) {
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
     public List<RecordDTO>getListRecordDTO(Collection<Record> entitys){

        List<RecordDTO> recordDTOS=new ArrayList<>();

        for (Record entity: entitys) {
            RecordDTO recordDTO= new RecordDTO();
            recordDTO.setIdRecord(entity.getIdRecord());
            recordDTO.setWeekNumber(entity.getWeekNumber());
            recordDTO.setWeekDay(entity.getWeekDay());
            recordDTO.setSubjOrdinalNumber(entity.getSubjOrdinalNumber());
            recordDTO.setIdGroup(entity.getIdGroup());
            recordDTO.setIdSubject(entity.getIdSubject());
            recordDTO.setIdLecturer(entity.getIdLecturer());
            recordDTO.setIdSubjectType(entity.getIdSubjectType());
            recordDTO.setIdSubjectFor(entity.getIdSubjectFor());
            recordDTO.setDateFrom(entity.getDateFrom());
            recordDTO.setDateTo(entity.getDateTo());
            recordDTO.setIdClassroom(entity.getIdClassroom());

            SubjectTypeDTO subjectTypeDTO = new SubjectTypeDTO();
            subjectTypeDTO.setId(entity.getSubjectTypeByIdSubjectType().getId());
            subjectTypeDTO.setName(entity.getSubjectTypeByIdSubjectType().getName());
            recordDTO.setSubjectTypeByIdSubjectType(subjectTypeDTO);

            SubjectForDTO subjectForDTO =new SubjectForDTO();
            subjectForDTO.setId(entity.getSubjectForByIdSubjectFor().getId());
            subjectForDTO.setName(entity.getSubjectForByIdSubjectFor().getName());
            recordDTO.setSubjectForByIdSubjectFor(subjectForDTO);

            ClassroomDTO classroomDTO= new ClassroomDTO();
            classroomDTO.setIdClassroom(entity.getClassroomByIdClassroom().getIdClassroom());
            classroomDTO.setBuilding(entity.getClassroomByIdClassroom().getBuilding());
            classroomDTO.setNumber(entity.getClassroomByIdClassroom().getNumber());
            recordDTO.setClassroomByIdClassroom(classroomDTO);





            recordDTOS.add(recordDTO);


        }



        return recordDTOS;
    }

    @Override
    public List<ChairDTO> getListChairDTO(Collection<Chair> chairs) {
        return null;
    }

    @Override
    public List<SubjectDTO> getListSubjectDTO(Collection<Subject> subjects) {
        return null;
    }
}
