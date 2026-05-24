package codecraft.codecraft.config;

import codecraft.codecraft.dto.ModuleStatus;
import codecraft.codecraft.entity.UserModuleProgressEntity;
import codecraft.codecraft.entity.UserProgressEntity;
import codecraft.codecraft.entity.UserQuizScoreEntity;
import codecraft.codecraft.repository.UserProgressRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

  private final UserProgressRepository userProgressRepository;

  public DataLoader(UserProgressRepository userProgressRepository) {
    this.userProgressRepository = userProgressRepository;
  }

  @Override
  public void run(ApplicationArguments args) {

    // user1 — active learner with progress
    UserProgressEntity user1 = new UserProgressEntity("user1", 120, null);
    user1.getModules().add(new UserModuleProgressEntity(user1, "mod1", "Introduction to OOP", ModuleStatus.COMPLETED));
    user1.getModules().add(new UserModuleProgressEntity(user1, "mod2", "Inheritance",          ModuleStatus.IN_PROGRESS));
    user1.getModules().add(new UserModuleProgressEntity(user1, "mod3", "Polymorphism",         ModuleStatus.NOT_STARTED));
    user1.getQuizScores().add(new UserQuizScoreEntity(user1, "quiz1", "mod1", 85, 100));
    userProgressRepository.save(user1);

    // user2 — new learner, no progress yet
    UserProgressEntity user2 = new UserProgressEntity(
        "user2", 0, "You haven't started any modules yet. Begin your learning journey!");
    user2.getModules().add(new UserModuleProgressEntity(user2, "mod1", "Introduction to OOP", ModuleStatus.NOT_STARTED));
    user2.getModules().add(new UserModuleProgressEntity(user2, "mod2", "Inheritance",          ModuleStatus.NOT_STARTED));
    user2.getModules().add(new UserModuleProgressEntity(user2, "mod3", "Polymorphism",         ModuleStatus.NOT_STARTED));
    userProgressRepository.save(user2);
  }
}
