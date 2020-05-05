package model;

public class GraphicCard {
    private String producer;
    private String model;
    private double price;
    private double efficiency;
    private double power;

    public GraphicCard(String producer, String model, double price, double efficiency, double power) {
        this.producer = producer;
        this.model = model;
        this.price = price;
        this.efficiency = efficiency;
        this.power = power;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }
}
