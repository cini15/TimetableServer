package by.bsac.server.api.servise;


import by.bsac.server.api.date.entity.Faculty;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TimetableImpl implements Timetable {
    @Override
    public List<Faculty> getFacultyList() {
        return null;
    }
}
