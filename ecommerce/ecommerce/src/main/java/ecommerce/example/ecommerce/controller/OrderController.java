package ecommerce.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ecommerce.example.ecommerce.model.OrderModel;
import ecommerce.example.ecommerce.service.OrderService;

@RestController
@RequestMapping("/orderlocation/v5")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderModel> getOrderById(@PathVariable int id) {
        try {
            System.out.println("Controller hit with Order ID: " + id);

            OrderModel order = orderService.getOrderById(id);
            System.out.println("Fetched order: " + order);

            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (Exception e) {
            System.err.println("Error occurred while fetching order: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
    @GetMapping("/byMobile/{mobile}")
    public ResponseEntity<List<OrderModel>> getOrdersByMobile(@PathVariable String mobile) {
        try {
            List<OrderModel> orders = orderService.getOrdersByMobile(mobile);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    
    //Updated Shipping 
      @PutMapping("/updateShippingSteps/{id}") 
      public ResponseEntity<OrderModel> updatedShipped(@PathVariable int id, @RequestBody  OrderModel shippedmdl)
      {
    	  OrderModel ordeshipped = orderService.shippedlocation(id, shippedmdl);
    			  
    			  return new ResponseEntity<>(ordeshipped, HttpStatus.OK);
    	  
      }
      
      //Order
      @PostMapping("/placeOrder")
      public ResponseEntity<OrderModel> placeOrder(@RequestBody OrderModel orderModel) {
          try {
              OrderModel savedOrder = orderService.saveOrder(orderModel);
              return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
          } catch (Exception e) {
              return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
      }
      
      
      @GetMapping("/all")
      public ResponseEntity<List<OrderModel>> getAllOrders() {
          try {
              List<OrderModel> allOrders = orderService.getAllOrders();
              return new ResponseEntity<>(allOrders, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
      }


}
