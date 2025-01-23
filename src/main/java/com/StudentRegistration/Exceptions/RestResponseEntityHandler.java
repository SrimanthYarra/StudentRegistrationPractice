package com.StudentRegistration.Exceptions;

import com.StudentRegistration.Models.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage studentNotFoundException(StudentNotFoundException exception){
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setStatus(HttpStatus.NOT_FOUND);
        errorMessage.setMessage(exception.getMessage());
        return errorMessage;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage genericErrorMessage(Exception exception){
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "not found");
    }
}
