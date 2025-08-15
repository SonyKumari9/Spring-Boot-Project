package ecommerce.example.ecommerce.controller;

import ecommerce.example.ecommerce.model.ChatSupportModel;
import ecommerce.example.ecommerce.service.ChatSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce/chat")
@CrossOrigin(origins = "*")
public class ChatSupportController {

    @Autowired
    private ChatSupportService chatSupportService;

    @PostMapping("/send")
    public ResponseEntity<?> sendChat(@RequestBody ChatSupportModel chatModel) {
        try {
            ChatSupportModel saved = chatSupportService.sendOrUpdateChat(chatModel);
            return ResponseEntity.ok("Chat saved/updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save chat: " + e.getMessage());
        }
    }

    @GetMapping("/history/{mobile}")
    public ResponseEntity<List<ChatSupportModel>> getChatHistoryByMobile(@PathVariable String mobile) {
        return ResponseEntity.ok(chatSupportService.getChatByMobile(mobile));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChatSupportModel>> getAllChats() {
        return ResponseEntity.ok(chatSupportService.getAllChats());
    }
}
