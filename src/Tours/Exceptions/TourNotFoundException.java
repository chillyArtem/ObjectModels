package Tours.Exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Artem_Berdnik on 9/10/2018.
 */
public class TourNotFoundException extends Exception{

    public TourNotFoundException(){
        super();
    }

    public TourNotFoundException(String message){
        super(message);
    }

    public static void validateTour(String s) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            if (!s.equals("SHOP") && !s.equals("SIGHTSEEING")){
                throw new TourNotFoundException("Please select valid type of the tour");
            }
        }
        catch (TourNotFoundException ex){
            System.out.printf("%s%n%s%n%s", ex.getMessage(), " - Shop", " - Sightseeing");
            validateTour(reader.readLine());
        }
    }
}

