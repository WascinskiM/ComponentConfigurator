public class MotherBoard {
    private String producent;
    private String model;
    private double prize;
    private boolean Amdcompability;
    private boolean Intelcompability;

    public MotherBoard(String producent, String model, double prize, boolean amdcompability, boolean intelcompability) {
        this.producent = producent;
        this.model = model;
        this.prize = prize;
        Amdcompability = amdcompability;
        Intelcompability = intelcompability;
    }

    public MotherBoard() {
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

    public boolean isAmdcompability() {
        return Amdcompability;
    }

    public void setAmdcompability(boolean amdcompability) {
        Amdcompability = amdcompability;
    }

    public boolean isIntelcompability() {
        return Intelcompability;
    }

    public void setIntelcompability(boolean intelcompability) {
        Intelcompability = intelcompability;
    }
}
