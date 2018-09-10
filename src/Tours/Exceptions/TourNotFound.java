package Tours.Exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Artem_Berdnik on 9/10/2018.
 */
public class TourNotFound extends Exception{

    public TourNotFound(){
        super();
    }

    public TourNotFound(String message){
        super(message);
    }

    public static void validateTour(String s) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            if (!s.toUpperCase().equals("SHOP") || !s.toUpperCase().equals("SIGHTSEEING")){
                throw new TourNotFound("Please select valid type of the tour");
            }
        }
        catch (TourNotFound ex){
            System.out.printf("%s%n%s%n%s", ex.getMessage(), " - Shop", " - Sightseeing");
            validateTour(reader.readLine());
        }
    }
}

