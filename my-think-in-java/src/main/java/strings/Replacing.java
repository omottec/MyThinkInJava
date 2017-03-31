package strings;
import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 3/15/16.
 */
public class Replacing {
    static String s = Splitting.knights;

    public static void main(String[] args) {
        print(s);
        print(s.replaceFirst("f\\w+", "located"));
        print(s.replaceAll("shrubbery|tree|herring", "banana"));
    }
}
