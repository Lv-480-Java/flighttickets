package validation;

import com.softserve.entity.Root;
import com.softserve.exceptions.MissingRootException;

public interface ValidatorRoot {
    void validate(Root root) throws MissingRootException;

}
