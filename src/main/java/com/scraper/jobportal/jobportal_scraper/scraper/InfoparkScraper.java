package com.scraper.jobportal.jobportal_scraper.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.text.DefaultStyledDocument;

public class InfoparkScraper {
    private String url = "https://infopark.in/companies/job-search";

    public void scrape() {
        try {
            Document document = Jsoup.connect(url).get();
            Elements jobs = document.select("#job-list table tbody tr");
            for (Element jobrow : jobs) {
                Elements cols = jobrow.select("td");
                String title = cols.get(1).text();
                System.out.println(title);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
