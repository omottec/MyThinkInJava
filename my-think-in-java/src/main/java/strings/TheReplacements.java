package strings;
import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 3/15/16.
 */

/*! Here's a block of text to use as input to
    the regular expression matcher. Note that we'll
    first extract the block of text by looking for
    the special delimiters, then process the
    extracted block. !*/

public class TheReplacements {
    public static void main(String[] args) {
        String s = TextFile.read("/Users/didi/IdeaProjects/MyThinkInJava/src/strings/TheReplacements.java");
        print(s);
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
        if (mInput.find())
            s = mInput.group(1);
        print(s);
        s = s.replaceAll(" {2,}", "");
        print(s);
        s = s.replaceAll("(?m)^ +", "");
        print(s);
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        print(s);
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        while (m.find())
            m.appendReplacement(sbuf, m.group().toUpperCase());
        print(sbuf);
        m.appendTail(sbuf);
        print(sbuf);
    }
}
