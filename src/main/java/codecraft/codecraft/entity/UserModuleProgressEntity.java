package codecraft.codecraft.entity;

import codecraft.codecraft.dto.ModuleStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "user_module_progress")
public class UserModuleProgressEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UserProgressEntity user;

  @Column(name = "module_id")
  private String moduleId;

  @Column(name = "module_name")
  private String moduleName;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private ModuleStatus status;

  public UserModuleProgressEntity() {}

  public UserModuleProgressEntity(UserProgressEntity user, String moduleId, String moduleName, ModuleStatus status) {
    this.user = user;
    this.moduleId = moduleId;
    this.moduleName = moduleName;
    this.status = status;
  }

  public String getModuleId() { return moduleId; }
  public String getModuleName() { return moduleName; }
  public ModuleStatus getStatus() { return status; }
}
