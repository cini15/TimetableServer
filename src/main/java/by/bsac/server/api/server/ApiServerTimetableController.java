package by.bsac.server.api.server;


import by.bsac.server.api.date.TransformEntityToDTO;
import by.bsac.server.api.date.dto.ChairDTO;
import by.bsac.server.api.date.dto.FacultyDTO;
import by.bsac.server.api.date.dto.RecordDTO;
import by.bsac.server.api.date.dto.SubjectDTO;
import by.bsac.server.api.servise.TimetableServise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiServerTimetableController {

    private static final Logger log= LoggerFactory.getLogger(ApiServerTimetableController.class);

    private TimetableServise timetable;
    private final TransformEntityToDTO toDTO;

    @Autowired
    public ApiServerTimetableController(TransformEntityToDTO toDTO) {
        this.toDTO = toDTO;
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
        return ResponseEntity.ok().body(toDTO.getListFacultyDTO(timetable.getFacultyList()));
    }
    @GetMapping(value ="/records")
    public ResponseEntity<List<RecordDTO>> getRecordsList(){
        log.debug("call function /RECORDS");
        return ResponseEntity.ok().body(toDTO.getListRecordDTO(timetable.getRecordsList()));
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
