package hw2_store;

import java.util.List;

public class Program {
	public static void main(String[] args) {
		System.out.println("Total products: " + OnlineStore.getTotalProducts()); 
		
		List<Product> products = List.of(
			    new Product("Headphones", "Brand", 1400),
			    new Product("Mouse", "Brand", 550),
			    new Product("Watch", "Brand", 1580)
			);
		
		Cart cart = new Cart(products);
		User user = new User("n_user", "Jean Doe", cart);
		
		OnlineStore.addUser(user);
		
		System.out.println("Total products: " + OnlineStore.getTotalProducts()); 
		
		Product p7 = new Product("Keyboard", "Brand", 450);
		cart.addProduct(p7);
		
		System.out.println("Total products: " + OnlineStore.getTotalProducts()); 

	}

}
