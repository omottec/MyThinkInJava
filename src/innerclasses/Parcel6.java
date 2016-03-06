package innerclasses;

/**
 * Created by qinbingbing on 1/28/16.
 */
public class Parcel6 {
    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {
                private String id;
                TrackingSlip(String s) {
                    id = s;
                }
                String getSlip() { return id; }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
//        TrackingSlip ts1 = new TrackingSlip("x");
    }

    public void track() { internalTracking(true); }

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
}
