package xam.cross.service;

import java.util.ArrayList;
import java.util.List;

import xam.cross.Book;

public class BookShopServiceImpl implements BookShopService{

	private List<Book> books = new ArrayList<Book>();
	
	@Override
	public List<Book> getBooksList() {
		return books;
	}

	@Override
	public void addNewBook(Book book) {
		books.add(book);
	}

	@Override
	public Book findBookById(Integer id) {
		for (Book book : books){
			if(book.getId() == id){
				return book;
			}
		}
		return null;
	}

}
