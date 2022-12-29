package pl.first.project.book.store.validators;

import org.junit.Test;
import pl.first.project.book.store.exceptions.ValidationException;

public class UserDataValidatorTest {

    @Test
    public void correctLoginValidationTest() {
        String login = "admin";

        UserDataValidator.validateLogin(login);
    }

    @Test
    public void incorrectLoginValidationTest() {
        String login = "abc";
        UserDataValidator.validateLogin(login);
    }

    @Test
    public void correctPasswordValidationTest() {
        String password = "admin";
        UserDataValidator.validatePassword(password);
    }

    @Test
    public void incorrectPasswordValidationTest() {
        String password = "abc";
        UserDataValidator.validatePassword(password);
    }

    @Test
    public void equalPasswordsValidationTest() {
        String pass1 = "password";
        String pass2 = "password";

        UserDataValidator.validatePasswordMatch(pass1, pass2);
    }

    @Test(expected = ValidationException.class)
    public void notEqualPasswordsValidationTest() {
        String pass1 = "password";
        String pass2 = "password";

        UserDataValidator.validatePasswordMatch(pass1, pass2);
    }
}
