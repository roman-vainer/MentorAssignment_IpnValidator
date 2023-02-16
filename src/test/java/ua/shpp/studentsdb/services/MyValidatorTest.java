/*
package ua.shpp.studentsdb.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import ua.shpp.studentsdb.controllers.MyErrorAdviceController;
import ua.shpp.studentsdb.model.Student;

import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MyValidatorTest {
    MyValidator validator = new MyValidator();
    ConstraintValidatorContext context = Mockito.mock(ConstraintValidatorContext.class);
    Student validStudent;

    @BeforeEach
    void validStudent() {
        validStudent = new Student(
                "Роман",
                LocalDate.of(1979, 11, 30),
                "male",
                2918805152L);
    }

    @Test
    void checkValidIpn() {
        assertTrue(validator.isValid(validStudent, context));
    }


    @Test
    void ipnNotValidWhenDateOfBirthChanged() {
        validStudent.setDob(LocalDate.of(1980, 11, 30));
        assertFalse(validator.isValid(validStudent, context));
    }

    @Test
    void ipnNotValidWhenGenderChanged() {
        validStudent.setGender("female");
        assertFalse(validator.isValid(validStudent, context));
    }

    @Test
    void ipnNotValidWhenCheckingDigitChanged() {
        validStudent.setIpn(2918805151L);
        assertFalse(validator.isValid(validStudent, context));
    }
}*/
