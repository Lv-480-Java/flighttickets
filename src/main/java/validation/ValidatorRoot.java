package validation;

import com.softserve.entity.Route;
import com.softserve.exceptions.MissingRootException;

public interface ValidatorRoot {
    void validate(Route route) throws MissingRootException;

}
