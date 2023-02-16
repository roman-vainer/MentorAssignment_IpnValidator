package ua.shpp.studentsdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.shpp.studentsdb.model.Student;
import ua.shpp.studentsdb.repo.StudentRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getStudent() {
        return repository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentIpn = repository.findById(student.getIpn());
        if (studentIpn.isPresent()) {
            throw new IllegalStateException("Ipn already exists");
        }
        repository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if (!repository.existsById(studentId)) {
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        }
        repository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, LocalDate dob, String gender) {
        Student student = repository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (dob != null && dob.isBefore(LocalDate.now()) && !dob.isEqual(student.getDob())) {
            student.setDob(dob);
        }
        if (gender != null && gender.length() > 0 && !Objects.equals(student.getGender(), gender)) {
            student.setGender(gender);
        }
    }
}
