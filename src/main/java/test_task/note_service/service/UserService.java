package test_task.note_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test_task.note_service.models.Note;
import test_task.note_service.models.User;
import test_task.note_service.repo.UserRepo;
import test_task.note_service.repo.NotesRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private NotesRepo notesRepo;

    public void createUser (User user){
        if(user.getDateOfRecord() == null){
            user.setDateOfRecord(LocalDateTime.now());
        }

        Date dateOfRecord = new Date();

        userRepo.save(user);
    }

    public List<Note> getUserNotes(User user){
       return notesRepo.findAllByUserId(user);
    }




}
