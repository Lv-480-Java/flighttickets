package validation;

import com.softserve.entity.User;

public interface DuplicateEmail {

void validate(User front, User back);
}
