package ecommerce.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import ecommerce.example.ecommerce.model.MailModel;
import ecommerce.example.ecommerce.service.MailService;
import org.springframework.validation.BindingResult;

@RestController
@RequestMapping("/mailsend/v4")
@CrossOrigin(origins = "*")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/mail")
    public ResponseEntity<?> sendingMail(@Valid @RequestBody MailModel mailModel, BindingResult result) {
        if (result.hasErrors()) {
            String errorMsg = result.getFieldErrors().stream()
                    .map(err -> err.getField() + ": " + err.getDefaultMessage())
                    .reduce("", (a, b) -> a + b + "; ");
            return new ResponseEntity<>(errorMsg.trim(), HttpStatus.BAD_REQUEST);
        }

        MailModel savedMail = mailService.sendMail(mailModel);
        return new ResponseEntity<>(savedMail, HttpStatus.OK);
    }
}
