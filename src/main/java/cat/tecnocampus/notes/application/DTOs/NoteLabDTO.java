package cat.tecnocampus.notes.application.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class NoteLabDTO {

    @Size(min=3,message = "title must be at least 3 letters long")
    @Size(max=255,message = "title must not be longer than 255 letters long")
    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    private String title;
    private String content;

    private LocalDateTime dateCreation;

    private LocalDateTime dateEdit;

    private UserLabDTO owner;

    public NoteLabDTO() {
    }


    public UserLabDTO getOwner() {
        return owner;
    }



    public void setOwner(UserLabDTO owner) {
        this.owner = owner;
    }

    public NoteLabDTO(String title, String content) {
        this.title = title;
        this.content = content;
        dateCreation = LocalDateTime.now();
        dateEdit = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDateEdit() {
        return dateEdit;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setDateEdit(LocalDateTime dateEdit) {
        this.dateEdit = dateEdit;
    }

}
