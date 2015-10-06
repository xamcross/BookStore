package xam.cross.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xam.cross.Message;
import xam.cross.service.MessageBoardService;

@Controller
@RequestMapping("/messageDelete*")
public class MessageDeleteController {

	
	private MessageBoardService messageBoardService;
	
	@Autowired
	public MessageDeleteController(MessageBoardService messageBoardService){
		this.messageBoardService = messageBoardService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String messageDelete(@RequestParam(required=true, value="messageId") Long messageId, Model model){
		messageBoardService.deleteMessage(messageId);
		model.addAttribute("messages", messageBoardService.listMessages());
		return "messageList";
	}
	
}
