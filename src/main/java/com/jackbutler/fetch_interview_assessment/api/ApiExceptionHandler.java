package com.jackbutler.fetch_interview_assessment.api;

import com.jackbutler.fetch_interview_assessment.api.model.ErrorResponse;
import com.jackbutler.fetch_interview_assessment.model.BadRequestException;
import com.jackbutler.fetch_interview_assessment.model.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
@RestControllerAdvice("com.jackbutler.fetch_interview_assessment")
public class ApiExceptionHandler {

    @ExceptionHandler({NotFoundException.class, NoSuchElementException.class})
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException exception) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .error(exception.getMessage())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException exception) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .error(exception.getMessage())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }
}
