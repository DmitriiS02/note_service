package test_task.note_service.models;
import jakarta.persistence.*;


import java.time.LocalDateTime;


//Здесь мы описываем сущность Пользователя

@Entity //Определяем сущность как объект хранимый в БД
@Table(name = "user_storage")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Используем camelCase
    private Long id;
    private String login;
    private String surname;
    private String name;
    private String middleName;
    private LocalDateTime dateOfRecord;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middle_name) {
        this.middleName = middle_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDateTime getDateOfRecord() {
        return dateOfRecord;
    }
    public void setDateOfRecord(LocalDateTime dateOfRecord ) {
        this.dateOfRecord = dateOfRecord;
    }
}
