package Tours.Type_of_tour;

import Tours.Enums.Countries;

public class Shop_tour extends Tour {
    private Countries country;
    private int desiredNumberOfDays;
    private int creditDuration;


   public Shop_tour(Countries county) {
        this.country = county;
    }

    public Shop_tour(Countries county, int desiredNumberOfDays){
        this(county);
        this.desiredNumberOfDays = desiredNumberOfDays;
    }
    public Shop_tour(Countries county, int desiredNumberOfDays, int creditDuration){
        this(county, desiredNumberOfDays);
        this.creditDuration = creditDuration;
    }

    @Override
    public int calculateOverallPrice() {
        switch (country){
            case RUSSIA:
                return 1500 * desiredNumberOfDays;
            case ITALIA:
                return 3500 * desiredNumberOfDays;
            case FRANCE:
                return 3800 * desiredNumberOfDays;
            case GERMANY:
                return 2100 * desiredNumberOfDays;
            case FINLAND:
                return 1900 * desiredNumberOfDays;
            case ESTONIA:
                return 1800 * desiredNumberOfDays;
            default:
                System.out.println("There's no such country in our list");
        }
        return 0;
    }

    @Override
    public String applyCredit() {
        if (creditDuration == 6) {
            return "Monthly payment = " + calculateOverallPrice() / 6 * 1.15 + "\n" + "Overall price = " + calculateOverallPrice() * 1.15;
        }
        if (creditDuration == 12){
            return "Monthly payment = " + calculateOverallPrice() / 6 * 1.23 + "\n" + "Overall price = " + calculateOverallPrice() * 1.23;
        }
        if (creditDuration == 18){
            return "Monthly payment = " + calculateOverallPrice() / 6 * 1.33 + "\n" + "Overall price = " + calculateOverallPrice() * 1.33;
        }
        else {
            return  "Monthly payment = " + calculateOverallPrice() / 6 * 1.39 + "\n" + "Overall price = " + calculateOverallPrice() * 1.39;
        }
    }
}
