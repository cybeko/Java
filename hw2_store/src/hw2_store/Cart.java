package hw2_store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cart {
	private List<Product> products;
	
	public Cart() {
        products = new ArrayList<>();
    }
	
    public Cart(Product... products) {
        this.products = new ArrayList<>(Arrays.asList(products));
    }
    public Cart(List<Product> products) {
        this.products = new ArrayList<>(products);
    }
    
    public List<Product> getProducts() {
        return products;
    }
	
	public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to cart");
        
        OnlineStore.incrementTotalProducts(1);

    }

    public void removeProduct(Product product) {
        products.remove(product);
        System.out.println(product.getName() + " removed from cart");
    }
    
    public void showCart() {
        if (products.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }
        else {
            System.out.println("Cart:");
            for (Product p : products) {
                System.out.println(p.getName() + " (" + p.getBrand() + ") - " + p.getPrice() + "$");
            }
        }
    }
}
