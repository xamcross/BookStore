package xam.cross.service;

import java.util.ArrayList;
import java.util.List;

import xam.cross.BookShopUser;

public class UserHandlerServiceImpl implements UserHandlerService{

	private List<BookShopUser> users = new ArrayList<BookShopUser>();
	
	@Override
	public List<BookShopUser> getUsers() {
		return users;
	}

	@Override
	public void addUser(BookShopUser user) {
		users.add(user);
	}

	@Override
	public BookShopUser getUserByEmail(String email) {
		for (BookShopUser user : users){
			if (user.getUsername().equals(email))
				return user;
		}
		return null;
	}
	
}
