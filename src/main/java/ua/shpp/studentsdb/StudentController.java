package ua.shpp.studentsdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("Api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudent();
    }

    @PostMapping
    public void addStudents(@Valid @RequestBody Student student) {
        studentService.addNewStudent(student);
    }


    @DeleteMapping(path = "{studentId}")
    public void deleteStudents(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) LocalDate dob,
            @RequestParam(required = false) String gender) {
        studentService.updateStudent(studentId, name, dob, gender);
    }

}
