package joosakur.regexptulkki;

import joosakur.regexptulkki.regexp.MyRegExpMatcher;

public class App 
{
    public static void main( String[] args )
    {
        MyRegExpMatcher matcher = new MyRegExpMatcher();
        boolean match = matcher.matches("(a|(ab)*)c*", "abc");
        System.out.println("match = " + match);
    }
}
