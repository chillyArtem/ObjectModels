package Tours;

public class Shop_tour extends Tour {
    private String country;
    private int desiredNumberOfDays;


    Shop_tour(String county) {
        this.country = county;
    }

    Shop_tour(String county, int desiredNumberOfDays){
        this(county);
        this.desiredNumberOfDays = desiredNumberOfDays;
    }

    @Override
    public int calculateOverallPrice() {
        switch (country){
            case ("ESTONIA"):
                return 1500 * desiredNumberOfDays;
            case ("FINLAND"):
                return 2500 * desiredNumberOfDays;
            default:
                System.out.println("There's no such country in our list");
        }
        return 0;
    }

    @Override
    public void applyCredit() {

    }
}
