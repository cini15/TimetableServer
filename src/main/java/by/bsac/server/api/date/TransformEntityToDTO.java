package by.bsac.server.api.date;

import by.bsac.server.api.date.dto.*;
import by.bsac.server.api.date.entity.Chair;
import by.bsac.server.api.date.entity.Faculty;
import by.bsac.server.api.date.entity.Record;
import by.bsac.server.api.date.entity.Subject;

import java.util.Collection;
import java.util.List;


public interface TransformEntityToDTO {

    List<FacultyDTO> getListFacultyDTO(Collection<Faculty> faculties);
    List<RecordDTO> getListRecordDTO(Collection<Record> records);
    List<ChairDTO> getListChairDTO(Collection<Chair> chairs);
    List<SubjectDTO> getListSubjectDTO(Collection<Subject> subjects);
}
