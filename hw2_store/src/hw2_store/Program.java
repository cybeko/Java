package hw2_store;

import java.util.List;

public class Program {
	public static void main(String[] args) {
		System.out.println("Total products across carts: " + OnlineStore.getTotalProducts()); 
		
		List<Purchasable> products = List.of(
			    new PhysicalProduct("Headphones", "Razer", 100, 0.4),
			    new DigitalProduct("Book", "Wattpad", 15, 200),
			    new PhysicalProduct("Watch", "Apple", 1000, 0.2)
			);
		
		Cart cart = new Cart(products);
		User user = new User("n_user", "Jean Doe", cart);
		
		OnlineStore.addUser(user);
		
		System.out.println("Total products across carts: " + OnlineStore.getTotalProducts()); 
		
		Product p7 = new PhysicalProduct("Keyboard", "Brand", 450, 0.5);
		cart.addItem(p7);
		
		System.out.println("Total products across carts: " + OnlineStore.getTotalProducts()); 
		
		cart.showCart();
		cart.purchaseAll();
		
		try {
            Product p1 = OnlineStore.findProductById(1);
            System.out.println(p1);
            
            Product p2 = OnlineStore.findProductById(128);
            System.out.println(p2);
            
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
	}
}
