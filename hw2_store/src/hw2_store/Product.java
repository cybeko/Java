package hw2_store;

public abstract class Product implements Purchasable {

    private int id;
	private static int incrId = 1;
	private String name;
	private String brand;
	private int price;
	
	public Product(String name, String brand, int price) {
		this.id = incrId++;
        this.name = name;
        this.brand = brand;
        this.setPrice(price);
    }
	
	public Product() {
        this.name = "Undefined";
        this.brand = "Undefined";
        this.setPrice(0);
	}

	public int getId() {
        return id;
    }
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getName() {
	    return name;
	}
	
    public void setName(String name) {
        this.name = name;
    }

	public String getBrand() {
	    return brand;
	}
	public void setBrand(String brand) {
        this.brand = brand;
    }
	
    @Override
	public abstract String toString();

	@SuppressWarnings("removal")
	@Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Finalizing Product: " + name + " (" + brand + ")");
        } finally {
            super.finalize();
        }
    }
}
