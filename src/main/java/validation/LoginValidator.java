package validation;

import com.softserve.entity.User;
import com.softserve.exceptions.LoginException;

public class LoginValidator implements Validator {
    @Override
    public void validate(User user) {
    if(user==null){
        throw new LoginException();
    }
    }
}
