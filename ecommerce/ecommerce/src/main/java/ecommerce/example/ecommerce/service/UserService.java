package ecommerce.example.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.example.ecommerce.model.UserModel;
import ecommerce.example.ecommerce.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userrepo;

    public UserModel CreateUser(UserModel umodel) {
        return userrepo.save(umodel);
    }

    public UserModel getDataByIdU(int userId) {
        return userrepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }

    public UserRepo getRepo() {
        return userrepo;
    }

    public Optional<UserModel> updatePassword(int userId, String newPassword) {
        Optional<UserModel> userOpt = userrepo.findById(userId);

        if (userOpt.isPresent()) {
            UserModel user = userOpt.get();
            user.setUserPassword(newPassword);
            UserModel updatedUser = userrepo.save(user);
            System.out.println("✅ Password updated for user ID " + userId);
            return Optional.of(updatedUser);
        } else {
            System.out.println("❌ User not found with ID: " + userId);
            return Optional.empty();
        }
    }
}
