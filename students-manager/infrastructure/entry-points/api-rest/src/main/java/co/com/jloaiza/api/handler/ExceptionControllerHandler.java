package co.com.jloaiza.api.handler;

import co.com.jloaiza.api.model.ErrorResponse;
import co.com.jloaiza.model.error.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
@Log4j2
public class ExceptionControllerHandler {

    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<ErrorResponse> handleException(BusinessException exception) {
        var error = ErrorResponse.builder()
                .statusCode(exception.getType().getStatus())
                .status(HttpStatus.resolve(exception.getType().getStatus()))
                .reason(exception.getType().getMessage())
                .message(exception.getMessage())
                .build();
        return ResponseEntity.status(exception.getType().getStatus()).body(error);
    }

}
