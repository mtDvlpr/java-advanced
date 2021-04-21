package nl.inholland.apidemo.controller;

import nl.inholland.apidemo.model.Director;
import nl.inholland.apidemo.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/directors")
public class DirectorController {

  @Autowired
  private DirectorService directorService;

  @GetMapping
  public ResponseEntity<List<Director>> getAllDirectors() {
    return new ResponseEntity<>(directorService.getAllDirectors(), HttpStatus.OK);
  }
}
