package codecraft.codecraft.repository;

import codecraft.codecraft.entity.UserProgressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProgressRepository extends JpaRepository<UserProgressEntity, String> {
}
