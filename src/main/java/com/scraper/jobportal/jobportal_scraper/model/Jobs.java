package com.scraper.jobportal.jobportal_scraper.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter //generate the getter method
@Setter //generate the setter
@ToString // generate the tostring method
@Entity(name = "jobs")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String companyname;
    private String requirements;
    private String experience;
    private String location;
    private LocalDate postedDate;
    private LocalDate deadline;
    private String applylink;
}
