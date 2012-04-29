package joosakur.regexptulkki.regexp;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;



public class MyRegExpMatcherTest {

    JavaRegExpMatcher javaRegExpMatcher;
    MyRegExpMatcher myRegExpMatcher;

    @Before
    public void setUp(){
        javaRegExpMatcher = new JavaRegExpMatcher();
        myRegExpMatcher = new MyRegExpMatcher();
    }
    
    @Test
    public void testMatch1() {
        testMatch("abc", "a");
        testMatch("abc", "abc");
        testMatch("abc", "abcd");
        testMatch("abc", "cba");
        testMatch("abc", "aabc");
        testMatch("abc", "");
    }

    @Test
    public void testMatch2() {
        testMatch("a|b", "a");
        testMatch("a|b", "b");
        testMatch("a|b", "c");
        testMatch("a|b", "ab");
        testMatch("a|b", "ac");
        testMatch("a|b", "");
    }

    @Test
    public void testMatch3() {
        testMatch("ab*", "a");
        testMatch("ab*", "ab");
        testMatch("ab*", "abb");
        testMatch("ab*", "ba");
        testMatch("ab*", "");
        testMatch("ab*", "abbbc");
    }

    @Test
    public void testMatch4() {
        testMatch("(a|b*)a", "aa");
        testMatch("(a|b*)a", "bbba");
        testMatch("(a|b*)a", "bbb");
        testMatch("(a|b*)a", "a");
        testMatch("(a|b*)a", "aaab");
        testMatch("(a|b*)a", "bbc");
        testMatch("(a|b*)a", "");
    }

    @Test
    public void testMatch5() {
        testMatch("(a|(ab)*)c*", "");
        testMatch("(a|(ab)*)c*", "abc");
        testMatch("(a|(ab)*)c*", "abababaccc");
        testMatch("(a|(ab)*)c*", "ccc");
        testMatch("(a|(ab)*)c*", "acc");
        testMatch("(a|(ab)*)c*", "a");        
    }

    
    
    private void testMatch(String regex, String input) {
        Assert.assertEquals(javaRegExpMatcher.matches(regex, input), myRegExpMatcher.matches(regex, input));
    }
    
    
}
