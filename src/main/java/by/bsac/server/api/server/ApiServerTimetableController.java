package by.bsac.server.api.server;


import by.bsac.server.api.date.dto.FacultyDTO;
import by.bsac.server.api.servise.TimetableServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiServerTimetableController {


    @Autowired()
    private TimetableServise timetable;


    public void setTimetable(TimetableServise timetable) {
        this.timetable = timetable;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @GetMapping(value = "/faculty")
    public ResponseEntity<List<FacultyDTO>> facultyList(){

        List<FacultyDTO> list= timetable.getFacultyList();

        return ResponseEntity.ok().body(list);
    }
}
