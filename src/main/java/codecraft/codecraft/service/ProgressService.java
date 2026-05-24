package codecraft.codecraft.service;

import codecraft.codecraft.dto.*;
import codecraft.codecraft.entity.UserProgressEntity;
import codecraft.codecraft.repository.UserProgressRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProgressService {

  private final UserProgressRepository userProgressRepository;

  public ProgressService(UserProgressRepository userProgressRepository) {
    this.userProgressRepository = userProgressRepository;
  }

  public ProgressResponse getProgress(String userId) {
    UserProgressEntity entity = userProgressRepository.findById(userId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + userId));

    List<ModuleProgress> modules = entity.getModules().stream()
        .map(m -> new ModuleProgress(m.getModuleId(), m.getModuleName(), m.getStatus()))
        .collect(Collectors.toList());

    List<QuizScore> quizScores = entity.getQuizScores().stream()
        .map(q -> new QuizScore(q.getQuizId(), q.getModuleId(), q.getScore(), q.getMaxScore()))
        .collect(Collectors.toList());

    return new ProgressResponse(
        entity.getUserId(),
        modules,
        quizScores,
        entity.getTotalTimeSpentMinutes(),
        entity.getMessage());
  }
}
