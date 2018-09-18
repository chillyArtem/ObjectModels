package HomeStuff.OperationsWithDevices;

import HomeStuff.device;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Artem_Berdnik on 9/18/2018.
 */
public class DeviceSorting {
    public static void sortByPrice(ArrayList<device> devices) {
        compareByPrice comparator = new compareByPrice();
        devices.sort(comparator);
        for (device device : devices) {
            System.out.println(device.getModel());
        }
    }
}

class compareByPrice implements Comparator<device> {

    @Override
    public int compare(device device, device t1) {
        return Integer.compare(device.getPrice(), t1.getPrice());
    }
}
