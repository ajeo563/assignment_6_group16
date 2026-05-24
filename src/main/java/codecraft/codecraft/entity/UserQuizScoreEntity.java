package codecraft.codecraft.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_quiz_score")
public class UserQuizScoreEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UserProgressEntity user;

  @Column(name = "quiz_id")
  private String quizId;

  @Column(name = "module_id")
  private String moduleId;

  @Column(name = "score")
  private int score;

  @Column(name = "max_score")
  private int maxScore;

  public UserQuizScoreEntity() {}

  public UserQuizScoreEntity(UserProgressEntity user, String quizId, String moduleId, int score, int maxScore) {
    this.user = user;
    this.quizId = quizId;
    this.moduleId = moduleId;
    this.score = score;
    this.maxScore = maxScore;
  }

  public String getQuizId() { return quizId; }
  public String getModuleId() { return moduleId; }
  public int getScore() { return score; }
  public int getMaxScore() { return maxScore; }
}
