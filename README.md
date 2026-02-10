🛒 Opencart Advanced Automation Framework
A professional-grade, high-performance Test Automation Framework for the Opencart Demo Application. This project demonstrates the implementation of a scalable Hybrid Framework designed for distributed execution and continuous integration.

🌟 Key Features
Design Pattern: Page Object Model (POM) for enhanced maintainability.

Data-Driven Testing: Externalized test data using Apache POI (Excel) and Properties files.

Infrastructure: Distributed testing via Selenium Grid 4 orchestrated by Docker Compose.

CI/CD Integration: Fully automated pipeline using Jenkins.

Parallel Execution: Cross-browser testing (Chrome/Firefox/Edge) using TestNG parameters.

Robust Reporting: Interactive Extent Reports with failure screenshots and Log4j2 logging.

🛠 Tech Stack
Language: Java

Automation: Selenium WebDriver

Infrastructure: Selenium Grid 4 & Docker Compose

Test Framework: TestNG

Build Tool: Maven

Logging: Log4j2

Data Management: Apache POI (Excel) & Properties files

🏗 Framework Architecture:
The framework is structured to separate concerns, making it resilient to UI changes:

pageObjects: Contains locators and action methods for every page.

testCases: Contains functional validation and TestNG assertions.

testBase: Handles driver initialization, browser setup, and common utilities.

Utilities: Manages Excel data reading, reporting, and screenshots.

🏗 Infrastructure: Selenium Grid & Docker
The framework is engineered to run in a containerized environment to ensure browser consistency and enable parallel execution:

Docker Compose: Orchestrates a Selenium Hub and browser nodes (Chrome/Firefox) for environment-agnostic testing.

Grid 4 Integration: Centralized management of test execution across multiple nodes, reducing total test cycle time.

📊 Framework Features & Logic
Dynamic Data Generation: Uses randomstring() and randomnum() utilities to create unique user credentials for every registration run, avoiding data conflicts on the demo site.

Hybrid Data-Driven Approach: Leverages Apache POI for large-scale external Excel data and Properties files for environment configurations.

Intelligent Validation Logic: Implements sophisticated flows, such as automated logout only upon successful login to prevent session leakage during data-driven iterations.

Negative & Edge Case Coverage: Specialized validation for empty searches and invalid keywords, asserting for correct "No product matches" UI error messages.

Resilient Execution: Every test utilizes try-catch blocks and Assert.fail() to ensure the suite continues and failures are logged accurately via Log4j.


1. Setup Infrastructure

Gemini said
Here is the comprehensive, professional README.md for your GitHub repository. It consolidates everything you've built: the Page Object Model, Data-Driven Testing, Dockerized Selenium Grid, and your Jenkins CI/CD integration.

🛒 Opencart Advanced Automation Framework
A professional-grade, high-performance Test Automation Framework for the Opencart Demo Application. This project demonstrates the implementation of a scalable Hybrid Framework designed for distributed execution and continuous integration.

🌟 Key Features
Design Pattern: Page Object Model (POM) for enhanced maintainability.

Data-Driven Testing: Externalized test data using Apache POI (Excel) and Properties files.

Infrastructure: Distributed testing via Selenium Grid 4 orchestrated by Docker Compose.

CI/CD Integration: Fully automated pipeline using Jenkins.

Parallel Execution: Cross-browser testing (Chrome/Firefox/Edge) using TestNG parameters.

Robust Reporting: Interactive Extent Reports with failure screenshots and Log4j2 logging.

🛠 Tech Stack
Component	Technology
Language	Java 11
Automation	Selenium WebDriver
Test Management	TestNG
Build Tool	Maven
CI/CD	Jenkins
Containerization	Docker & Docker Compose
Reporting	Extent Reports
🏗 Framework Architecture
The framework is structured to separate concerns, making it resilient to UI changes:

pageObjects: Contains locators and action methods for every page.

testCases: Contains functional validation and TestNG assertions.

testBase: Handles driver initialization, browser setup, and common utilities.

Utilities: Manages Excel data reading, reporting, and screenshots.

🐳 Infrastructure & Scalability
This framework is "Cloud-Ready." It uses Docker to eliminate environment-related issues and supports scaling browser nodes dynamically.

Selenium Grid with Docker
The docker-compose.yaml file spins up:

Selenium Hub: Central management point.

Chrome & Firefox Nodes: For parallel cross-browser execution.

🚀 Jenkins CI/CD Pipeline
The project is integrated with Jenkins to provide a complete automation lifecycle:

Trigger: Code push to GitHub.

Environment: Jenkins pulls the image and starts the Dockerized Selenium Grid.

Execution: Runs mvn test which triggers the master.xml suite.

Reporting: Extent Reports are archived and failures are logged in the Jenkins console.

📊 How to Run
Prerequisites
JDK 11+

Maven 3.x

Docker Desktop
Ensure Docker is running, navigate to the project root, and start the Selenium Grid:


docker-compose up -d
2. Execute Tests
Run the full suite via Maven:


mvn test
Or right-click master.xml in Eclipse and select Run As > TestNG Suite.

3. Teardown
Stop the containers and clean the environment:

Bash
docker-compose down

📈 Reporting & Logs
Extent Reports: Found in the /reports/ folder after execution. These provide a visual dashboard of pass/fail status.

Logs: Found in /logs/, generated by Log4j2 to track internal test flow and debugging information.