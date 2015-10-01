package xam.cross;

import java.util.List;

public class BookShop {

	private List<Book> books;
	
	public BookShop(List<Book> books){
		this.books = books;
	}
	
	public void addBookToCart(Book newBook){
		books.add(newBook);
	}
	
	public void removeBookFromCart(Book book){
		books.remove(book);
	}
	
	public int getNumberOfBooks(){
		return books.size();
	}
	
	public Book getBookByIndex(int index){
		return books.get(index);
	}
	
	
}
