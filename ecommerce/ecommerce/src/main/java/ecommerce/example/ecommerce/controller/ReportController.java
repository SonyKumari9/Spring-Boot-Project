package ecommerce.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ecommerce.example.ecommerce.model.ReportModel;
import ecommerce.example.ecommerce.service.ReportService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("commerce/report")
@CrossOrigin
public class ReportController {

    @Autowired
    private ReportService reportservice;

    @GetMapping("/{id}")
    public ResponseEntity<ReportModel> getReportById(@PathVariable int id) {
        Optional<ReportModel> report = reportservice.getReportById(id);
        if (report.isPresent()) {
            return ResponseEntity.ok(report.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @GetMapping("/all")
    public ResponseEntity<List<ReportModel>> getAllReports() {
        return ResponseEntity.ok(reportservice.getAllReports());
    }
}
