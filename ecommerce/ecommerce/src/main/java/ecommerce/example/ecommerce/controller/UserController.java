package ecommerce.example.ecommerce.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ecommerce.example.ecommerce.model.UserModel;
import ecommerce.example.ecommerce.repo.UserRepo;
import ecommerce.example.ecommerce.service.UserService;

@RestController
@RequestMapping("/createu/v2")
@CrossOrigin
public class UserController {

    private static final String UPLOAD_DIR = "D:/sts project/ecommerce/vender_image/";

    @Autowired
    private UserService userviceobj;

    @Autowired
    private UserRepo userrepo;

    @PostMapping("/user")
    public ResponseEntity<UserModel> createUserWithImage(
            @RequestParam("userName") String userName,
            @RequestParam("userEmail") String userEmail,
            @RequestParam("userAddress") String userAddress,
            @RequestParam("userPassword") String userPassword,
            @RequestParam("userPhone") String userPhone,
            @RequestParam(value = "userPic", required = false) MultipartFile userPic) {

        try {
            String filePathInDB = null;

            if (userPic != null && !userPic.isEmpty()) {
                File dir = new File(UPLOAD_DIR);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                String originalFilename = userPic.getOriginalFilename();
                String newFilename = System.currentTimeMillis() + "_" + originalFilename;
                String fullPath = UPLOAD_DIR + newFilename;

                FileOutputStream fos = new FileOutputStream(fullPath);
                fos.write(userPic.getBytes());
                fos.close();

                filePathInDB = "/vender_image/" + newFilename;
            }

            UserModel user = new UserModel(userName, userEmail, userPassword, userPhone, filePathInDB, userAddress);
            UserModel savedUser = userviceobj.CreateUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserModel> getUserData(@PathVariable int userId) {
        try {
            UserModel user = userviceobj.getDataByIdU(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/mobile/{mobile}")
    public ResponseEntity<UserModel> getUserByMobile(@PathVariable String mobile) {
        UserModel user = userrepo.findByUserPhone(mobile);
        if (user != null)
            return new ResponseEntity<>(user, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserModel> updateUserPassword(
            @PathVariable int userId,
            @RequestBody Map<String, String> body) {

        String newPassword = body.get("userPassword");
        Optional<UserModel> optionalUser = userviceobj.updatePassword(userId, newPassword);

        return optionalUser
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/updateByMobile/{mobile}")
    public ResponseEntity<UserModel> updatePasswordByMobile(
            @PathVariable String mobile,
            @RequestBody Map<String, String> body) {

        String newPassword = body.get("userPassword");

        UserModel user = userrepo.findByUserPhone(mobile.trim());
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        user.setUserPassword(newPassword);
        UserModel savedUser = userrepo.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    // changed
    @PutMapping("/changePassword/{mobile}")
    public ResponseEntity<String> changePasswordWithOldCheck(
            @PathVariable String mobile,
            @RequestBody Map<String, String> body) {

        String oldPassword = body.get("oldPassword");
        String newPassword = body.get("newPassword");

        UserModel user = userrepo.findByUserPhone(mobile.trim());

        if (user == null) {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }

        if (user.getUserPassword() == null || !user.getUserPassword().equals(oldPassword)) {
            return new ResponseEntity<>("Old password is incorrect or not set.", HttpStatus.BAD_REQUEST);
        }

        user.setUserPassword(newPassword);
        userrepo.save(user);

        return new ResponseEntity<>("Password updated successfully.", HttpStatus.OK);
    }
}
