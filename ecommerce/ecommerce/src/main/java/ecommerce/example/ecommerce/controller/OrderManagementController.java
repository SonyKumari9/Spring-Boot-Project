package ecommerce.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import ecommerce.example.ecommerce.model.OrderManagementModel;
import ecommerce.example.ecommerce.repo.OrderManagementRepo;


@RestController
@RequestMapping("/orders/management")
@CrossOrigin
public class OrderManagementController {

    @Autowired
    private OrderManagementRepo orderRepo;

    @GetMapping("/all")
    public List<OrderManagementModel> getAllOrders() {
        return orderRepo.findAll();
    }

    @GetMapping("/{id}")
    public OrderManagementModel getOrderById(@PathVariable Long id) {
        return orderRepo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public OrderManagementModel updateStatus(@PathVariable Long id, @RequestBody OrderManagementModel updatedOrder) {
    	OrderManagementModel existing = orderRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setStatus(updatedOrder.getStatus());
            return orderRepo.save(existing);
        }
        return null;
    }
}

