package xam.cross.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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
		
		BookShopUser user = new BookShopUser(email, password, userHandler.setAuthorities("ROLE_USER"));
		userHandler.addUser(user);

		if (userHandler.getUserByEmail(user.getUsername())!=null){
			model.addAttribute("newUser", user);
		}
		return "bookShop";
	}
}
