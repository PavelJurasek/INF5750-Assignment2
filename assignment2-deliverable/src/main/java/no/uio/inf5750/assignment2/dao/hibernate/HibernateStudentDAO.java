package no.uio.inf5750.assignment2.dao.hibernate;

import no.uio.inf5750.assignment2.dao.StudentDAO;
import no.uio.inf5750.assignment2.model.Student;
import org.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by pjurasek on 09.09.16.
 */
@Transactional
public class HibernateStudentDAO implements StudentDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int saveStudent(Student student) {
        return (Integer) sessionFactory.getCurrentSession().save(student);
    }

    @Override
    public Student getStudent(int id) {
        return (Student) sessionFactory.getCurrentSession().get(Student.class, id);
    }

    @Override
    public Student getStudentByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        Student student = null;

        try {
            student = (Student) session.createQuery("FROM Student WHERE name = :name ORDER by id DESC")
                    .setParameter("name", name)
                    .getSingleResult();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return student;

    }

    @Override
    public Collection<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();

        Collection<Student> students = new ArrayList<Student>();

        try {
            students = (Collection<Student>) session.createQuery("FROM Student ORDER by id DESC").list();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public void delStudent(Student student) {

        Session session = sessionFactory.getCurrentSession();

        try {
            session.delete(student);

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
