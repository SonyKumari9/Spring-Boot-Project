package ecommerce.example.ecommerce.service;

import java.util.List;
import ecommerce.example.ecommerce.model.HomeModel;

public interface HomeService {
    List<HomeModel> searchByName(String name);
    List<HomeModel> searchByNameAndCategory(String name, String category);
}
