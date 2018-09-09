package Tours.Type_of_tour;

import Tours.Enums.Countries;

public class Shop_tour extends Tour {
    private Countries country;
    private int desiredNumberOfDays;


   public Shop_tour(Countries county) {
        this.country = county;
    }

    public Shop_tour(Countries county, int desiredNumberOfDays){
        this(county);
        this.desiredNumberOfDays = desiredNumberOfDays;
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
    public void applyCredit() {

    }
}
