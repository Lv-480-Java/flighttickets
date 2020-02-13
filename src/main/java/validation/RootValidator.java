package validation;

import com.softserve.entity.Root;
import com.softserve.exceptions.MissingRootException;

public class RootValidator implements ValidatorRoot {

    @Override
    public void validate(Root root) throws MissingRootException {
        if(root==null){
        throw new MissingRootException();
        }
    }
}
