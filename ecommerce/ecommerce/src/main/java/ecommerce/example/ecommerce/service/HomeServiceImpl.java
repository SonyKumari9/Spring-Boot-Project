package ecommerce.example.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.example.ecommerce.model.HomeModel;
import ecommerce.example.ecommerce.repo.HomeRepo;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepo homeRepo;

    @Override
    public List<HomeModel> searchByName(String name) {
       
        return homeRepo.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<HomeModel> searchByNameAndCategory(String name, String category) {
        
        return homeRepo.findByNameContainingIgnoreCase(name).stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }
}
