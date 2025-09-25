package co.com.jloaiza.model.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException {

    @Getter
    @RequiredArgsConstructor
    public enum Type {
        STUDENT_ALREADY_EXISTS("Student already exists", 409),
        SUBJECT_ALREADY_EXISTS("Subject already exists", 409),
        ENROLLMENT_ALREADY_EXISTS("The student is already enrolled in the subject", 409),

        RESOURCE_NOT_FOUND("Resource not found", 404),
        REQUEST_MALFORMED("Client bad request", 400),
        ERROR_SAVING_IN_DATABASE("Error saving object in database", 500),
        INTERNAL_SERVER_ERROR("Something was wrong", 500);

        private final String message;
        private final int status;

        public BusinessException build() {
            return new BusinessException(this, "");
        }

        public BusinessException build(String message) {
            return new BusinessException(this, message);
        }
    }

    private final Type type;
    private final String message;

}
