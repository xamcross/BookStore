package xam.cross.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xam.cross.Book;
import xam.cross.service.BookShopService;

@Controller
public class BookCreationController {

	private BookShopService bookShop;
	
	@Autowired
	public BookCreationController(BookShopService bookShop){
		this.bookShop = bookShop;
	}
	
	@RequestMapping(value="/bookCreation", method=RequestMethod.GET)
	public String bookCreationForm(Model model){
		Book book = new Book();
		model.addAttribute("book", book);
		return "bookCreation";
	}
	
	@RequestMapping(value="/bookCreation", method=RequestMethod.POST)
	public String onSubmit(@ModelAttribute ("book") Book book, BindingResult result){
		if (result.hasErrors()){
			return "bookCreation";
		}
		else {
			bookShop.addNewBook(book);
			return "redirect:messageList";
		}
		
	}
	
}
