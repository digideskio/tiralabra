package joosakur.regexptulkki;

import joosakur.regexptulkki.regexp.JavaRegExpMatcher;
import joosakur.regexptulkki.regexp.MyRegExpMatcher;
import junit.framework.Assert;
import org.junit.Test;



public class RegExpTest {

    JavaRegExpMatcher javaRegExpMatcher = new JavaRegExpMatcher();
    MyRegExpMatcher myRegExpMatcher = new MyRegExpMatcher();
    
    @Test
    public void testMatch1() {
        testMatch("a", "a");
    }

    @Test
    public void testInfixToPostFix1() {
        Assert.assertEquals("ab.c.", myRegExpMatcher.infixToPostfix("abc"));
    }
    
    @Test
    public void testInfixToPostFix2() {
        Assert.assertEquals("abb.*.a.", myRegExpMatcher.infixToPostfix("a(bb)*a"));
    }
    
    @Test
    public void testInfixToPostFix3() {
        System.out.println(myRegExpMatcher.infixToPostfix("a(b|(a)*)"));
        Assert.assertEquals("aba*|.", myRegExpMatcher.infixToPostfix("a(b|(a)*)"));
    }
    
    

    
    private void testMatch(String regex, String input) {
        Assert.assertEquals(javaRegExpMatcher.matches(regex, input), myRegExpMatcher.matches(regex, input));
    }
    
    
}
