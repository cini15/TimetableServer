package by.bsac.server.api.date;

import by.bsac.server.api.date.dto.*;
import by.bsac.server.api.date.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TransformEntityToDTOImpl implements TransformEntityToDTO{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public  List<FacultyDTO> getListFacultyDTO(Collection<Faculty> faculties){

        List<FacultyDTO> facultyDTOS =new ArrayList<>();

        for (Faculty faculty:faculties) {
            FacultyDTO facultyDTO =modelMapper.map(faculty,FacultyDTO.class);
            facultyDTOS.add(facultyDTO);
        }
            return facultyDTOS;
    }

    @Override
     public List<RecordDTO>getListRecordDTO(Collection<Record> entitys){

        List<RecordDTO> recordDTOS=new ArrayList<>();

        for (Record entity: entitys) {
            RecordDTO recordDTO= modelMapper.map(entity,RecordDTO.class);
            recordDTOS.add(recordDTO);
        }
        return recordDTOS;


    }

    @Override
    public List<ChairDTO> getListChairDTO(Collection<Chair> chairs) {
        List<ChairDTO> chairDTOS=new ArrayList<>();

        for (Chair chair:chairs) {
            ChairDTO chairDTO= modelMapper.map(chair,ChairDTO.class);

            chairDTOS.add(chairDTO);
        }

        return chairDTOS;
    }

    @Override
    public List<SubjectDTO> getListSubjectDTO(Collection<Subject> subjects) {
        List<SubjectDTO> subjectDTOS=new ArrayList<>();

        for(Subject subject:subjects){
            SubjectDTO subjectDTO= modelMapper.map(subject,SubjectDTO.class);

            subjectDTOS.add(subjectDTO);
        }
        return subjectDTOS;
    }
}
