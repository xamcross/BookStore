package xam.cross.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xam.cross.Message;
import xam.cross.service.MessageBoardService;

@Controller
@RequestMapping("/messageList*")
public class MessageListController {

	private MessageBoardService messageBoardService;
	
	@Autowired
	public MessageListController(MessageBoardService messageBoardService){
		this.messageBoardService = messageBoardService;
	}
	
	@RequestMapping()
	public String generateList(Model model){
		List<Message> messages = java.util.Collections.emptyList();
		messages = messageBoardService.listMessages();
		model.addAttribute("messages", messages);
		return "messageList";
	}
}
