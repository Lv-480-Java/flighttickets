package validation;

import com.softserve.entity.Route;
import com.softserve.exceptions.MissingRootException;

import java.util.List;

public class RootValidator implements ValidatorRoot {

    @Override
    public void validate(List<Route> route) throws MissingRootException {
        if(route.size()==0){
        throw new MissingRootException();
        }
    }
}
