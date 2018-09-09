package Tours;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private String typeOfTour;
    private String country;
    private int desiredNumberOfDays;

    void init() throws IOException {
        System.out.println("What type of tour your want to buy?");
        typeOfTour = bufferedReader.readLine();
        System.out.println("What country you'd like to visit?");
        country = bufferedReader.readLine();
        System.out.println("How many days you want this tour long");
        desiredNumberOfDays = Integer.parseInt(bufferedReader.readLine());
    }

    void run(){

        if (typeOfTour.equals("Shop")){
            Shop_tour tour = new Shop_tour(country.toUpperCase(), desiredNumberOfDays);
            System.out.println(tour.calculateOverallPrice());
        }

    }

    public static void main(String[] args) throws IOException {
        Application application = new Application();
        application.init();
        application.run();
    }
}
