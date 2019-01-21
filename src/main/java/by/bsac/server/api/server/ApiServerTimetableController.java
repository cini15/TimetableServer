package by.bsac.server.api.server;


import by.bsac.server.api.date.TransformEntityToDTO;
import by.bsac.server.api.date.dto.ChairDTO;
import by.bsac.server.api.date.dto.FacultyDTO;
import by.bsac.server.api.date.dto.RecordDTO;
import by.bsac.server.api.date.dto.SubjectDTO;
import by.bsac.server.api.date.entity.Faculty;
import by.bsac.server.api.date.entity.Record;
import by.bsac.server.api.service.TimetableServise;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiServerTimetableController {

    private static final Logger log= LoggerFactory.getLogger(ApiServerTimetableController.class);

    private TimetableServise timetable;
    private final TransformEntityToDTO toDTO;
    private final ModelMapper modelMapper;

    @Autowired
    public ApiServerTimetableController(TransformEntityToDTO toDTO, ModelMapper modelMapper) {
        this.toDTO = toDTO;
        this.modelMapper = modelMapper;
    }

    @Autowired()
    public void setTimetable(TimetableServise timetable) {
        this.timetable = timetable;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        log.debug("Debug TEST");

        return "test";
    }

    @GetMapping(value = "/faculty")
    public ResponseEntity<List<FacultyDTO>> facultyList(){
        log.debug("call function /FACULTY");
        List<FacultyDTO> facultyDTOS=new ArrayList<>();
        for (Faculty faculty:timetable.getFacultyList()) {
            facultyDTOS.add(modelMapper.map(faculty,FacultyDTO.class));
        }
        return ResponseEntity.ok().body(facultyDTOS);
    }
    @GetMapping(value ="/records")
    public ResponseEntity<List<RecordDTO>> getRecordsList(){
        log.debug("call function /RECORDS");
        List<RecordDTO> recordDTOS=new ArrayList<>();
        for (Record r :timetable.getRecordsList()) {
            recordDTOS.add(modelMapper.map(r,RecordDTO.class));
        }
        return ResponseEntity.ok().body(recordDTOS);
    }

    @GetMapping(value ="/chairs")
    public ResponseEntity<List<ChairDTO>> getChairsList(){
        log.debug("call function /CHAIRS");
        return ResponseEntity.ok().body(toDTO.getListChairDTO(timetable.getChairsList()));
    }
    @GetMapping(value = "/subjects")
    public ResponseEntity<List<SubjectDTO>> getSubjects(){
        log.debug("call function /subjects");
        return ResponseEntity.ok().body(toDTO.getListSubjectDTO(timetable.getSubjectsList()));
    }
}
