package by.bsac.server.api.service.services.impl;

import by.bsac.server.api.date.entity.*;
import by.bsac.server.api.service.dao.interfaces.CancellationDAO;
import by.bsac.server.api.service.dao.interfaces.GroupDAO;
import by.bsac.server.api.service.dao.interfaces.RecordDAO;
import by.bsac.server.api.service.services.exception.ServiceException;
import by.bsac.server.api.service.services.exception.ServiceValidationException;
import by.bsac.timetable.service.IRecordService;
import by.bsac.timetable.service.IValidationService;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements IRecordService {


  @Autowired
  private IValidationService validationService;

  @Autowired
  private RecordDAO recordDAO;

  @Autowired
  private CancellationDAO cancellationDao;

  @Autowired
  private GroupDAO groupDao;

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public void addRecord(Record record) throws ServiceException, ServiceValidationException {
    validationService.validateRecord(record, false);

    SubjectFor lessonFor = record.getSubjectForByIdSubjectFor();
    try {
      /* если это пара для всего потока, то нужно добавить всем */
      if (lessonFor.getId()==4) {
        addFlowRecord(record);
      } else {
        checkRecordForConflict(record);
        recordDAO.add(record);
      }
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при вставке", e);
    }
  }
//
//  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
//      dontRollbackOn = ServiceValidationException.class)
////  @Override
////  public void addRecordByAtWeekSet(Record record, Set<WeekNumber> weekSet)
//      throws ServiceException, ServiceValidationException {
//    validationService.validateRecord(record, false);
//
//    List<Record> resultList = new LinkedList<>();
//
//    LessonFor lessonFor = LessonFor.subjectForToLessonFor(record.getSubjectFor());
//    try {
//      Iterator<WeekNumber> it = weekSet.iterator();
//      while (it.hasNext()) {
//        WeekNumber weekNumber = it.next();
//        byte weekNumberValue = weekNumber.getWeekNumber();
//        record.setWeekNumber(weekNumberValue);
//
//        /* если это пара для всего потока, то нужно добавить всем */
//        if (lessonFor.equals(LessonFor.FULL_FLOW)) {
//          List<Record> constructFlowRecordList = constructFlowRecordList(record);
//          resultList.addAll(constructFlowRecordList);
//        } else {
//          checkRecordForConflict(record);
//          resultList.add(RECORD_BUILDER.copy(record));
//        }
//      }
//      recordDAO.addAll(resultList);
//    } catch (RuntimeException e) {
//      throw new ServiceException("Ошибка при вставке", e);
//    }
//  }


  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public void updateRecord(Record initialRecord, Record updateRecord)
      throws ServiceException, ServiceValidationException {
    validationService.validateRecord(initialRecord, true);
    validationService.validateRecord(updateRecord, false);

    /*
     * если это пара на одну дату и дату изменили, то нужно обновить номер недели и дня
     */
//    if (updateRecord.getDateFrom().equals(updateRecord.getDateTo())
//        && !updateRecord.getDateFrom().equals(initialRecord.getDateFrom())
//        && !updateRecord.getDateTo().equals(initialRecord.getDateTo())) {
//
//      byte weekDay = DateUtil.getWeekDay(updateRecord.getDateFrom());
//      byte weekNumber = DateUtil.getWeekNumber(updateRecord.getDateFrom());
//      updateRecord.setWeekDay(weekDay);
//      updateRecord.setWeekNumber(weekNumber);
//    }
//
//    LessonFor lessonFor = LessonFor.subjectForToLessonFor(updateRecord.getSubjectFor());
    try {
//      /* если это пара для всего потока, то нужно обновить у всех */
//      if (lessonFor.equals(LessonFor.FULL_FLOW)) {
//        updateFlowRecord(initialRecord, updateRecord);
//      } else {
//        recordDAO.update(updateRecord);
//      }
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при обновлении", e);
    }
  }

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public Record getRecord(int idRecord) throws ServiceException {
    try {
      return recordDAO.getById(idRecord);
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при получении занятия", e);
    }
  }

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public void deleteRecord(Record record) throws ServiceException, ServiceValidationException {
    validationService.validateRecord(record, true);
    try {
      recordDAO.delete(record);
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при удалении занятия", e);
    }
  }

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public List<Record> getAllRecordListForGroup(Group group, Date dateFrom, Date dateTo)
      throws ServiceException, ServiceValidationException {
    validationService.validateGroup(group, true);
    try {
      return recordDAO.getRecordListByGroupAndDatesWhichNotCancelled(group, dateFrom, dateTo);
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при получении занятий", e);
    }
  }

//  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
//      dontRollbackOn = ServiceValidationException.class)
//  @Override
//  public void cancelRecord(Record initialRecord, Record cancelRecord,
//      LessonPeriod cancelLessonPeriod) throws ServiceException, ServiceValidationException {
//
//    validationService.validateRecord(initialRecord, true);
//    validationService.validateRecord(cancelRecord, false);
//
//    try {
//      /*
//       * удаление по номеру недели или это пара на одну дату, то удаляем данную запись
//       */
//      LessonFor lessonFor = LessonFor.subjectForToLessonFor(cancelRecord.getSubjectByIdSubject());
//      Date dateFrom = initialRecord.getDateFrom();
//      Date dateTo = initialRecord.getDateTo();
//
//      if (cancelLessonPeriod.equals(LessonPeriod.FOR_WEEK_NUMBER)
//          || dateFrom.equals(dateTo)) {
//
//        /* если это пара для всего потока, то нужно обновить у всех */
//        if (lessonFor.equals(LessonFor.FULL_FLOW)) {
//          deleteFlowRecord(cancelRecord);
//        } else {
//          recordDAO.delete(cancelRecord);
//        }
//
//      } else {
//        if (lessonFor.equals(LessonFor.FULL_FLOW)) {
//          cancelFlowRecord(initialRecord, cancelRecord);
//        } else {
//          Cancellation cancellation = new Cancellation();
//          cancellation.setDateFrom(cancelRecord.getDateFrom());
//          cancellation.setDateTo(cancelRecord.getDateTo());
//          cancellation.setRecordByIdRecord(initialRecord);
//          cancellationDao.add(cancellation);
//        }
//      }
//    } catch (RuntimeException e) {
//      throw new ServiceException("Ошибка при отмене занятия", e);
//    }
//  }

  /* @Transactional(value = TxType.MANDATORY) */
  private void addFlowRecord(Record addRecord) throws ServiceException, ServiceValidationException {

    List<Record> recordList = new LinkedList<>();

    List<Group> groupList = groupDao.getGroupListByFlow(addRecord.getGroupByIdGroup().getFlowByIdFlow());
    for (Group group : groupList) {
      addRecord.setGroupByIdGroup(group);
      checkRecordForConflict(addRecord);
      recordList.add(addRecord);
    }
    recordDAO.addAll(recordList);
  }

  private List<Record> constructFlowRecordList(Record addRecord)
      throws ServiceException, ServiceValidationException {

    List<Record> recordList = new LinkedList<>();

    List<Group> groupList = groupDao.getGroupListByFlow(addRecord.getGroupByIdGroup().getFlowByIdFlow());
    for (Group group : groupList) {
      addRecord.setGroupByIdGroup(group);
      checkRecordForConflict(addRecord);
      recordList.add(addRecord);
    }
    return recordList;
  }

  /* @Transactional(value = TxType.MANDATORY) */
  private void updateFlowRecord(Record initialRecord, Record updateRecord)
      throws ServiceException, ServiceValidationException {
    List<Record> resultList = new LinkedList<>();

    List<Group> groupList = groupDao.getGroupListByFlow(initialRecord.getGroupByIdGroup().getFlowByIdFlow());
    for (Group group : groupList) {
      Record thisGroupRecord = recordDAO.getRecordForGroupLikeThis(group, initialRecord);
      if (thisGroupRecord != null) {
        updateRecord.setGroupByIdGroup(group);
        updateRecord.setIdRecord(thisGroupRecord.getIdRecord());
        checkRecordForConflict(updateRecord);
      }
    }

    for (Group group : groupList) {
      Record thisGroupRecord = recordDAO.getRecordForGroupLikeThis(group, initialRecord);
      if (thisGroupRecord != null) {
        updateRecord.setGroupByIdGroup(group);
        updateRecord.setIdRecord(thisGroupRecord.getIdRecord());
        resultList.add(updateRecord);
      }
    }
    recordDAO.updateAll(resultList);
    // try {
    // checkRecordForConflict(updateRecord);
    // recordList.add((Record) updateRecord.clone());
    // } catch (CloneNotSupportedException e) {
    // throw new ServiceException("Ошибка при обновлении записи для потока",
    // e);
    // }
    // // factory.getRecordDAO().update(updateRecord);
    // }
    // factory.getRecordDAO().updateAll(recordList);
  }

  /* @Transactional(value = TxType.MANDATORY) */
  private void cancelFlowRecord(Record initialRecord, Record cancelRecord) {
    List<Cancellation> resultList = new LinkedList<>();

    Cancellation cancellation = new Cancellation();
    cancellation.setDateFrom(cancelRecord.getDateFrom());
    cancellation.setDateTo(cancelRecord.getDateTo());

    List<Group> groupList = groupDao.getGroupListByFlow(initialRecord.getGroupByIdGroup().getFlowByIdFlow());
    for (Group group : groupList) {
      Record thisGroupRecord = recordDAO.getRecordForGroupLikeThis(group, initialRecord);
      if (thisGroupRecord != null) {
        cancellation.setRecordByIdRecord(thisGroupRecord);
        resultList.add(cancellation);
      }
    }
    cancellationDao.addAll(resultList);
  }

  /* @Transactional(value = TxType.MANDATORY) */
  private void deleteFlowRecord(Record initalRecord) {
    List<Record> resultList = new LinkedList<>();

    List<Group> groupList = groupDao.getGroupListByFlow(initalRecord.getGroupByIdGroup().getFlowByIdFlow());
    for (Group group : groupList) {
      Record thisGroupRecord = recordDAO.getRecordForGroupLikeThis(group, initalRecord);
      if (thisGroupRecord != null) {
        resultList.add(thisGroupRecord);
      }
    }
    recordDAO.deleteAll(resultList);
  }

  /**
   * Method checks whether the passed instance of {@link Record} conflicts with similar records
   */
  /* @Transactional(value = TxType.MANDATORY) */
  private void checkRecordForConflict(Record record)
      throws ServiceException, ServiceValidationException {
    List<Record> recordList =
        getAllRecordListForGroup(record.getGroupByIdGroup(), record.getDateFrom(), record.getDateTo());

    for (Record elem : recordList) {
      if (
          !Objects.equals(elem.getIdRecord(), record.getIdRecord())
              && elem.getWeekNumber() == record.getWeekNumber()
              && elem.getWeekDay() == record.getWeekDay()
              && elem.getSubjOrdinalNumber() == record.getSubjOrdinalNumber()
              &&
              Objects.equals(elem.getSubjectForByIdSubjectFor(), record.getSubjectForByIdSubjectFor())) {

        throw new ServiceValidationException("Запись конфликтует с другой!");
      }
    }
  }

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public void changeClassroomForAllRecords(Classroom oldClassroom, Classroom newClassroom)
      throws ServiceException, ServiceValidationException {
    validationService.validateClassroom(oldClassroom, true);
    validationService.validateClassroom(newClassroom, true);
    try {
      recordDAO.replaceClassroomForAllRecords(oldClassroom, newClassroom);
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при обновлении аудитории", e);
    }
  }

  @Transactional(value = TxType.REQUIRED, rollbackOn = ServiceException.class,
      dontRollbackOn = ServiceValidationException.class)
  @Override
  public void changeLecturerForAllRecords(Lecturer oldLecturer, Lecturer newLecturer)
      throws ServiceException, ServiceValidationException {
    validationService.validateLecturer(oldLecturer, true);
    validationService.validateLecturer(newLecturer, true);
    try {
      recordDAO.replaceLecturerForAllRecords(oldLecturer, newLecturer);
    } catch (RuntimeException e) {
      throw new ServiceException("Ошибка при обновлении преподавателя", e);
    }
  }
}
