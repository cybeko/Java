package hw2_store;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = -4376746570433411484L;

	public ProductNotFoundException(String message) {
        super(message);
    }
}