package ua.shpp.studentsdb.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.shpp.studentsdb.Model.Student;
import ua.shpp.studentsdb.Repo.StudentRepository;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student Roman = new Student(
                    "Roman",
                    LocalDate.of(1979, 11, 30),
                    "male",
                    2918805152L);
            Student Sergei = new Student(
                    "Sergei",
                    LocalDate.of(1980, 10, 25),
                    "male",
                    2951805150L);
            repository.saveAll(List.of(Roman, Sergei));
        };
    }
}
