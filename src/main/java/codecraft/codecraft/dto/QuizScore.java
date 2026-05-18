package codecraft.codecraft.dto;

public class QuizScore {
  private String quizId;
  private String moduleId;
  private int score;
  private int maxScore;

  public QuizScore(String quizId, String moduleId, int score, int maxScore) {
    this.quizId = quizId;
    this.moduleId = moduleId;
    this.score = score;
    this.maxScore = maxScore;
  }

  public String getQuizId() {
    return quizId;
  }

  public String getModuleId() {
    return moduleId;
  }

  public int getScore() {
    return score;
  }

  public int getMaxScore() {
    return maxScore;
  }
}
