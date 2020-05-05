package model;

public class Processor {
    private Producer producer;
    private String model;
    private double price;
    private double efficiency;
    private double power;

    public Processor(Producer producer, String model, double price, double efficiency, double power) {
        this.producer = producer;
        this.model = model;
        this.price = price;
        this.efficiency = efficiency;
        this.power = power;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
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

    @Override
    public String toString() {
        return "model.Processor{" +
                "producent='" + producer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
