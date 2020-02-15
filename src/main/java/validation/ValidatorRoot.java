package validation;

import com.softserve.entity.Route;
import com.softserve.exceptions.MissingRootException;

import java.util.List;

public interface ValidatorRoot {
    void validate(List<Route> route) throws MissingRootException;

}
