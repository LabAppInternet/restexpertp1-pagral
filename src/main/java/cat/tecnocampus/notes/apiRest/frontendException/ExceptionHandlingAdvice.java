package cat.tecnocampus.notes.apiRest.frontendException;

import cat.tecnocampus.notes.application.exception.UserNotFoundException;
import cat.tecnocampus.notes.domain.exception.NotEditableNote;
import cat.tecnocampus.notes.domain.exception.NoteNotOwnedException;
import cat.tecnocampus.notes.persistence.exception.NoteDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingAdvice {

    @ResponseBody
    @ExceptionHandler({UserNotFoundException.class, NoteDoesNotExistException.class})
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Class not found")
    String objectNotFoundHandler(Exception ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler({NotEditableNote.class, NoteNotOwnedException.class})
    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "Note can't be edited")
    String noteNotFoundHandler(Exception ex) {
        return ex.getMessage();
    }




}
