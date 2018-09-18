package HomeStuff;

import HomeStuff.Devices.Fridge;
import HomeStuff.Devices.Kettle;
import HomeStuff.Devices.Televisor;
import HomeStuff.OperationsWithDevices.DeviceSearching;
import HomeStuff.OperationsWithDevices.DeviceSorting;
import HomeStuff.Technical.ReadFromFile;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Artem_Berdnik on 9/18/2018.
 */
public class Application {

    private ArrayList<device> devicesAtHome = new ArrayList<>();
    private ArrayList<device> devicesAtHome_2 = new ArrayList<>();

    void initialize() {

        //Fill a collection manually
        Fridge LG120 = new Fridge("LG 120", "black", 1.2, 35000);
        Kettle Phillips = new Kettle("Phillips 123", "Yellow", 1.5, 3000);
        Televisor apple = new Televisor("Apple set", "white", 0.2, 120000);

        devicesAtHome.add(LG120);
        devicesAtHome.add(Phillips);
        Phillips.plugIn();
        devicesAtHome.add(apple);
        apple.plugIn();

        //Fill another collection from a file


    }

    void start() throws IOException {
        //CalculateOveralElectricityConsumption.calculate(devicesAtHome);
        //DeviceSorting.sortByPrice(devicesAtHome);
        //DeviceSearching.searchByColor(devicesAtHome, "Black");

        devicesAtHome_2 = ReadFromFile.FillArraylistFromFile();
        DeviceSorting.sortByPrice(devicesAtHome_2);
        DeviceSearching.searchByColor(devicesAtHome_2, "red");
    }

    public static void main(String[] args) throws IOException {

        Application application = new Application();
        application.initialize();
        application.start();
    }
}
