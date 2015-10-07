package xam.cross;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class BookShopUser extends User{
	
	private ShoppingCart cart;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4583963393651867664L;

	public BookShopUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}
	
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

}
