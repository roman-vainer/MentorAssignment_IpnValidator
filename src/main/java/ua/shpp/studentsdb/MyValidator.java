package ua.shpp.studentsdb;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class MyValidator implements ConstraintValidator<IpnValidator, Student> {
    Student student;
    @Override
    public boolean isValid(Student student, ConstraintValidatorContext context) {
        this.student = student;
        return isDateOfBirthCorrect() && isGenderCorrect() /*&& isCheckingDigitCorrect()*/;
    }

    private boolean isCheckingDigitCorrect() {
        int[] formula = {-1, 5, 7, 9, 4, 6, 10, 5, 7};
        int expectedDigit = 0;
        for (int i = 0; i < 9; i++) {
            int w = (student.getIpn().toString().charAt(i) - '0') * formula[i];
            expectedDigit += w;
        }
        return expectedDigit % 11 == student.getIpn().toString().charAt(9) - '0';
    }

    private boolean isGenderCorrect() {
        if (student.getGender().equals("male")) {
            return (student.getIpn().toString().charAt(8)) % 2 != 0;
        }
        if (student.getGender().equals("female")) {
            return (student.getIpn().toString().charAt(8)) % 2 == 0;
        } else {
            return false;
        }
    }

    private boolean isDateOfBirthCorrect() {
        long days = LocalDate.of(1899, 12, 31).until(student.getDob(), ChronoUnit.DAYS);
        StringBuilder dobFromIpn = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            dobFromIpn.append(student.getIpn().toString().charAt(i));
        }
        return days == Integer.parseInt(dobFromIpn.toString());
    }
}
