package joosakur.regexptulkki.regexp;

public interface RegExpMatcher {
    boolean matches(String regex, CharSequence input);
}
