package Tours;

import Tours.Enums.Countries;
import Tours.Enums.Transport;
import Tours.Enums.TypeOfFeed;
import Tours.Type_of_tour.Shop_tour;
import Tours.Type_of_tour.Sightseeing_tour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Application {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private String typeOfTour;
    private Countries country;
    private int desiredNumberOfDays;
    private Transport transport;
    private TypeOfFeed typeOfFood;


    public static void main(String[] args) throws IOException {
        Application application = new Application();
        application.init();
        application.run();
    }

    void init() throws IOException {
        System.out.printf("%s%n%s%n%s%n", "What type of tour your want to buy:", " - Shop", " - Sightseeing");
        typeOfTour = bufferedReader.readLine();
        System.out.printf("%s%n%s%n%s%n%s%n", "What country you'd like to visit:", " - Estonia", " - Finland", " - Russia");
        country = Countries.valueOf(bufferedReader.readLine().toUpperCase());
        System.out.println("How many days you want this tour long");
        desiredNumberOfDays = Integer.parseInt(bufferedReader.readLine());
        if (!typeOfTour.equals("Shop")) {
            System.out.printf("%s%n%s%n%s%n%s%n%s%n", "What transport would you like to use:", "Please note traveling by bus is by default", " - Plane", " - Train", " - Bus");
            try {
                transport = Transport.valueOf(bufferedReader.readLine().toUpperCase());
            } catch (NullPointerException ex) {
                transport = Transport.BUS;
            }
            System.out.printf("%s%n%s%n%s%n%s%n%s%n", "Do you wanna add food to your trip:", "Please note by default no food being provided", " - BB", " - BO", " - AI");
            try {
                typeOfFood = TypeOfFeed.valueOf(bufferedReader.readLine().toUpperCase());
            } catch (IllegalArgumentException ex) {
                typeOfFood = null;
            }
        }
    }

    void run() {

        if (typeOfTour.equals("Shop")) {
            Shop_tour tour = new Shop_tour(country, desiredNumberOfDays);
            System.out.println(tour.calculateOverallPrice());
        }

        if (typeOfTour.equals("Sightseeing")) {
            if (typeOfFood != null){
                Sightseeing_tour tour = new Sightseeing_tour(country, desiredNumberOfDays, transport, typeOfFood);
                System.out.println(tour.provideFeed());
            }
            else{
                Sightseeing_tour tour = new Sightseeing_tour(country, desiredNumberOfDays, transport);
                System.out.println(tour.calculateOverallPrice());
            }

        }

    }
}
