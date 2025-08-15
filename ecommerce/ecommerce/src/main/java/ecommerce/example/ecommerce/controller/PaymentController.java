package ecommerce.example.ecommerce.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ecommerce.example.ecommerce.model.PaymentModel;
import ecommerce.example.ecommerce.repo.PaymentRepository;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepo;

    @PostMapping("/save")
    public ResponseEntity<String> savePayment(@RequestBody PaymentModel payment) {
        paymentRepo.save(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body("Payment saved successfully");
    }

}

