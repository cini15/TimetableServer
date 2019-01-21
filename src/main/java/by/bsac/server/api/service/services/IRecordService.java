package by.bsac.timetable.service;


import by.bsac.server.api.date.entity.Classroom;
import by.bsac.server.api.date.entity.Group;
import by.bsac.server.api.date.entity.Lecturer;
import by.bsac.server.api.date.entity.Record;
import by.bsac.server.api.service.services.exception.ServiceException;
import by.bsac.server.api.service.services.exception.ServiceValidationException;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IRecordService {

  public void addRecord(Record record) throws ServiceException, ServiceValidationException;

  public void updateRecord(Record initialRecord, Record updateRecord)
      throws ServiceException, ServiceValidationException;

  public Record getRecord(int idRecord) throws ServiceException;

  public void deleteRecord(Record record) throws ServiceException, ServiceValidationException;

  public List<Record> getAllRecordListForGroup(Group group, Date dateFrom, Date dateTo)
      throws ServiceException, ServiceValidationException;

  public void changeClassroomForAllRecords(Classroom oldClassroom, Classroom newClassroom)
      throws ServiceException, ServiceValidationException;

  public void changeLecturerForAllRecords(Lecturer oldLecturer, Lecturer newLecturer)
      throws ServiceException, ServiceValidationException;

}