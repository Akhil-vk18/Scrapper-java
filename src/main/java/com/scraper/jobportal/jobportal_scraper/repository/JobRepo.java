package com.scraper.jobportal.jobportal_scraper.repository;

import com.scraper.jobportal.jobportal_scraper.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobRepo extends JpaRepository<Jobs,Integer> {

}
