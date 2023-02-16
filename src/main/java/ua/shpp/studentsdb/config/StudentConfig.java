package ua.shpp.studentsdb.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.shpp.studentsdb.model.Student;
import ua.shpp.studentsdb.repo.StudentRepository;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student roman = new Student(
                    "Roman",
                    LocalDate.of(1979, 11, 30),
                    "male",
                    2918805152L);
            Student sergei = new Student(
                    "Sergei",
                    LocalDate.of(1980, 10, 25),
                    "male",
                    2951805150L);
            repository.saveAll(List.of(roman, sergei));
        };
    }
}
