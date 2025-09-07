package hw2_store;

import java.util.ArrayList;
import java.util.List;

public class OnlineStore {

	private static List<User> users;
	private static int totalProducts;
	
	static {
        users = new ArrayList<>();
        totalProducts = 0;

        Product p1 = new PhysicalProduct ("Phone", "Nokia", 100, 0.2);
        Product p2 = new PhysicalProduct("Charger", "Samsung", 30, 0.1);
        Product p3 = new PhysicalProduct("Laptop", "Apple", 2250, 2);

        Cart cart1 = new Cart(p1,p2);
        Cart cart2 = new Cart(p3);

        User u1 = new User("user1", "John Doe");
        u1.addCart(cart1);
        updateTotalProducts(u1.getCarts());

        User u2 = new User("user2", "Jane Doe");
        u2.addCart(cart2);
        updateTotalProducts(u2.getCarts());

        users.add(u1);
        users.add(u2);
    }
	public static List<User> getUsers() {
        return users;
    }
    public static void addUser(User user) {
        users.add(user);
        updateTotalProducts(user.getCarts());
    }
    
    public static int getTotalProducts() {
        return totalProducts;
    }
    
    private static void updateTotalProducts(List<Cart> carts) {
        for (Cart cart : carts) {
            totalProducts += cart.getItems().size();
        }
    }
    public static void incrementTotalProducts(int count) {
        totalProducts += count;
    }
    public static void purchaseAll(Purchasable[] items) {
        if (items == null || items.length == 0) {
            System.out.println("Cart is empty");
            return;
        }

        int total = 0;
        System.out.println("\nPurchasing items:");
        for (Purchasable i : items) {
            System.out.println(i.getName() + " - " + i.getPrice() + "$");
            total += i.getPrice();
        }

        System.out.println("\nPurchase successful");
        System.out.println("Total cost: " + total + "$");
    }
    
    public static Product findProductById(int id) throws ProductNotFoundException {
        for (User user : users) {
            for (Cart cart : user.getCarts()) {
                for (Purchasable item : cart.getItems()) {
                    if (item instanceof Product product) {
                        if (product.getId() == id) return product;
                    }
                }
            }
        }
        throw new ProductNotFoundException("Product with (ID: " + id + ") not found");
    }

}

