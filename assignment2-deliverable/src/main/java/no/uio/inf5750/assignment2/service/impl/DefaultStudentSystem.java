package no.uio.inf5750.assignment2.service.impl;

import no.uio.inf5750.assignment2.model.Course;
import no.uio.inf5750.assignment2.model.Student;
import no.uio.inf5750.assignment2.service.StudentSystem;

import java.util.Collection;

/**
 * Created by pjurasek on 09.09.16.
 */
public class DefaultStudentSystem implements StudentSystem {
    @Override
    public int addCourse(String courseCode, String name) {
        return 0;
    }

    @Override
    public void updateCourse(int courseId, String courseCode, String name) {

    }

    @Override
    public Course getCourse(int courseId) {
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
    public void delCourse(int courseId) {

    }

    @Override
    public void addAttendantToCourse(int courseId, int studentId) {

    }

    @Override
    public void removeAttendantFromCourse(int courseId, int studentId) {

    }

    @Override
    public int addStudent(String name) {
        return 0;
    }

    @Override
    public void updateStudent(int studentId, String name) {

    }

    @Override
    public Student getStudent(int studentId) {
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
    public void delStudent(int studentId) {

    }
}
