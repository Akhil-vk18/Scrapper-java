package com.scraper.jobportal.jobportal_scraper.scraper;

import com.scraper.jobportal.jobportal_scraper.model.Jobs;
import com.scraper.jobportal.jobportal_scraper.repository.JobRepo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.SimpleTimeZoneAwareLocaleContext;
import org.springframework.stereotype.Component;

@Component

public class InfoparkScraper {
    private final String url = "https://infopark.in/companies/job-search";
    @Autowired
    private JobRepo jobrepo;

    public void scrape() {
        try {
            Document document = Jsoup.connect(url).get();
            Elements jobs = document.select("#job-list table tbody tr");
            for (Element jobrow : jobs) {
                Elements cols = jobrow.select("td");

                Jobs job = new Jobs();
//                job.setPostedDate(cols.get(0));
                job.setTitle(cols.get(1).text());
                job.setCompanyname(cols.get(2).text());
                job.setApplylink(cols.get(4).text());
                jobrepo.save(job);
//                String title = cols.get(1).text();
//                System.out.println(title);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
