package homework2.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerValidator {
    public boolean isInteger(String stringNumber) {
        Pattern pattern = Pattern.compile("^[1-9][0-9]{0,1}$"); //  ^\\d{1,2}$
        Matcher matcher = pattern.matcher(stringNumber);
        return matcher.find();
    }

}
