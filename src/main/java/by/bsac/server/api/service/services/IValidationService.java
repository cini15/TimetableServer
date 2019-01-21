package by.bsac.timetable.service;


import by.bsac.server.api.date.entity.*;
import by.bsac.server.api.service.services.exception.ServiceValidationException;

import java.util.Date;

public interface IValidationService {

  public void validateRecord(Record record, boolean withId) throws ServiceValidationException;

  public void validateFaculty(Faculty faculty, boolean withId) throws ServiceValidationException;

  public void validateChair(Chair chair, boolean withId) throws ServiceValidationException;

  public void validateSubject(Subject subject, boolean withId) throws ServiceValidationException;

  public void validateLecturer(Lecturer lecturer, boolean withId) throws ServiceValidationException;

  public void validateClassroom(Classroom classroom, boolean withId)
      throws ServiceValidationException;

  public void validateGroup(Group group, boolean withId) throws ServiceValidationException;

  public void validateFlow(Flow flow, boolean withId) throws ServiceValidationException;

  public void validateEducationLevel(byte educationLevel) throws ServiceValidationException;

  public void validateDates(Date dateFrom, Date dateTo) throws ServiceValidationException;
}
