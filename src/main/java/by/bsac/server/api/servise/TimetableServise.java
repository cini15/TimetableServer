package by.bsac.server.api.servise;

import by.bsac.server.api.date.dto.FacultyDTO;
import by.bsac.server.api.date.entity.Record;

import java.util.List;

public interface TimetableServise {
    public List<FacultyDTO>getFacultyList();
    public List<Record> getRecordsList();

}
