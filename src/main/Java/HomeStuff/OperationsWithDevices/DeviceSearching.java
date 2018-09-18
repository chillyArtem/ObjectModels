package HomeStuff.OperationsWithDevices;

import HomeStuff.device;

import java.util.ArrayList;

/**
 * Created by Artem_Berdnik on 9/18/2018.
 */
public class DeviceSearching {

    public static void searchByColor(ArrayList<device> arrayList, String color){
        for (device device : arrayList) {
            if (device.getColor().equalsIgnoreCase(color)){
                System.out.println(device.getModel());
            }
        }
    }
}
