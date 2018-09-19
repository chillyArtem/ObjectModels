package HomeStuff.OperationsWithDevices;

import HomeStuff.Devices.Fridge;
import HomeStuff.Devices.Kettle;
import HomeStuff.Devices.Televisor;
import HomeStuff.device;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeviceSearchingTest {
    @DisplayName("Check searching by color")
    @Test
    void searchByColor() {

        String color = "green";
        int count = 0;

        Kettle k1 = new Kettle("a", "black", 2.0, 1000);
        Fridge f1 = new Fridge("b", "green", 1.5, 15000);
        Televisor t1 = new Televisor("c", "deep blue", 0.2, 10000);

        ArrayList<device> devices = new ArrayList<>();

        devices.add(k1);
        devices.add(f1);
        devices.add(t1);

        for (device device : devices) {
            if (device.getColor().equalsIgnoreCase(color)){
                count++;
            }
        }
        assertEquals(count,1);
    }
}