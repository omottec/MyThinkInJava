package innerclasses.controller;

import innerclasses.GreenhouseControls;

/**
 * Created by qinbingbing on 1/29/16.
 */
public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        gc.addEvent(gc.new Bell(9000));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(2000),
                gc.new LightOff(4000),
                gc.new WaterOn(6000),
                gc.new WaterOff(8000),
                gc.new ThermostatDay(14000)
        };
        gc.addEvent(gc.new Restart(20000, eventList));
        if (args.length == 1)
            gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
        gc.run();
    }
}
