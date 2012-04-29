package joosakur.regexptulkki.regexp;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class PostfixGeneratorTest {

    PostfixGenerator postfixGenerator;
    
    @Before
    public void setUp(){
        postfixGenerator = new PostfixGenerator();
    }
    
    @Test
    public void testInfixToPostFix1() {
        Assert.assertEquals("ab.c.", postfixGenerator.infixToPostfix("abc"));
    }
    
    @Test
    public void testInfixToPostFix2() {
        Assert.assertEquals("abb.*.a.", postfixGenerator.infixToPostfix("a(bb)*a"));
    }
    
    @Test
    public void testInfixToPostFix3() {
        Assert.assertEquals("aba*|.", postfixGenerator.infixToPostfix("a(b|(a)*)"));
    }
    
    
    
}
