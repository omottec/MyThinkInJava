package strings;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 3/15/16.
 */
public class TestRegularExpression10 {
    public static void main(String[] args) {
        if (args.length < 2) {
            print("Usage:\njava TestRegularExpression10 characterSequence regularExpression+");
            System.exit(0);
        }
        print("Input: \"" + args[0] + "\"");
        for (String arg : args) {
            print("Regular expression: \"" + arg + "\"");
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            if (!m.find())
                print("No match found for \"" + arg + "\"");
            m.reset();
            while (m.find()) {
                print("Match \"" + m.group() + "\" at position "
                        + m.start()
                        + ((m.end() - m.start() < 2) ? "" : "-" + (m.end() - 1)));
            }
        }
    }
}
