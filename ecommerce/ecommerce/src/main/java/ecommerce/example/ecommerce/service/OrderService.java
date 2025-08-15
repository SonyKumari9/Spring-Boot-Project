package ecommerce.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.example.ecommerce.model.OrderModel;
import ecommerce.example.ecommerce.repo.OrderRepo;



@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public OrderModel getOrderById(int id) {
        System.out.println("Fetching Order with ID: " + id);
        return orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
    }

    public OrderModel shippedlocation(int id, OrderModel shippedmdl) {
        OrderModel existingOrder = orderRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));

        
        existingOrder.setShippingAddresses(shippedmdl.getShippingAddresses());

        return orderRepo.save(existingOrder);
    }
    
    //Order
    public OrderModel saveOrder(OrderModel order) {
        return orderRepo.save(order);
    }
    
    
    

    public List<OrderModel> getAllOrders() {
        return orderRepo.findAll();
    }

    
    public List<OrderModel> getOrdersByMobile(String mobile) {
        return orderRepo.findByMobile(mobile);
    }




}
