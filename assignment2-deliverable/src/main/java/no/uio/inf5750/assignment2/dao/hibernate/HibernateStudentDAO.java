package no.uio.inf5750.assignment2.dao.hibernate;

import no.uio.inf5750.assignment2.dao.StudentDAO;
import no.uio.inf5750.assignment2.model.Student;

import java.util.Collection;

/**
 * Created by pjurasek on 09.09.16.
 */
public class HibernateStudentDAO implements StudentDAO {
    @Override
    public int saveStudent(Student student) {
        return 0;
    }

    @Override
    public Student getStudent(int id) {
        return null;
    }

    @Override
    public Student getStudentByName(String name) {
        return null;
    }

    @Override
    public Collection<Student> getAllStudents() {
        return null;
    }

    @Override
    public void delStudent(Student student) {

    }
}
