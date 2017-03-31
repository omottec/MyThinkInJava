package innerclasses;

import innerclasses.controller.Event;

/**
 * Created by qinbingbing on 1/29/16.
 */
public class GreenhouseControls25 extends GreenhouseControls {
    private boolean waterMist = false;
    public class WaterMistOn extends Event {

        public WaterMistOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            waterMist = true;
        }

        @Override
        public String toString() {
            return "Water mist generator on";
        }
    }

    public class WaterMistOff extends Event {

        public WaterMistOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            waterMist = false;
        }

        @Override
        public String toString() {
            return "Water mist generator off";
        }
    }
}
