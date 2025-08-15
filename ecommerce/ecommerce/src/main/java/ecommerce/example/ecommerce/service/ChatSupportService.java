package ecommerce.example.ecommerce.service;

import ecommerce.example.ecommerce.model.ChatSupportModel;
import ecommerce.example.ecommerce.repo.ChatSupportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatSupportService {

    @Autowired
    private ChatSupportRepo chatSupportRepo;

    public ChatSupportModel sendOrUpdateChat(ChatSupportModel chatModel) {
        
        if (chatModel.getId() != null) {
            Optional<ChatSupportModel> existingById = chatSupportRepo.findById(chatModel.getId());
            if (existingById.isPresent()) {
                ChatSupportModel chat = existingById.get();
                if (chatModel.getAdminReply() != null && !chatModel.getAdminReply().isBlank()) {
                    chat.setAdminReply(chatModel.getAdminReply());
                }
                return chatSupportRepo.save(chat);
            }
        }

        // ✅ If it's a new chat message from user
        return chatSupportRepo.save(chatModel);
    }


    public List<ChatSupportModel> getChatByMobile(String mobile) {
        return chatSupportRepo.findAllByMobileOrderByTimestampAsc(mobile);
    }

    public List<ChatSupportModel> getAllChats() {
        return chatSupportRepo.findAll(Sort.by(Sort.Direction.DESC, "timestamp"));
    }
}
