package strings;
import java.util.Arrays;
import java.util.regex.Pattern;

import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 3/15/16.
 */
public class SplitDemo {
    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";
        print(Arrays.toString(Pattern.compile("!!").split(input)));
        print(Arrays.toString(Pattern.compile("!!").split(input, 3)));
    }
}
