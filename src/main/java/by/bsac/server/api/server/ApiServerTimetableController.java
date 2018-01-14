package by.bsac.server.api.server;


import by.bsac.server.api.servise.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiServerTimetableController {


    @Autowired()
    private Timetable timetable;


    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/faculty",method = RequestMethod.GET)
    public String facultyList(){
        String str="1";

        return str;
    }
}
