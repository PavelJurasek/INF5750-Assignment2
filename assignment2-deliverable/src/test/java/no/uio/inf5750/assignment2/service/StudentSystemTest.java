package no.uio.inf5750.assignment2.service;

import junit.framework.TestCase;
import no.uio.inf5750.assignment2.model.Course;
import no.uio.inf5750.assignment2.model.Student;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by pjurasek on 09.09.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/assignment2/beans-test.xml")
@Transactional
public class StudentSystemTest extends TestCase {

    @Autowired
    public StudentSystem studentSystem;

    public void setStudentSystem(StudentSystem studentSystem) {
        this.studentSystem = studentSystem;
    }

    private Student student;

    private Course course;

    @Override
    @Before
    public void setUp() {
        int studentId = studentSystem.addStudent("Joan Doe");
        int courseId = studentSystem.addCourse("ABC", "Test");

        student = studentSystem.getStudent(studentId);
        course = studentSystem.getCourse(courseId);
    }

    @Override
    @After
    public void tearDown() {
        studentSystem.delStudent(student.getId());
        studentSystem.delCourse(course.getId());
    }

    @Test
    public void addCourse() throws Exception {
        int id = studentSystem.addCourse("DEF", "DEF course");

        Course course = studentSystem.getCourse(id);

        assertEquals("DEF", course.getCourseCode());
        assertEquals("DEF course", course.getName());
    }

    @Test
    public void updateCourse() {
        studentSystem.updateCourse(course.getId(), "BCD", "Test update");
    }

    @Test
    public void getCourse() {
        Course course = studentSystem.getCourse(this.course.getId());

        assertEquals(this.course.getId(), course.getId());
    }

    @Test
    public void getCourseByCourseCode() {
        int id = studentSystem.addCourse("XYZ", "XYZ course");

        Course course = studentSystem.getCourseByCourseCode("XYZ");

        assertNotNull(course);
    }

    @Test
    public void getCourseByName() {
        Course course = studentSystem.getCourseByName("Test");

        assertEquals(this.course.getId(), course.getId());
    }

    @Test
    public void getAllCourses() {
        Collection<Course> courses = studentSystem.getAllCourses();

        assertFalse(courses.isEmpty());
    }

    @Test
    public void delCourse() {
        studentSystem.delCourse(course.getId());
    }

    @Test
    public void addAttendantToCourse() {
        int courseId = studentSystem.addCourse("ATC", "ATC course");
        int studentId = studentSystem.addStudent("Eve");

        studentSystem.addAttendantToCourse(courseId, studentId);
    }

    @Test
    public void removeAttendantFromCourse() {
        studentSystem.removeAttendantFromCourse(course.getId(), student.getId());
    }

    @Test
    public void addStudent() {
        int id = studentSystem.addStudent("John Doe");

        Student student = studentSystem.getStudent(id);

        assertEquals("John Doe", student.getName());
    }

    @Test
    public void updateStudent() {
        studentSystem.updateStudent(student.getId(), "Alice");
    }

    @Test
    public void getStudent() {
        Student student = studentSystem.getStudent(this.student.getId());

        assertEquals(this.student.getId(), student.getId());
    }

    @Test
    public void getStudentByName() {
        Student student = studentSystem.getStudentByName("Joan Doe");

        assertEquals(this.student.getId(), student.getId());
    }

    @Test
    public void getAllStudents() {
        Collection<Student> students = studentSystem.getAllStudents();

        assertFalse(students.isEmpty());
    }

    @Test
    public void delStudent() {
        studentSystem.delStudent(student.getId());
    }

    @Test
    public void setStudentLocation() {

        int id = studentSystem.addStudent("Bob");

        Student student = studentSystem.getStudent(id);

        assertNull(student.getLatitude());
        assertNull(student.getLongitude());

        studentSystem.setStudentLocation(id, "1", "2");

        student = studentSystem.getStudent(id);

        assertEquals(student.getLatitude(), "1");
        assertEquals(student.getLongitude(), "2");
    }

}
