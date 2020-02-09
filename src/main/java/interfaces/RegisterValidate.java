package interfaces;

import com.softserve.controller.Client;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface RegisterValidate {
    default int checkRegister(Client client) {
        int countCondition = 0;
        List<String> clientData = new ArrayList<>();
        clientData.add(client.getEmail());
        clientData.add(client.getFirstName());
        clientData.add(client.getLastName());
        clientData.add(client.getPass());
        for (String checkEmpty : clientData) {
            if (checkEmpty.equals("")) {
              break;
            } else {
                countCondition++;
            }
        }
        String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern patternEmail = Pattern.compile(emailRegex);
        Matcher matcherEmail = patternEmail.matcher(client.getEmail());
        if(matcherEmail.matches()==true){
            countCondition++;
        }

        String passRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern patternPass = Pattern.compile(passRegex);
        Matcher matcherPass =patternPass.matcher(client.getEmail());
        if(matcherPass.matches()==true){
            countCondition++;
        }

        String firstNameRegex = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$";
        Pattern patternFirstName = Pattern.compile(firstNameRegex);
        Matcher matcherFirstName =patternFirstName.matcher(client.getFirstName());
        if(matcherFirstName.matches()==true){
            countCondition++;
        }
        String lastNameRegex = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$";
        Pattern patternLastName = Pattern.compile(lastNameRegex);
        Matcher matcherLastName =patternLastName.matcher(client.getLastName());
        if(matcherLastName.matches()==true){
            countCondition++;
        }

        return countCondition;
    }
}
