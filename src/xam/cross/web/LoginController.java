package xam.cross.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xam.cross.Book;
import xam.cross.service.BookShopService;
import xam.cross.service.UserHandlerService;

@Controller
public class LoginController {

	private BookShopService bookShop;

	private UserHandlerService userHandler;

	@Autowired
	public LoginController(BookShopService bookShop, UserHandlerService userHandler) {
		this.bookShop = bookShop;
		this.userHandler = userHandler;
	}

	@RequestMapping(value = "/login")
	public String login(Model model) {
		model.addAttribute("users", userHandler.getUsers());
		return "login";
	}

	@RequestMapping(value = "/register")
	public String register() {
		return "registration";
	}

	@RequestMapping(value = "/bookShop")
	public String bookShop(Model model) {
		List<Book> books = bookShop.getBooksList();
		model.addAttribute("books", books);
		return "bookShop";
	}

}