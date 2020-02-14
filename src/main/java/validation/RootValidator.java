package validation;

import com.softserve.entity.Route;
import com.softserve.exceptions.MissingRootException;

public class RootValidator implements ValidatorRoot {

    @Override
    public void validate(Route route) throws MissingRootException {
        if(route ==null){
        throw new MissingRootException();
        }
    }
}
