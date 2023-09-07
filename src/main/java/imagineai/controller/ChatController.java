package imagineai.controller;

import imagineai.model.Chat;
import imagineai.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chats")
public class ChatController extends BaseController<Chat, String> {
    @Autowired
    public ChatController(ChatService chatService) {
        super(chatService);
    }
}
