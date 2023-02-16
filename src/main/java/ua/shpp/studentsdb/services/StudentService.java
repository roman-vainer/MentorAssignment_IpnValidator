package ua.shpp.studentsdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.shpp.studentsdb.exeption.ApiRequestException;
import ua.shpp.studentsdb.model.Student;
import ua.shpp.studentsdb.repo.StudentRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
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
        Long ipn = student.getIpn();
        Optional<Student> optionalStudent = repository.findById(ipn);
        if (optionalStudent.isPresent()) {
            throw new ApiRequestException("Ipn " + ipn + " already exists");
        }
        repository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if (!repository.existsById(studentId)) {
            throw new ApiRequestException("student with id " + studentId + " does not exist");
        }
        repository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, LocalDate dob, String gender) {
        Student student = repository.findById(studentId)
                .orElseThrow(() -> new ApiRequestException("student with id " + studentId + " does not exist"));

        if (name != null) {
            if (name.length() == 0) {
                throw new ApiRequestException("Name must not be empty");
            }
            student.setName(name);
        }

        if (dob != null) {
            if (!dob.isBefore(LocalDate.now())) {
                throw new ApiRequestException("Date of birth must be in past");
            }
            student.setDob(dob);
        }

        if (gender != null) {
            if (!("male".equals(gender) || "female".equals(gender))) {
                throw new ApiRequestException("Gender must be equals 'male' or 'female'");
            }
            student.setGender(gender);
        }
    }
}
