package innerclasses;

/**
 * Created by qinbingbing on 1/28/16.
 */
public class Parcel9 {
    public Destination destination(String dest) {
        return new Destination() {
            private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
    }
}
