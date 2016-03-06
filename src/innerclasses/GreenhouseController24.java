package innerclasses;

import innerclasses.controller.Event;

/**
 * Created by qinbingbing on 1/29/16.
 */
public class GreenhouseController24 {
    public static void main(String[] args) {
        GreenHouseControls24 gc = new GreenHouseControls24();
        gc.addEvent(gc.new Bell(9000));
        Event[] events = {
                gc.new ThermostatNight(0),
                gc.new LightOn(2000),
                gc.new FanOn(3000),
                gc.new LightOff(4000),
                gc.new FanOff(5000),
                gc.new WaterOn(6000),
                gc.new WaterOff(8000),
                gc.new ThermostatDay(14000)
        };
        gc.addEvent(gc.new Restart(20000, events));
        if (args.length == 1)
            gc.addEvent(new GreenHouseControls24.Terminate(Integer.parseInt(args[0])));
        gc.run();
    }
}
