package by.bsac.server.api.service.dao;

import by.bsac.server.api.date.entity.Faculty;
import by.bsac.server.api.service.dao.interfaces.GenericDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class FacultyDAOImplTest {
    @Autowired
    GenericDAO<Faculty,Byte> facultyDAO;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
    }

    @Test
    public void addAll() {
    }

    @Test
    public void getById() {
        final String nameFacultyId_1="Факультет электросвязи";
        Faculty faculty = facultyDAO.getById((byte) 1);
        assertNotNull(faculty);
        assertEquals(faculty.getNameFaculty(),nameFacultyId_1);
    }

    @Test
    public void getAll() {

       List<Faculty> list= facultyDAO.getAll();
       assertNotNull(list);
       assertEquals(list.size(),5);


    }

    @Test
    public void update() {
    }

    @Test
    public void updateAll() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void deleteAll() {
    }
}