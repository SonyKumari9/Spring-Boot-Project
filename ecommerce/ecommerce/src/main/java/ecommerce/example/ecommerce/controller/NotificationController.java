package ecommerce.example.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ecommerce.example.ecommerce.model.CategoryModel;
import ecommerce.example.ecommerce.model.NotificationModel;
import ecommerce.example.ecommerce.repo.CategoryRepository;

@RestController
@RequestMapping("/home/dashboard")
@CrossOrigin(origins = "*")
public class NotificationController {

    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping("/notifications")
    public List<NotificationModel> getNotifications() {
        List<NotificationModel> notifications = new ArrayList<>();

        List<CategoryModel> recentUploads = categoryRepo.findTop5ByOrderByCategoryIdDesc();

        for (CategoryModel category : recentUploads) {
            String title = category.getCategoryTitle(); // e.g., Smartphone

            String message =
                "Order #" + category.getCategoryId() + "\n" +
                "Item " + title + "\n" +
                "Brand: " + category.getBrand() + "\n" +
                "by " + category.getAuthor() + ".\n" +
                "Your wishlist item is on sale Today\n" +
                "New product in " + title + "! Yesterday";

            notifications.add(new NotificationModel(message, "Now"));
        }

        return notifications;
    }

}
