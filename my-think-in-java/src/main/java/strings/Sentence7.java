package strings;
import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 3/15/16.
 */
public class Sentence7 {
    public static void main(String[] args) {
        String sen = "^[A-Z].*[\\.]$";
        String sen1 = "^[A-Z].*(\\.)$";
        String s1 = "Once upon a time";
        String s2 = "abcd.";
        String s3 = "Abcd?";
        String s4 = "An easy way out.";
        String s5 = "Zorro.";
        String s6 = "X.";
        print(s1.matches(sen) + " " + s1.matches(sen1));
        print(s2.matches(sen) + " " + s2.matches(sen1));
        print(s3.matches(sen) + " " + s3.matches(sen1));
        print(s4.matches(sen) + " " + s4.matches(sen1));
        print(s5.matches(sen) + " " + s5.matches(sen1));
        print(s6.matches(sen) + " " + s6.matches(sen1));
    }
}
