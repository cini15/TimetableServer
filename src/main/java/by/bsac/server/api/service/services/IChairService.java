package by.bsac.server.api.service.services;


import by.bsac.server.api.date.entity.Chair;
import by.bsac.server.api.service.services.exception.ServiceException;
import by.bsac.server.api.service.services.exception.ServiceValidationException;

import java.util.List;

public interface IChairService {

  public void addChair(Chair chair) throws ServiceException, ServiceValidationException;

  public void updateChair(Chair chair) throws ServiceException, ServiceValidationException;

  public Chair getChairById(byte idChair) throws ServiceException, ServiceValidationException;

  public List<Chair> getAllChair() throws ServiceException;

  public void deleteChair(Chair chair) throws ServiceException, ServiceValidationException;
}
