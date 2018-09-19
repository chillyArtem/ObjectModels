package Tours.Exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Artem_Berdnik on 9/10/2018.
 */
public class TourDurationException extends Exception{
    public TourDurationException(String message){
        super(message);
    }

    public static void validateTour(int n) throws TourDurationException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            if (n < 3 || n > 21){
                throw new TourDurationException("Incorrect duration. Please select a duration within 3-21 days");
            }
        }
        catch (TourDurationException ex){
            System.out.println(ex.getMessage());
            validateTour(Integer.parseInt(reader.readLine()));
        }


    }
}
