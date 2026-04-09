# Job Portal Scraper - Java Implementation

A Spring Boot-based web scraper that extracts job listings from various job portals and stores them in a MySQL database. This is a **sub-project of a larger Job Portal application**, designed to continuously scrape and populate job data that the main job portal can fetch and display to users.

## 📋 Project Overview

The Job Portal Scraper is a Spring Boot application that automates the collection of job postings from job portals (currently focusing on Infopark). It scrapes job data, processes it, and stores it in a MySQL database where the main Job Portal application can access it for displaying job listings to end users.

### Key Features

- **Automated Job Scraping**: Automatically scrapes job listings from Infopark job portal
- **Database Storage**: Stores scraped job data in MySQL database using Spring Data JPA
- **Spring Boot Integration**: Built with Spring Boot for easy deployment and configuration
- **Job Portal Integration**: Designed as a backend service for the main Job Portal application
- **Structured Data Model**: Clean job data model with JPA entities for database persistence
- **Continuous Operation**: Runs as a CommandLineRunner on application startup

## 🚀 Current Implementation Status

### ✅ Implemented Components

- **Spring Boot Application**: Fully configured Spring Boot 4.0 application
- **Infopark Scraper**: Active scraper for Infopark job portal (https://infopark.in/companies/job-search)
- **Database Integration**: MySQL database connection with Spring Data JPA
- **Job Entity Model**: Complete job data model with fields:
  - Job title, company name, requirements, experience, location
  - Posted date, deadline, apply link
- **JPA Repository**: JobRepo interface for database operations
- **Auto-execution**: Scraper runs automatically on application startup using CommandLineRunner

### 📝 Job Portal Integration

This scraper serves as a **data collection service** for the main Job Portal application:
1. Scraper runs and collects job data from supported portals
2. Data is stored in the shared MySQL database (`jobportal` database)
3. Main Job Portal application fetches this data to display to users
4. Both applications connect to the same database for seamless data sharing

## 🛠️ Technology Stack

- **Language**: Java 21
- **Framework**: Spring Boot 4.0.0
- **Database**: MySQL 8.0+
- **ORM**: Spring Data JPA with Hibernate
- **HTML Parsing**: Jsoup 1.21.2
- **Build Tool**: Maven
- **Utilities**: Lombok for boilerplate code reduction

## 📦 Project Structure

```
Scrapper-java/
├── src/
│   ├── main/
│   │   ├── java/com/scraper/jobportal/jobportal_scraper/
│   │   │   ├── JobportalScraperApplication.java  # Main Spring Boot application
│   │   │   ├── model/
│   │   │   │   └── Jobs.java                      # JPA entity for job data
│   │   │   ├── repository/
│   │   │   │   └── JobRepo.java                   # JPA repository interface
│   │   │   └── scraper/
│   │   │       └── InfoparkScraper.java           # Infopark job portal scraper
│   │   └── resources/
│   │       └── application.properties             # Database and app configuration
│   └── test/
│       └── java/
│           └── JobportalScraperApplicationTests.java
├── pom.xml                                        # Maven dependencies and build config
└── README.md
```

## 🚀 Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6+
- MySQL 8.0+
- Git

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Akhil-vk18/Scrapper-java.git
   cd Scrapper-java
   ```

2. **Set up MySQL Database**
   ```sql
   CREATE DATABASE jobportal;
   ```

3. **Configure Database Connection**
   
   Update `src/main/resources/application.properties` with your MySQL credentials:
   ```properties
   spring.application.name=jobportal-scraper
   spring.datasource.url=jdbc:mysql://127.0.0.1:3306/jobportal
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   ```

4. **Build the project**
   ```bash
   mvn clean install
   ```

5. **Run the application**
   ```bash
   mvn spring-boot:run
   ```
   
   The scraper will automatically run on startup and populate the database with job data.

## 📊 Data Model

### Jobs Entity

The `Jobs` JPA entity stores scraped job information with the following fields:

- `id` (Integer): Auto-generated primary key
- `title` (String): Job title
- `companyname` (String): Company name
- `requirements` (String): Job requirements
- `experience` (String): Required experience
- `location` (String): Job location
- `postedDate` (LocalDate): Date when job was posted
- `deadline` (LocalDate): Application deadline
- `applylink` (String): URL to apply for the job

This data is stored in the `jobs` table in the MySQL database and can be accessed by the main Job Portal application.

## 🔄 How It Works

1. **Application Starts**: The Spring Boot application starts and initializes the `InfoparkScraper` component
2. **Scraper Executes**: The scraper connects to Infopark's job search page using Jsoup
3. **Data Extraction**: Job details are extracted from the HTML table structure
4. **Database Storage**: Each job is saved to the MySQL database via Spring Data JPA
5. **Job Portal Access**: The main Job Portal application queries this database to display jobs to users

## 🧪 Testing

Run tests using Maven:

```bash
mvn test
```

## 🔮 Future Enhancements

- Add more job portal scrapers (Naukri, LinkedIn, Indeed, etc.)
- Implement scheduling for periodic scraping (Spring @Scheduled)
- Add duplicate job detection
- Implement error notifications
- Add REST API endpoints for manual scraping triggers
- Enhance data validation and sanitization
- Add support for job categories and tags

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## ⚠️ Legal and Ethical Considerations

- Ensure you have permission to scrape target websites
- Respect the `robots.txt` file and website Terms of Service
- Implement appropriate delays between requests
- Use proper User-Agent headers
- Consider the website's server load and implement responsible scraping practices

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📞 Support

For issues, questions, or suggestions, please open an issue on the GitHub repository.

## 👤 Author

**Akhil VK**
- GitHub: [@Akhil-vk18](https://github.com/Akhil-vk18)

## 📚 Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Jsoup Documentation](https://jsoup.org/)
- [Spring Data JPA Documentation](https://spring.io/projects/spring-data-jpa)
- [MySQL Documentation](https://dev.mysql.com/doc/)

---

**Last Updated**: December 16, 2024

**Status**: 🟢 Active - Core functionality implemented

This scraper is a sub-project of the larger Job Portal application ecosystem. For the main Job Portal repository, please visit the parent project.
