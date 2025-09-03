package hw2_store;

import java.util.ArrayList;
import java.util.List;

public class OnlineStore {

	private static List<User> users;
	private static int totalProducts;
	
	static {
        users = new ArrayList<>();
        totalProducts = 0;

        Product p1 = new Product("Phone", "Brand1", 660);
        Product p2 = new Product("Charger", "Brand2", 30);
        Product p3 = new Product("Laptop", "Brand3", 1650);

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
            totalProducts += cart.getProducts().size();
        }
    }
    public static void incrementTotalProducts(int count) {
        totalProducts += count;
    }

}
