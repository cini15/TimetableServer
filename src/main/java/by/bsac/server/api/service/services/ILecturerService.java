package by.bsac.server.api.service.services;


import by.bsac.server.api.date.entity.Chair;
import by.bsac.server.api.date.entity.Lecturer;
import by.bsac.server.api.service.services.exception.ServiceException;
import by.bsac.server.api.service.services.exception.ServiceValidationException;

import java.util.List;

public interface ILecturerService {

  public void addLecturer(Lecturer lecturer) throws ServiceException, ServiceValidationException;

  public void updateLecturer(Lecturer lecturer) throws ServiceException, ServiceValidationException;

  public Lecturer getLecturerById(short idLecturer) throws ServiceException;

  public List<Lecturer> getAllLecturers() throws ServiceException;

  public void deleteLecturer(Lecturer lecturer) throws ServiceException, ServiceValidationException;

  public List<Lecturer> getLecturersRecordsByChairId(Chair chair)
      throws ServiceException, ServiceValidationException;

  public List<Lecturer> getLecturerListByName(String name)
      throws ServiceException, ServiceValidationException;
}
