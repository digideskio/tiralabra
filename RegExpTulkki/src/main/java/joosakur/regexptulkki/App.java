package joosakur.regexptulkki;

import joosakur.regexptulkki.regexp.MyRegExpMatcher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MyRegExpMatcher matcher = new MyRegExpMatcher();
        boolean match = matcher.matches("abcd*", "a");
        
    }
}
