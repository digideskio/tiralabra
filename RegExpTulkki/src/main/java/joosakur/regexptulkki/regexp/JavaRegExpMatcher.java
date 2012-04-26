package joosakur.regexptulkki.regexp;

import java.util.regex.Pattern;

public class JavaRegExpMatcher implements RegExpMatcher{

    @Override
    public boolean matches(String regex, CharSequence input) {
        return Pattern.matches(regex, input);
    }
    
}
