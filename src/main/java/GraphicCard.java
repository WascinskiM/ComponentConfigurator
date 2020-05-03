public class GraphicCard {
    private String producent;
    private String model;
    private double prize;
    private double efficiency;
    private double power;

    public GraphicCard(String producent, String model, double prize, double efficiency, double power) {
        this.producent = producent;
        this.model = model;
        this.prize = prize;
        this.efficiency = efficiency;
        this.power = power;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
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
