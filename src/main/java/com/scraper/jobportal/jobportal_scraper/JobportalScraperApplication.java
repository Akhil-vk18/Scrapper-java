package com.scraper.jobportal.jobportal_scraper;

import com.scraper.jobportal.jobportal_scraper.scraper.InfoparkScraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobportalScraperApplication implements CommandLineRunner {
    @Autowired
    private    InfoparkScraper infoparkScraper;

    public static void main(String[] args) {
		SpringApplication.run(JobportalScraperApplication.class, args);
//        new InfoparkScraper().scrape();
    }

    @Override
    public void run(String... args) throws Exception {
        infoparkScraper.scrape();
    }
}
