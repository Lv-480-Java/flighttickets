package validation;

import com.softserve.entity.User;
import com.softserve.exceptions.DuplicateException;


public class RegisterValidator implements DuplicateEmail {
    @Override
    public void validate(User front, User back) {
        if(front.getEmail().equals(back.getEmail())){
            throw new DuplicateException();
        }
    }
}
