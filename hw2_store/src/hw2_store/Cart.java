package hw2_store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cart {
	private List<Purchasable> items;
	
	public Cart() {
        items = new ArrayList<>();
    }
	
    public Cart(Purchasable... items) {
        this.items = new ArrayList<>(Arrays.asList(items));
    }
    public Cart(List<Purchasable> items) {
        this.items = new ArrayList<>(items);
    }
    
    public List<Purchasable> getItems() {
        return items;
    }
	
	public void addItem(Product product) {
        items.add(product);
        System.out.println(product.getName() + " added to cart");
        
        OnlineStore.incrementTotalProducts(1);

    }

    public void removeItem(Product product) {
        items.remove(product);
        System.out.println(product.getName() + " removed from cart");
    }
    
    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("\nCart is empty");
            return;
        }
        else {
            System.out.println("\nCart:");
            for (Purchasable i : items) {
                System.out.println(i.getName() + " (" + i.getBrand() + ") - " + i.getPrice() + "$");
            }
        }
    }
    public void purchaseAll() {
        OnlineStore.purchaseAll(items.toArray(new Purchasable[0]));
    }
}
