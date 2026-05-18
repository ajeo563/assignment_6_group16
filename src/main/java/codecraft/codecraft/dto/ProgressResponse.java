package codecraft.codecraft.dto;

import java.util.List;

public class ProgressResponse {
  private String userId;
  private List<ModuleProgress> modules;
  private List<QuizScore> quizScores;
  private long totalTimeSpentMinutes;
  private String message;

  public ProgressResponse(
      String userId,
      List<ModuleProgress> modules,
      List<QuizScore> quizScores,
      long totalTimeSpentMinutes,
      String message) {
    this.userId = userId;
    this.modules = modules;
    this.quizScores = quizScores;
    this.totalTimeSpentMinutes = totalTimeSpentMinutes;
    this.message = message;
  }

  public String getUserId() {
    return userId;
  }

  public List<ModuleProgress> getModules() {
    return modules;
  }

  public List<QuizScore> getQuizScores() {
    return quizScores;
  }

  public long getTotalTimeSpentMinutes() {
    return totalTimeSpentMinutes;
  }

  public String getMessage() {
    return message;
  }
}
