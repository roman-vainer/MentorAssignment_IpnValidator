package ua.shpp.studentsdb.exeption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class MyExceptionDto {
    private final String message;
    private final HttpStatus httpStatus;
    private final int code;
    private final LocalDateTime timestamp;
}
