package sk.balaz.springbootmaster.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

//private final, getter, public constructor, equals, hashcode, toString
public record ApiException(String message,
                           Throwable throwable,
                           HttpStatus httpStatus,
                           ZonedDateTime zonedDateTime) {
}
