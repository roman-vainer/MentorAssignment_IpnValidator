package ua.shpp.studentsdb.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.stereotype.Repository;
import ua.shpp.studentsdb.model.Student;
import ua.shpp.studentsdb.repo.StudentRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    StudentRepository repository = Mockito.mock(StudentRepository.class);
    Student student;
    @BeforeEach
    void setUp() {
        student = new Student(
                "Роман",
                LocalDate.of(1979, 11, 30),
                "male",
                2918805152L);
    }

    @Test
    void getStudent() {
        repository.save(student);
        System.out.println(repository.findAll());
    }

    @Test
    void addNewStudent() {
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void updateStudent() {
    }
}