package ecommerce.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import ecommerce.example.ecommerce.model.ReportModel;
import ecommerce.example.ecommerce.repo.ReportRepo;

@Service
public class ReportService {

    @Autowired
    private ReportRepo reportrepo;

    public Optional<ReportModel> getReportById(int id) {
        return reportrepo.findById(id);
    }

    public List<ReportModel> getAllReports() {
        return reportrepo.findAll();
    }
}
