package xam.cross.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import xam.cross.Message;

public class MessageBoardServiceImpl implements MessageBoardService {

	private Map<Long, Message> messages = new LinkedHashMap<Long, Message>();
	
	@Override
	public List<Message> listMessages() {
		return new ArrayList<Message>(messages.values());
	}

	@Override
	public synchronized void postMessage(Message message) {
		message.setId(System.currentTimeMillis());
		messages.put(message.getId(), message);
	}

	@Override
	public synchronized void deleteMessage(Long id) {
		messages.remove(id);
	}

	@Override
	public Message findMessageById(Long id) {
		return messages.get(id);
	}

}
