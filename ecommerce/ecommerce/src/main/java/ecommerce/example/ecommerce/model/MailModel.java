package ecommerce.example.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "mail_db")
public class MailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid mobile number")
    private String mobile;

    @NotBlank(message = "Message content is required")
    @Size(min = 5, message = "Content must be at least 5 characters")
    private String content;

    @NotBlank(message = "Email ID is required")
    @Email(message = "Invalid email format")
    private String mailid;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMailid() {
        return mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
    }
}
