package HomeStuff.Technical;

import HomeStuff.Devices.Kettle;
import HomeStuff.device;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Artem_Berdnik on 9/18/2018.
 */
public class ReadFromFile {
    public static ArrayList<device> FillArraylistFromFile() throws IOException {
        ArrayList<device> arrayList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\ObjectModels\\src\\HomeStuff\\kettles.txt")));
            String str;
            while ((str = reader.readLine()) != null) {
                String m[] = str.split(" ");
                arrayList.add(new Kettle(m[0], m[1], Double.valueOf(m[2]), Integer.valueOf(m[3])));
            }
        } catch (IOException e) {
            System.out.println("error");
        }
        return arrayList;
    }
}
