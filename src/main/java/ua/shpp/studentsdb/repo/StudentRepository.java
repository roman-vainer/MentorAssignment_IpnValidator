package ua.shpp.studentsdb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import ua.shpp.studentsdb.model.Student;

import java.util.Optional;

@Repository
@Validated
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.ipn = ?1")
    Optional<Student> findById (Long ipn);
}
