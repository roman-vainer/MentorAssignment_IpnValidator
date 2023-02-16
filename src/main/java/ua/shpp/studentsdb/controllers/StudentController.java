package ua.shpp.studentsdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.shpp.studentsdb.model.Student;
import ua.shpp.studentsdb.services.StudentService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("Api/student")
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
    public ResponseEntity<String> addStudents(@Valid @RequestBody Student student) {
        studentService.addNewStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("Add: " + student);
    }

    @DeleteMapping(path = "{studentId}")
    public ResponseEntity<String> deleteStudents(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.status(HttpStatus.OK).body("Student with IPN: " + studentId + " was deleted");
    }

    @PutMapping(path = "{studentId}")
    public ResponseEntity<String> updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) LocalDate dob,
            @RequestParam(required = false) String gender) {
        studentService.updateStudent(studentId, name, dob, gender);
        return ResponseEntity.status(HttpStatus.OK).body("Student with IPN: " + studentId + " was updated");
    }
}
