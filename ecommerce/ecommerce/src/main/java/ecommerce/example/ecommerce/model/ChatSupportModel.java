package ecommerce.example.ecommerce.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "chat_box_db")
public class ChatSupportModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Mobile is required")
    private String mobile;

    @NotBlank(message = "Chatbox content is required")
    private String chatbox;

    private String adminReply;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date timestamp;

    // Getters & Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getChatbox() {
        return chatbox;
    }
    public void setChatbox(String chatbox) {
        this.chatbox = chatbox;
    }

    public String getAdminReply() {
        return adminReply;
    }
    public void setAdminReply(String adminReply) {
        this.adminReply = adminReply;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
