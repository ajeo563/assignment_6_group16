package codecraft.codecraft.service;

import codecraft.codecraft.dto.*;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProgressService {

  private static final List<ModuleProgress> BASE_MODULES =
      List.of(
          new ModuleProgress("mod1", "Introduction to OOP", ModuleStatus.NOT_STARTED),
          new ModuleProgress("mod2", "Inheritance", ModuleStatus.NOT_STARTED),
          new ModuleProgress("mod3", "Polymorphism", ModuleStatus.NOT_STARTED));

  private final Map<String, ProgressResponse> store =
      Map.of(
          "user1",
              new ProgressResponse(
                  "user1",
                  List.of(
                      new ModuleProgress("mod1", "Introduction to OOP", ModuleStatus.COMPLETED),
                      new ModuleProgress("mod2", "Inheritance", ModuleStatus.IN_PROGRESS),
                      new ModuleProgress("mod3", "Polymorphism", ModuleStatus.NOT_STARTED)),
                  List.of(new QuizScore("quiz1", "mod1", 85, 100)),
                  120,
                  null),
          "user2",
              new ProgressResponse(
                  "user2",
                  List.of(
                      new ModuleProgress("mod1", "Introduction to OOP", ModuleStatus.NOT_STARTED),
                      new ModuleProgress("mod2", "Inheritance", ModuleStatus.NOT_STARTED),
                      new ModuleProgress("mod3", "Polymorphism", ModuleStatus.NOT_STARTED)),
                  List.of(),
                  0,
                  "You haven't started any modules yet. Begin your learning journey!"));

  public ProgressResponse getProgress(String userId) {
    ProgressResponse response = store.get(userId);
    if (response == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + userId);
    }
    return response;
  }
}
