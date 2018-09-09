package Tours;

public abstract class Tour implements Creditable {

    private String country;
    private long price;
    private int desiredNumberOfDays;
    private String transport;
    private String typeOfTour;
    private long overal_price;

    public int getDesiredNumberOfDays() {
        return desiredNumberOfDays;
    }

    public String getTransport() {
        return transport;
    }

    public String getTypeOfTour() {
        return typeOfTour;
    }

    public long getOveral_price() {
        return overal_price;
    }
    //    Tour(String country, long price){
//        this.country = country;
//        this.price = price;
//    }


    public long getPrice() {
        return price;
    }

    public String getCountry() {
        return country;
    }

    public abstract int calculateOverallPrice();


}
