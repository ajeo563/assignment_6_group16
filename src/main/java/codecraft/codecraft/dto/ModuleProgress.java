package codecraft.codecraft.dto;

public class ModuleProgress {
  private String moduleId;
  private String moduleName;
  private ModuleStatus status;

  public ModuleProgress(String moduleId, String moduleName, ModuleStatus status) {
    this.moduleId = moduleId;
    this.moduleName = moduleName;
    this.status = status;
  }

  public String getModuleId() {
    return moduleId;
  }

  public String getModuleName() {
    return moduleName;
  }

  public ModuleStatus getStatus() {
    return status;
  }
}
