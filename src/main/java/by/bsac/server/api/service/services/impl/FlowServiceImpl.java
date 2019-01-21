package by.bsac.server.api.service.services.impl;

import by.bsac.server.api.date.entity.Flow;
import by.bsac.server.api.service.dao.interfaces.FlowDAO;
import by.bsac.server.api.service.dao.interfaces.RecordDAO;
import by.bsac.server.api.service.services.IFlowService;
import by.bsac.server.api.service.services.exception.ServiceException;
import by.bsac.server.api.service.services.exception.ServiceValidationException;
import by.bsac.timetable.service.IValidationService;
import java.util.List;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowServiceImpl implements IFlowService {

  @Autowired
  private IValidationService service;

  @Autowired
  private FlowDAO flowDAO;
  
  @Autowired
  private RecordDAO recordDao;

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public void addFlow(Flow flow) throws ServiceException, ServiceValidationException {
    service.validateFlow(flow, false);
    try {
      flowDAO.add(flow);
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при добавлении потока", e);
    }
  }

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public void updateFlow(Flow flow) throws ServiceException, ServiceValidationException {
    service.validateFlow(flow, true);
    try {
      flowDAO.update(flow);
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при обновлении потока", e);
    }
  }

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public Flow getFlowById(short idFlow) throws ServiceException, ServiceValidationException {
    try {
      return flowDAO.getById(idFlow);
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при получении потока с id: " + idFlow, e);
    }
  }

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public List<Flow> getFlowList() throws ServiceException {
    try {
      return flowDAO.getAll();
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при получении всех потоков", e);
    }
  }

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public void deleteFlow(Flow flow) throws ServiceException, ServiceValidationException {
    //service.validateFlow(flow, true);
    try {
      recordDao.deleteAllRecordsByFlow(flow);
      flowDAO.delete(flow);
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при удалении потока", e);
    }
  }

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  // FIXME: add check of name param
  @Override
  public List<Flow> getFlowListByName(String name)
      throws ServiceException, ServiceValidationException {
    try {
      return flowDAO.getAllWithSimilarName(name);
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при получении потоков", e);
    }
  }
}
