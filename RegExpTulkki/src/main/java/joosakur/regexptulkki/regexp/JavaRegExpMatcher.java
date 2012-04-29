package joosakur.regexptulkki.regexp;

import java.util.regex.Pattern;

/**
 * Javan Pattern-luokkaa käyttävä toteutus säännöllisten lausekkeiden tulkista.
 */
public class JavaRegExpMatcher implements RegExpMatcher{

    @Override
    public boolean matches(String regex, CharSequence input) {
        return Pattern.matches(regex, input);
    }
    
}
