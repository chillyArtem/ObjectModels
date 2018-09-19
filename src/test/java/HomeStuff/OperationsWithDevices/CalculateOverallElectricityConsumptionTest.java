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

/**@SupressWarnings
 * Created by Artem_Berdnik on 9/18/2018.
 */
class CalculateOverallElectricityConsumptionTest {
    @Test
    @DisplayName("Check calculation works correctly")
    void calculate() {

        double totalElectricity = 0;

        Kettle k1 = new Kettle("a", "b", 2.0, 1000);
        Fridge f1 = new Fridge("b", "c", 1.5, 15000);
        Televisor t1 = new Televisor("c", "d", 0.2, 10000);

        ArrayList<device> a = new ArrayList<>();

        a.add(k1);
        a.add(f1);
        f1.plugIn();
        a.add(t1);

        for (device device : a) {
            totalElectricity += device.getTotalElectricityConsumption();
        }

        assertThat(totalElectricity).isEqualTo(1.5);
    }
}