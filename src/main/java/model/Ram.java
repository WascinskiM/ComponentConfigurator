package model;

public class Ram {
    private String producer;
    private String model;
    private double price;
    private double frequency;

    public Ram(String producer, String model, double price, double frequency) {
        this.producer = producer;
        this.model = model;
        this.price = price;
        this.frequency = frequency;
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

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
}
