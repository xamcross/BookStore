package xam.cross.service;

import java.util.List;

import xam.cross.Message;

public interface MessageBoardService {

	public List<Message> listMessages();
	public void postMessage(Message message);
	public void deleteMessage(Long id);
	public Message findMessageById(Long id);
	
}
