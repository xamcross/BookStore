package xam.cross;

public class Buyer {

	private String login;
	private String password;
	private ShoppingCart cart;
	
	public Buyer (ShoppingCart cart){
		this.cart = cart;
	}
	
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
