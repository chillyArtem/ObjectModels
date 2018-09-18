package HomeStuff;

/**
 * Created by Artem_Berdnik on 9/18/2018.
 */
public abstract class device implements Workable{

    private String model;
    private String color;
    private double electricityConsumption;
    private int price;
    private double totalElectricityConsumption;

    public device(String model, String color, double electricityConsumption, int price) {
        this.model = model;
        this.color = color;
        this.electricityConsumption = electricityConsumption;
        this.price = price;
    }


    private void setTotalElectricityConsumption(double totalElectricityConsumption) {
        this.totalElectricityConsumption = totalElectricityConsumption;
    }

    public double getElectricityConsumption() {
        return electricityConsumption;
    }

    @Override
    public void plugIn() {
        setTotalElectricityConsumption(getElectricityConsumption());
    }

    public double getTotalElectricityConsumption() {
        return totalElectricityConsumption;
    }

    public int getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }
}
