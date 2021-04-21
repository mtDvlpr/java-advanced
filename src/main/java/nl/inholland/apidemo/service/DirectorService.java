package nl.inholland.apidemo.service;

import nl.inholland.apidemo.model.Director;
import nl.inholland.apidemo.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

  @Autowired
  private DirectorRepository directorRepository;

  public List<Director> getAllDirectors() {
    return (List<Director>) directorRepository.findAll();
  }

  public Director getDirectorById(long id) {
    return directorRepository.findById(id).get();
  }

  public Director addDirector(Director director) {
    directorRepository.save(director);
    return director;
  }
}
