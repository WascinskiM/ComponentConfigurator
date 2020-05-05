package model;

public class MotherBoard {
    private String producer;
    private String model;
    private double price;
    private Socket socket;


    public MotherBoard(String producer, String model, double price, Socket socket) {
        this.producer = producer;
        this.model = model;
        this.price = price;
        this.socket = socket;
    }

    public MotherBoard() {
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

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}

