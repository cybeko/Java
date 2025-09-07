package hw2_store;

public class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct(String name, String brand, int price, double weight) {
        super(name, brand, price);
        this.weight = weight;
    }

    public PhysicalProduct() {
        super();
        this.weight = 0.0;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return getName() + " (" + getBrand() + "), (ID: " + getId() + ") - " + getPrice() + "$, Weight: " + weight + "kg";
    }
}
