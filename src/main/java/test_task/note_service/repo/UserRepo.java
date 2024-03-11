package test_task.note_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import test_task.note_service.models.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
