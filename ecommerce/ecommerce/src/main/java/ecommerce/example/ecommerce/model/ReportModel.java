package ecommerce.example.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "report_db")
public class ReportModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int today;
    private int week;
    private int month;

    private String name;
    private String brand;

    private int sold;
    private double revenue;

    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getToday() {
        return today;
    }
    public void setToday(int today) {
        this.today = today;
    }

    public int getWeek() {
        return week;
    }
    public void setWeek(int week) {
        this.week = week;
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSold() {
        return sold;
    }
    public void setSold(int sold) {
        this.sold = sold;
    }

    public double getRevenue() {
        return revenue;
    }
    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}
