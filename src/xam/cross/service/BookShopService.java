package xam.cross.service;

import java.util.List;

import xam.cross.Book;

public interface BookShopService {

	public List<Book> getBooksList();
	public void addNewBook(Book book);
	public Book findBookById(Integer id);
	
}
