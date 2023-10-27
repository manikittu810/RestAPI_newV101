package RestAPINew.restfulwebservices.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime timestep;
    private String message;
    private String details;

    public LocalDateTime getTimestep() {
        return timestep;
    }

    public void setTimestep(LocalDateTime timestep) {
        this.timestep = timestep;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ErroDetails{" +
                "timestep=" + timestep +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    public ErrorDetails(LocalDateTime timestep, String message, String details) {
        this.timestep = timestep;
        this.message = message;
        this.details = details;
    }
}
