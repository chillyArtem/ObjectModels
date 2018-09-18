package HomeStuff.Technical;

import HomeStuff.device;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Artem_Berdnik on 9/18/2018.
 */
public class WriteToFile {

    public static void write(device device) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\ObjectModels\\src\\main\\Java\\HomeStuff\\fridges.txt"))) {
            String writeMe = device.getModel() + " " + device.getColor() + " " + device.getElectricityConsumption() + " " + device.getPrice();
            System.out.println(writeMe);

            bufferedWriter.write(writeMe);
        } catch (FileNotFoundException f) {
            System.out.println("No file found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

