package ecommerce.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.example.ecommerce.model.MailModel;
import ecommerce.example.ecommerce.repo.MailRepo;

@Service
public class MailService {

    @Autowired
    private MailRepo mailRepo;

    public MailModel sendMail(MailModel mailModel) {
        return mailRepo.save(mailModel);
    }
}
