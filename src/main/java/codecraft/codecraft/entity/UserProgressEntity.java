package codecraft.codecraft.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_progress")
public class UserProgressEntity {

  @Id
  @Column(name = "user_id")
  private String userId;

  @Column(name = "total_time_spent_minutes")
  private long totalTimeSpentMinutes;

  @Column(name = "message")
  private String message;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
  @OrderColumn(name = "module_order")
  private List<UserModuleProgressEntity> modules = new ArrayList<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
  @OrderColumn(name = "score_order")
  private List<UserQuizScoreEntity> quizScores = new ArrayList<>();

  public UserProgressEntity() {}

  public UserProgressEntity(String userId, long totalTimeSpentMinutes, String message) {
    this.userId = userId;
    this.totalTimeSpentMinutes = totalTimeSpentMinutes;
    this.message = message;
  }

  public String getUserId() { return userId; }
  public long getTotalTimeSpentMinutes() { return totalTimeSpentMinutes; }
  public String getMessage() { return message; }
  public List<UserModuleProgressEntity> getModules() { return modules; }
  public List<UserQuizScoreEntity> getQuizScores() { return quizScores; }
}
