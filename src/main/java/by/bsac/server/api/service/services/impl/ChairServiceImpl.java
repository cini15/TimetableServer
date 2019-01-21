package by.bsac.server.api.service.services.impl;


import by.bsac.server.api.date.entity.Chair;
import by.bsac.server.api.service.dao.interfaces.ChairDAO;
import by.bsac.server.api.service.services.IChairService;
import by.bsac.server.api.service.services.exception.ServiceException;
import by.bsac.server.api.service.services.exception.ServiceValidationException;
import by.bsac.timetable.service.IValidationService;
import java.util.List;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChairServiceImpl implements IChairService {
  @Autowired
  private IValidationService service;

  @Autowired
  private ChairDAO dao;

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public void addChair(Chair chair) throws ServiceException, ServiceValidationException {
    service.validateChair(chair, false);
    try {
      dao.add(chair);
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при добавлении кафедры", e);
    }
  }

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public void updateChair(Chair chair) throws ServiceException, ServiceValidationException {
    service.validateChair(chair, true);
    try {
      dao.update(chair);
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при обновлении кафедры", e);
    }
  }

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public Chair getChairById(byte idChair) throws ServiceException {
    try {
      return dao.getById(idChair);
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при поиске кафедры", e);
    }
  }

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public List<Chair> getAllChair() throws ServiceException {
    try {
      return dao.getAll();
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при получении списка кафедр", e);
    }
  }

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public void deleteChair(Chair chair) throws ServiceException, ServiceValidationException {
    service.validateChair(chair, true);
    try {
      dao.delete(chair);
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при удалении", e);
    }
  }
}
