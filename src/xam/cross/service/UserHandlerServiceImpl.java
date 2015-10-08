package xam.cross.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import xam.cross.BookShopUser;

@Component
public class UserHandlerServiceImpl implements UserHandlerService {

	private List<BookShopUser> users = new ArrayList<BookShopUser>();

	private InMemoryUserDetailsManager userDetailsManager;

	private DaoAuthenticationProvider provider;

	public UserHandlerServiceImpl() {
		provider = new DaoAuthenticationProvider();
		BookShopUser admin = new BookShopUser("admin2", "qwerty123", setAuthorities("ROLE_ADMIN"));

		List<UserDetails> userDetails = new ArrayList<>();
		userDetailsManager = new InMemoryUserDetailsManager(userDetails);

		addUser(admin);
	}

	@Override
	public List<BookShopUser> getUsers() {
		return users;
	}

	@Override
	public void addUser(BookShopUser user) {

		if (!userDetailsManager.userExists(user.getUsername())) {
			userDetailsManager.createUser(user);
			users.add(user);
			
			provider.setUserDetailsService(userDetailsManager);
		}
	}

	@Override
	public BookShopUser getUserByEmail(String email) {
		for (BookShopUser user : users) {
			if (user.getUsername().equals(email))
				return user;
		}
		return null;
	}

	public List<SimpleGrantedAuthority> setAuthorities(String... authorities) {
		List<SimpleGrantedAuthority> authoritiesList = new ArrayList<SimpleGrantedAuthority>();
		for (int i = 0; i < authorities.length; i++) {
			authoritiesList.add(new SimpleGrantedAuthority(authorities[i]));
		}
		return authoritiesList;
	}

}
