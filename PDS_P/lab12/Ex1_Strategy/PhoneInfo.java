package lab12.Ex1_Strategy;

public class PhoneInfo {
    private String model;
    private String brand;
    private String cpu;
    private String price;
    private String ram;
    private String camera;

    public PhoneInfo(String model, String brand, String cpu, String price, String ram, String camera) {
        this.model = model;
        this.brand = brand;
        this.cpu = cpu;
        this.price = price;
        this.ram = ram;
        this.camera = camera;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

}
