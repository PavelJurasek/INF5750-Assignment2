package no.uio.inf5750.assignment2.service.impl;

import no.uio.inf5750.assignment2.dao.CourseDAO;
import no.uio.inf5750.assignment2.dao.StudentDAO;
import no.uio.inf5750.assignment2.model.Course;
import no.uio.inf5750.assignment2.model.Student;
import no.uio.inf5750.assignment2.service.StudentSystem;

import java.util.Collection;

/**
 * Created by pjurasek on 09.09.16.
 */
public class DefaultStudentSystem implements StudentSystem {

    private CourseDAO courseDAO;

    private StudentDAO studentDAO;

    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public int addCourse(String courseCode, String name) {
        Course course = new Course(courseCode, name);

        return courseDAO.saveCourse(course);
    }

    @Override
    public void updateCourse(int courseId, String courseCode, String name) {
        Course course = getCourse(courseId);

        if (course != null) {
            course.setCourseCode(courseCode);
            course.setName(name);

            courseDAO.saveCourse(course);
        }
    }

    @Override
    public Course getCourse(int courseId) {
        return courseDAO.getCourse(courseId);
    }

    @Override
    public Course getCourseByCourseCode(String courseCode) {
        return courseDAO.getCourseByCourseCode(courseCode);
    }

    @Override
    public Course getCourseByName(String name) {
        return courseDAO.getCourseByName(name);
    }

    @Override
    public Collection<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    @Override
    public void delCourse(int courseId) {
        Course course = courseDAO.getCourse(courseId);

        if (course != null) {
            courseDAO.delCourse(course);
        }
    }

    @Override
    public void addAttendantToCourse(int courseId, int studentId) {
        Course course = courseDAO.getCourse(courseId);
        Student student = studentDAO.getStudent(studentId);

        if (course != null && student != null) {
            course.getAttendants().add(student);
            courseDAO.saveCourse(course);
        }
    }

    @Override
    public void removeAttendantFromCourse(int courseId, int studentId) {
        Course course = courseDAO.getCourse(courseId);
        Student student = studentDAO.getStudent(studentId);

        if (course != null && student != null) {
            course.getAttendants().remove(student);
            courseDAO.saveCourse(course);
        }
    }

    @Override
    public int addStudent(String name) {
        Student student = new Student(name);

        return studentDAO.saveStudent(student);
    }

    @Override
    public void updateStudent(int studentId, String name) {
        Student student = studentDAO.getStudent(studentId);

        if (student != null) {
            student.setName(name);

            studentDAO.saveStudent(student);
        }
    }

    @Override
    public Student getStudent(int studentId) {
        return studentDAO.getStudent(studentId);
    }

    @Override
    public Student getStudentByName(String name) {
        return studentDAO.getStudentByName(name);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public void delStudent(int studentId) {
        Student student = studentDAO.getStudent(studentId);

        if (student != null) {
            studentDAO.delStudent(student);
        }
    }
}
