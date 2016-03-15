package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qinbingbing on 3/15/16.
 */
public class ReFlags {
    public static void main(String[] args) {
        int flag = Pattern.CASE_INSENSITIVE | Pattern.MULTILINE;
        Pattern p = Pattern.compile("^java", flag);
        Matcher m = p.matcher("java has regex\njava has regex\n"
                + "JAVA has pretty good regex expressions\n"
                + "Regular expressions are in Java");
        while (m.find())
            System.out.println(m.group());
    }
}
