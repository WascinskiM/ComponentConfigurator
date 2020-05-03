public class Ram {
    private String producent;
    private String model;
    private double prize;
    private double frequency;

    public Ram(String producent, String model, double prize, double frequency) {
        this.producent = producent;
        this.model = model;
        this.prize = prize;
        this.frequency = frequency;
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

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
}
