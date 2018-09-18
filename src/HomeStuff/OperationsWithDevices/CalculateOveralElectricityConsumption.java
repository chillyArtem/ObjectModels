package HomeStuff.OperationsWithDevices;

import HomeStuff.device;

import java.util.ArrayList;

/**
 * Created by Artem_Berdnik on 9/18/2018.
 */
public class CalculateOveralElectricityConsumption {

    public static void calculate(ArrayList<device> devicesAtHome){
        double electricityConsumption = 0;
        for (device device : devicesAtHome) {
            electricityConsumption+=device.getTotalElectricityConsumption();
        }
        System.out.println("overall electricity consumption is" + electricityConsumption);
    }
}
