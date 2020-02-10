package validation;
import com.softserve.entity.User;
import com.softserve.exceptions.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator implements Validator {
private static final String emailRegex="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
private static final  String passRegex = "^(?=.*[0-9]).{8,15}$";
private static final String firstLastNameRegex = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$";

 @Override
    public void validate(User user) throws ValidationException {
            checkEmailRegex(user);
            checkPassRegex(user);
            checkFirstNameRegex(user);
            checkLastNameRegex(user);
    }

    private void checkEmailRegex(User user) throws ValidationException {
        Pattern patternEmail = Pattern.compile(emailRegex);
        Matcher matcherEmail = patternEmail.matcher(user.getEmail());
        if (!matcherEmail.matches()) {
            throw new ValidationException();
        }
    }
    private void checkPassRegex(User user) throws ValidationException {
        Pattern patternPass = Pattern.compile(passRegex);
        Matcher matcherPass =patternPass.matcher(user.getPass());
        if(!matcherPass.matches()){
            throw new ValidationException();
        }
    }
    private void checkFirstNameRegex(User user) throws ValidationException {
        Pattern patternFirstName = Pattern.compile(firstLastNameRegex);
        Matcher matcherFirstName =patternFirstName.matcher(user.getFirstName());
        if(!matcherFirstName.matches()){
            throw new ValidationException();
        }
    }
    private void checkLastNameRegex(User user) throws ValidationException {
        Pattern patternLastName = Pattern.compile(firstLastNameRegex);
        Matcher matcherLastName =patternLastName.matcher(user.getLastName());
        if(!matcherLastName.matches()){
            throw new ValidationException();
        }
    }
}