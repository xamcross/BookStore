package xam.cross.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xam.cross.BookShopUser;
import xam.cross.service.UserHandlerService;

@Controller
public class UserCreationController {

	private UserHandlerService userHandler;
	
	@Autowired
	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	
	
	@Autowired
	public UserCreationController(UserHandlerService userHandler){
		this.userHandler = userHandler;
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String userCreationForm(){
		return "registration";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String userCreationForm(HttpServletRequest request, Model model){
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		BookShopUser user = new BookShopUser(email, password, authorities);
		userHandler.addUser(user);
		List<UserDetails> userDetails = new ArrayList<>();
		userDetails.addAll(userHandler.getUsers());
		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager(userDetails);
		provider.setUserDetailsService(userDetailsManager);
		if (userDetailsManager.userExists(user.getUsername())){
			model.addAttribute("newUser", user);
		}
		return "bookShop";
	}
}
