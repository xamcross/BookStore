package xam.cross.service;

import java.util.List;

import xam.cross.BookShopUser;

public interface UserHandlerService {

	public List<BookShopUser> getUsers();
	public void addUser(BookShopUser user);
	public BookShopUser getUserByEmail(String email);
	
}
