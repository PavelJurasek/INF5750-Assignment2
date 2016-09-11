package no.uio.inf5750.assignment2.dao.hibernate;

import no.uio.inf5750.assignment2.dao.CourseDAO;
import no.uio.inf5750.assignment2.model.Course;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by pjurasek on 09.09.16.
 */
@Transactional
public class HibernateCourseDAO implements CourseDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int saveCourse(Course course) {
        Session session = sessionFactory.getCurrentSession();

        if (course.getId() != 0) {
            session.update(course);
            return course.getId();
        }

        return (Integer) session.save(course);
    }

    @Override
    public Course getCourse(int id) {
        return (Course) sessionFactory.getCurrentSession().get(Course.class, id);
    }

    @Override
    public Course getCourseByCourseCode(String courseCode) {
        Session session = sessionFactory.getCurrentSession();

        Course course = null;

        try {
            course = (Course) session.createQuery("FROM Course WHERE name = :code ORDER by id DESC")
                    .setParameter("code", courseCode)
                    .getSingleResult();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return course;
    }

    @Override
    public Course getCourseByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        Course course = null;

        try {
            course = (Course) session.createQuery("FROM Course WHERE name = :name ORDER by id DESC")
                    .setParameter("name", name)
                    .getSingleResult();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return course;
    }

    @Override
    public Collection<Course> getAllCourses() {
        Session session = sessionFactory.getCurrentSession();

        Collection<Course> students = new ArrayList<Course>();

        try {
            students = (Collection<Course>) session.createQuery("FROM Course ORDER by id DESC").list();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public void delCourse(Course course) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.delete(course);

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    private EntityManager getEntityManager() {
        return sessionFactory.createEntityManager();
    }
}
