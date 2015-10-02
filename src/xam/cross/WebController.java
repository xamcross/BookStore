package xam.cross;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.glass.ui.Application;

@Controller
public class WebController {

   @RequestMapping(value = "/index", method = RequestMethod.GET)
   public String index(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("Beans.xml");
		
		Book book = (Book) context.getBean("book");
		
		ShoppingCart cart = (ShoppingCart) context.getBean("shoppingCart");
		
		Map<String, String> bookTitles = new HashMap<>();
		
		for (int i=0; i < cart.getNumberOfBooks(); i++){
			bookTitles.put(i+"", cart.getBookByIndex(i).getTitle());
		}
		
		request.setAttribute("bookTitles", bookTitles);
		
	   return "index";
   }
   
   @RequestMapping(value = "/staticPage", method = RequestMethod.GET)
   public String redirect1() {
     
      return "redirect:/pages/final.htm";
   }
   
   public void showAllBooksInCart(ShoppingCart cart){
	   for (int i=0; i < cart.getNumberOfBooks(); i++){
		   cart.getBookByIndex(i).getTitle();
	   }
   }
}