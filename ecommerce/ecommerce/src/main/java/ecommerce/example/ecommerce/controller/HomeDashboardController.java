package ecommerce.example.ecommerce.controller;

import ecommerce.example.ecommerce.model.HomeDashboardOrderDTO;
import ecommerce.example.ecommerce.model.HomeModel;
import ecommerce.example.ecommerce.repo.HomeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/home/dashboard")
@CrossOrigin("*")
public class HomeDashboardController {

    @Autowired
    private HomeRepo homeRepo;

    // getting from home_db  ALL orders
    @GetMapping("/recent-orders")
    public List<HomeDashboardOrderDTO> getRecentOrders() {
        List<HomeModel> products = homeRepo.findAll();
        List<HomeDashboardOrderDTO> orders = new ArrayList<>();

        String[] statuses = { "Delivered", "Shipped", "Processing", "Cancelled" };
        Random rand = new Random();

        for (HomeModel p : products) {
            orders.add(new HomeDashboardOrderDTO(
                p.getName(),
                p.getPrice(),
                statuses[rand.nextInt(statuses.length)]
            ));
        }

        return orders;
    }
    
    
    @GetMapping("/upcoming-deliveries")
    public List<HomeDashboardOrderDTO> getUpcomingDeliveries() {
        List<HomeModel> products = homeRepo.findAll();
        List<HomeDashboardOrderDTO> deliveries = new ArrayList<>();

        String[] statuses = { "Out for Delivery", "Shipped" };
        Random rand = new Random();

        for (HomeModel p : products) {
            // Only use products that have a brand (like Phone Case, Headphones, etc.)
            if (p.getBrand() != null && !p.getBrand().isEmpty()) {
                // Random date in next 10 days
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, rand.nextInt(10)); // within 10 days
                String date = String.format("%1$tY-%1$tm-%1$td", calendar);

                deliveries.add(new HomeDashboardOrderDTO(
                    p.getBrand(), // use brand name like "Headphones"
                    p.getPrice(),
                    statuses[rand.nextInt(statuses.length)],
                    date
                ));
            }
        }

        return deliveries;
    }

    
}
