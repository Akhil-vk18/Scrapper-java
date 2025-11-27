package com.scraper.jobportal.jobportal_scraper;

import com.scraper.jobportal.jobportal_scraper.scraper.InfoparkScraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobportalScraperApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobportalScraperApplication.class, args);
        new InfoparkScraper().scrape();
	}
}
