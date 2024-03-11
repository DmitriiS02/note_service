package test_task.note_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test_task.note_service.models.Note;

import java.util.List;
import java.util.Optional;

public interface NotesRepo extends JpaRepository<Note, Long> {

    @Query("select n from Note n where n.userId = :userid and n.status = 'ACTIVE'")
    List<Note> findAllByParentId(@Param("userid") Long userId);
}
