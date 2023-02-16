package ua.shpp.studentsdb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.shpp.studentsdb.services.IpnValidator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@IpnValidator
public class Student {
    @NotEmpty(message = "Name must not be empty")
    private String name;
    @NotNull
    @Past(message = "Date of birth must be in past")
    private LocalDate dob;
    @Size(min = 4)
    @NotEmpty(message = "Gender must not be empty")
    private String gender;
    @Id
    private Long ipn;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", ipn=" + ipn +
                '}';
    }
}


