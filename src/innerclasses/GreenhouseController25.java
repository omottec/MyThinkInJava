package innerclasses;

import innerclasses.controller.Event;

/**
 * Created by qinbingbing on 1/29/16.
 */
public class GreenhouseController25 {
    public static void main(String[] args) {
        GreenhouseControls25 gc = new GreenhouseControls25();
        gc.addEvent(gc.new Bell(9000));
        Event[] events = {
                gc.new ThermostatNight(0),
                gc.new LightOn(2000),
                gc.new LightOff(4000),
                gc.new WaterOn(6000),
                gc.new WaterMistOn(6500),
                gc.new WaterMistOff(7000),
                gc.new WaterOff(8000),
                gc.new ThermostatDay(14000)
        };
        gc.addEvent(gc.new Restart(20000, events));
        if (args.length == 1) {
            gc.addEvent(new GreenhouseControls.Terminate(Integer.parseInt(args[0])));
        }
        gc.run();
    }
}
