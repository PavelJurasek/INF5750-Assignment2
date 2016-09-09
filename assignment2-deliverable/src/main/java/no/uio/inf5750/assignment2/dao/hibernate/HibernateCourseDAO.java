package no.uio.inf5750.assignment2.dao.hibernate;

import no.uio.inf5750.assignment2.dao.CourseDAO;
import no.uio.inf5750.assignment2.model.Course;

import java.util.Collection;

/**
 * Created by pjurasek on 09.09.16.
 */
public class HibernateCourseDAO implements CourseDAO {
    @Override
    public int saveCourse(Course course) {
        return 0;
    }

    @Override
    public Course getCourse(int id) {
        return null;
    }

    @Override
    public Course getCourseByCourseCode(String courseCode) {
        return null;
    }

    @Override
    public Course getCourseByName(String name) {
        return null;
    }

    @Override
    public Collection<Course> getAllCourses() {
        return null;
    }

    @Override
    public void delCourse(Course course) {

    }
}
