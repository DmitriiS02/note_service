package test_task.note_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test_task.note_service.models.Note;
import test_task.note_service.models.NoteStatus;
import test_task.note_service.models.User;
import test_task.note_service.repo.NotesRepo;
import test_task.note_service.repo.UserRepo;

import java.time.LocalDateTime;
@Service
public class NoteService {

    @Autowired
    private NotesRepo notesRepo;

    @Autowired
    private UserRepo userRepo;

    public void createNoteForUser (Note note){

        Long userId = note.getUserId();
        User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        if(note.getCreationDate()==null){
            note.setCreationDate(LocalDateTime.now());
        }
        if(note.getDueDate() == null){
            note.setDueDate(LocalDateTime.now().plusDays(3));
        }
        note.setUserId(userId);
        note.setStatus(NoteStatus.ACTIVE);
        notesRepo.save(note);

    }

    public void completeNote (Long noteId){

        Note noteToComplete = notesRepo.findById(noteId).orElseThrow(() -> new IllegalArgumentException("Note not found with id: " + noteId));

        noteToComplete.setCompleteDate(LocalDateTime.now());
        notesRepo.save(noteToComplete);
    }

    public void deleteNote (Long noteId){
        Note noteToDelete = notesRepo.findById(noteId).orElseThrow(() -> new IllegalArgumentException("Note not found with id: " + noteId));

        noteToDelete.setStatus(NoteStatus.ARCHIVE);
        notesRepo.save(noteToDelete);
    }


}
