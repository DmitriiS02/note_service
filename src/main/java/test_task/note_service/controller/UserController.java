package test_task.note_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test_task.note_service.models.User;
import test_task.note_service.models.Note;

import test_task.note_service.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user) {
        userService.createUser(user);
        return user;
    }

    @GetMapping
    public List<Note> getUserNotes(@RequestBody Long userId){
        return userService.getUserNotes(userId);
    }
}