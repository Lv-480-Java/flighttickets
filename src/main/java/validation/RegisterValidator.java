package validation;

import com.softserve.entity.User;
import com.softserve.exceptions.DuplicateException;


public class RegisterValidator implements Validator {
    @Override
    public void validate(User back) {
        if(back!=null){
            throw new DuplicateException();
        }
    }
}
