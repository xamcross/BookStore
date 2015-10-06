package xam.cross.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xam.cross.Message;
import xam.cross.service.MessageBoardService;

@Controller
@RequestMapping("/messagePost*")
public class MessagePostController {

	private MessageBoardService messageBoardService;
	
	@Autowired
	public MessagePostController(MessageBoardService messageBoardService){
		this.messageBoardService = messageBoardService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String setupForm(Model model){
		Message message = new Message();
		model.addAttribute("message", message);
		return "messagePost";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String onSubmit(@ModelAttribute ("message") Message message, BindingResult result){
		if (result.hasErrors()){
			return "messagePost";
		}
		else {
			messageBoardService.postMessage(message);
			return "redirect:messageList";
		}
		
	}
	
}
