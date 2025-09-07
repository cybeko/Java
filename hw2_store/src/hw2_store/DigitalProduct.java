package hw2_store;

public class DigitalProduct extends Product {
	private int memorySize;
	
	public DigitalProduct(String name, String brand, int price, int memorySize) {
        super(name, brand, price);
        this.memorySize = memorySize;
    }
	
	public DigitalProduct() {
        super();
        this.memorySize = 0;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }
    
    @Override
    public String toString() {
        return getName() + " (" + getBrand() + "), (ID: " + getId() + ") - " + getPrice() + "$, Memory: " + memorySize + "mb";
        
    }

}
