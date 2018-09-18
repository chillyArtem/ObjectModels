package Tours;


import Tours.Enums.*;
//import Tours.Type_of_tour.Available_tours;
import Tours.Exceptions.TourDurationException;
import Tours.Exceptions.TourNotFoundException;
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
    private int creditDuration;


    public static void main(String[] args) throws IOException, TourNotFoundException, TourDurationException {
        Application application = new Application();
        application.init();
        application.run();
    }

    void init() throws IOException, TourNotFoundException, TourDurationException {
        System.out.printf("%s%n%s%n%s%n", "What type of tour your want to buy:", " - Shop", " - Sightseeing");
        typeOfTour = bufferedReader.readLine().toUpperCase();
        TourNotFoundException.validateTour(typeOfTour);


        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n", "What country you'd like to visit:", Countries.ESTONIA, Countries.FINLAND, Countries.FRANCE, Countries.GERMANY, Countries.ITALIA, Countries.RUSSIA);
        try{
            country = Countries.valueOf(bufferedReader.readLine().toUpperCase());
        }
        catch (IllegalArgumentException ex){
            System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n", "No such country in our list.","Please select correct country from the list: ", Countries.ESTONIA, Countries.FINLAND, Countries.FRANCE, Countries.GERMANY, Countries.ITALIA, Countries.RUSSIA);
            country = Countries.valueOf(bufferedReader.readLine().toUpperCase());
        }

        if (typeOfTour.toUpperCase().equals("SHOP")) {
            System.out.print("Please see what tours to the country we have: " + "\n");
            //Available_tours.getShopTour(country);
            System.out.println();
        }
        if (typeOfTour.toUpperCase().equals("SIGHTSEEING")) {
            System.out.print("Please see what tours to the country we have: ");
            //Available_tours.getSightseeingTour(country);
            System.out.println();
        }

        System.out.println("How many days you want this tour long");
        TourDurationException.validateTour(desiredNumberOfDays = Integer.parseInt(bufferedReader.readLine()));

        if (!typeOfTour.equals("SHOP")) {
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

        System.out.println("Do you wanna have a credit? ");
        if (bufferedReader.readLine().toUpperCase().equals("YES")) {
            System.out.printf("%s%n%s%n%s%n%s%n%s%n", "How long the credit should be: ", "6 months", "12 months", "18 months", "24 months");
            try {
                creditDuration = Integer.parseInt(bufferedReader.readLine());
            } catch (IllegalArgumentException ex) {
                System.out.println("Entered incorrect number of months. Please try again");
                creditDuration = Integer.parseInt(bufferedReader.readLine());
            }
        }
    }

    void run() {

        if (typeOfTour.toUpperCase().equals("SHOP")) {
            if (creditDuration > 0) {
                Shop_tour tour = new Shop_tour(country, desiredNumberOfDays, creditDuration);
                System.out.println(tour.applyCredit());

            } else {
                Shop_tour tour = new Shop_tour(country, desiredNumberOfDays);
                System.out.println(tour.calculateOverallPrice());
            }
        }

        if (typeOfTour.toUpperCase().equals("SIGHTSEEING")) {
            if (typeOfFood != null) {
                if (creditDuration > 0) {
                    Sightseeing_tour tour = new Sightseeing_tour(country, desiredNumberOfDays, transport, typeOfFood, creditDuration);
                    System.out.println(tour.applyCredit());
                } else {
                    Sightseeing_tour tour = new Sightseeing_tour(country, desiredNumberOfDays, transport, typeOfFood);
                    System.out.println(tour.provideFeed());
                }

            } else if (creditDuration > 0) {
                Sightseeing_tour tour = new Sightseeing_tour(country, desiredNumberOfDays, transport, creditDuration);
                System.out.println(tour.applyCredit());
            } else {
                Sightseeing_tour tour = new Sightseeing_tour(country, desiredNumberOfDays, transport);
                System.out.println(tour.calculateOverallPrice());
            }

        }

    }
}
