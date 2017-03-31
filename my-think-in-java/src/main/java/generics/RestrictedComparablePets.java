package generics;

/**
 * Created by qinbingbing on 2/11/16.
 */

class Hamster extends ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}

class Gecko extends ComparablePet {
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}

public class RestrictedComparablePets {
}
