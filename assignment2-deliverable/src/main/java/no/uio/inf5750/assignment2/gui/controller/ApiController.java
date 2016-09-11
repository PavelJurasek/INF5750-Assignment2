package no.uio.inf5750.assignment2.gui.controller;

import no.uio.inf5750.assignment2.model.Course;
import no.uio.inf5750.assignment2.model.Student;
import no.uio.inf5750.assignment2.service.StudentSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * Created by pjurasek on 10.09.16.
 */
@RestController
public class ApiController {

    @Autowired
    private StudentSystem studentSystem;

    public void setStudentSystem(StudentSystem studentSystem) {
        this.studentSystem = studentSystem;
    }

    @RequestMapping(value = "/api/student", method = RequestMethod.GET)
    public Collection<Student> getStudents() {
        return studentSystem.getAllStudents();
    }

    @RequestMapping(value = "/api/student/{studentId}/location", method = RequestMethod.POST, headers = {"Content-type=application/json;charset=UTF-8"})
    public Collection<Student> setLocation(
            @PathVariable("studentId") int studentId,
            @RequestBody Student input
    ) {
        studentSystem.setStudentLocation(studentId, input.getLatitude(), input.getLongitude());

        return studentSystem.getAllStudents();
    }

    @RequestMapping(value="/student/{user}", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudentByUsername(@PathVariable String user,
            HttpServletRequest request,
            HttpServletResponse response) {

        return studentSystem.getStudentByName(user);
    }

    @RequestMapping(value = "/api/course")
    public Collection<Course> getCourses() {
        return studentSystem.getAllCourses();
    }

}
