package ua.shpp.studentsdb.exeption;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;


@ControllerAdvice
public class ApiExceptionAdviceController {

    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<Object> handlerApiRequestException(ApiRequestException ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        MyExceptionDto apiException = createExceptionDto(ex.getMessage(), httpStatus);
        return new ResponseEntity<>(apiException, httpStatus);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> onMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        String errorMessage = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList()).toString();

        MyExceptionDto apiException = createExceptionDto(errorMessage, httpStatus);
        return new ResponseEntity<>(apiException, httpStatus);
    }

    private MyExceptionDto createExceptionDto(String message, HttpStatus httpStatus) {
        return new MyExceptionDto(
                message,
                httpStatus,
                httpStatus.value(),
                LocalDateTime.now());
    }
}


