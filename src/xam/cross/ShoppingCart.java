package xam.cross;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<Book> booksInCart;
	
	public ShoppingCart(List<Book> books){
		this.booksInCart = books;
	}
	
	public void addBookToCart(Book newBook){
		booksInCart.add(newBook);
	}
	
	public void removeBookFromCart(Book book){
		booksInCart.remove(book);
	}
	
	public int getNumberOfBooks(){
		return booksInCart.size();
	}
	
	public Book getBookByIndex(int index){
		return booksInCart.get(index);
	}
	
}
