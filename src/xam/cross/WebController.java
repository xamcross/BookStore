package xam.cross;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		ShoppingCart cart = (ShoppingCart) context.getBean("shoppingCart");

		List<String> bookTitles = new ArrayList<>();

		for (int i = 0; i < cart.getNumberOfBooks(); i++) {
			bookTitles.add(cart.getBookByIndex(i).getTitle());
		}

		model.addAttribute("titles", bookTitles);
		return "index";
	}

	@RequestMapping(value = "/staticPage", method = RequestMethod.GET)
	public String redirect1() {

		return "redirect:/pages/final.htm";
	}

	public void showAllBooksInCart(ShoppingCart cart) {
		for (int i = 0; i < cart.getNumberOfBooks(); i++) {
			cart.getBookByIndex(i).getTitle();
		}
	}
}