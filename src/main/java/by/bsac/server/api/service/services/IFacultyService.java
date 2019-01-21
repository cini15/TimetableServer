package by.bsac.server.api.service.services;


import by.bsac.server.api.date.entity.Faculty;
import by.bsac.server.api.service.services.exception.ServiceException;
import by.bsac.server.api.service.services.exception.ServiceValidationException;

import java.util.List;

public interface IFacultyService {

	public void addFaculties(Faculty faculty) throws ServiceException, ServiceValidationException;

	public void updateFaculty(Faculty faculty) throws ServiceException, ServiceValidationException;

	public Faculty getFacultyById(byte idFaculty) throws ServiceException;

	public List<Faculty> getAllFaculties() throws ServiceException;

	public void deleteFaculty(Faculty faculty) throws ServiceException, ServiceValidationException;
}