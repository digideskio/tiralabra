package joosakur.regexptulkki.regexp;

/**
 * Rajapinta säännöllisten lausekkeiden tulkille.
 */
public interface RegExpMatcher {


/**
 * Metodi vertaa sopiiko merkkijono 'input' säännölliseen lausekkeeseen 'regex'.
 *
 * @param   regex   Säännöllinen lauseke
 * @param   input   Tutkittava merkkijono
 * 
 * 
 * @return Onko merkkijono lausekkeen mukainen
 */
    boolean matches(String regex, CharSequence input);
    
    
}
