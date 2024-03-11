package test_task.note_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test_task.note_service.models.Note;
import test_task.note_service.service.NoteService;


@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public Note addNote(@RequestBody Note note, @RequestParam(value = "allowExecutionDateChange", defaultValue = "false") boolean allowExecutionDateChange) {
        if (!allowExecutionDateChange) {
            // Здесь не допускаем изменение поля дата фактического выполнения
            note.setCompleteDate(null);
        }
        noteService.createNoteForUser(note);
        return note;
    }

    @PostMapping("/complete")
    public String noteToComplete(@RequestBody Long id) {
        noteService.completeNote(id);
        return "Note No "+ id +" has successfully been completed";
    }

    @DeleteMapping
    public String noteToDelete(@RequestBody Long id) {
        noteService.deleteNote(id);
        return "Note No "+ id +" has been successfully deleted";
    }
}