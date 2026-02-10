## Opencart Automation Framework

A Selenium-based automation framework for the OpenCart demo application, built using Java, TestNG, and Page Object Model (POM).  
Designed to support data-driven testing, CI/CD execution, and parallel cross-browser testing using Selenium Grid and Docker.

### Skills Demonstrated
- Selenium WebDriver (Java)
- Page Object Model (POM)
- TestNG & Maven
- Data-Driven Testing (Excel, Properties)
- Jenkins CI/CD Integration
- Docker & Selenium Grid (Parallel Execution)
- Extent Reports & Log4j2

### Key Features
- Hybrid automation framework with POM design
- Data-driven testing using Apache POI (Excel)
- Parallel execution on Chrome, Firefox, and Edge
- Dockerized Selenium Grid 4 for distributed execution
- Jenkins-based CI pipeline
- Extent Reports with screenshots and Log4j2 logging

### Framework Structure
- pageObjects – Page locators and actions
- testCases – TestNG test classes and validations
- testBase – WebDriver setup and common utilities
- utilities – Excel handling, reporting, screenshots

### How to Run

#### Prerequisites
- Java 11+
- Maven
- Docker Desktop

#### Start Selenium Grid
```bash
docker-compose up -d
mvn test

docker-compose down
