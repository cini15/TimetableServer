package by.bsac.server.api.service.services;


import by.bsac.server.api.date.entity.Classroom;
import by.bsac.server.api.date.entity.Record;
import by.bsac.server.api.service.services.exception.ServiceException;
import by.bsac.server.api.service.services.exception.ServiceValidationException;

import java.util.Date;
import java.util.List;

public interface IClassroomService {

  public void addClassroom(Classroom classRoom)
      throws ServiceException, ServiceValidationException;;

  public void updateClassroom(Classroom classRoom)
      throws ServiceException, ServiceValidationException;;

  public Classroom getClassroom(short idClassroom) throws ServiceException;

  public void deleteClassroom(Classroom classRoom)
      throws ServiceException, ServiceValidationException;

  public List<Classroom> getClassroomListByDatesAndRecordParams(Date dateFrom, Date dateTo, Record record)
      throws ServiceException, ServiceValidationException;

  public List<Classroom> getClassroomList() throws ServiceException;
}
