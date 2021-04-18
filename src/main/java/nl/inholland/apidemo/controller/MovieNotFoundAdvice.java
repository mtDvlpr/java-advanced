package nl.inholland.apidemo.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import nl.inholland.apidemo.model.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@ControllerAdvice
public class MovieNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(MovieNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  Map<String, Object> movieNotFoundHandler(MovieNotFoundException ex) {
    String[] msg = ex.getMessage().split(";");
    Map<String, Object> response = new LinkedHashMap<>();
    response.put("timestamp", LocalDateTime.now());
    response.put("status", 404);
    response.put("error", "Not Found");
    response.put("message", msg[0]);
    response.put("path", "/movies/" + msg[1]);
    return response;
  }
}
