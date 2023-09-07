package imagineai.service;

import imagineai.model.Chat;
import imagineai.repository.ChatRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatService extends BaseService<Chat, String> {
    public ChatService(ChatRepository repository) {
        super(repository);
    }
}
