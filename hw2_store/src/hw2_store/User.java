package hw2_store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
	private String username;
	private String name;
	private List<Cart> carts;
	
	public User(String username, String name) {
        this.username = username;
        this.name = name;
        this.carts = new ArrayList<>();
    }
	
	public User(String username, String name, Cart cart) {
        this.username = username;
        this.name = name;
        this.carts = new ArrayList<>();
        if (cart != null) {
            this.carts.add(cart);
        }
    }
	
    public User(String username, String name, Cart... carts) {
        this.username = username;
        this.name = name;
        if (carts != null) {
            this.carts = new ArrayList<>(Arrays.asList(carts));
        } else {
            this.carts = new ArrayList<>();
        }
    }
	
	public void addCart(Cart cart) {
		carts.add(cart);
	}
	public void removeCart(Cart cart) {
        carts.remove(cart);
    }
	
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public List<Cart> getCarts() {
        return carts;
    }
    
    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
