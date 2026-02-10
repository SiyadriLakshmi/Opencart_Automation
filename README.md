Opencart Advanced Automation Framework

Project Overview
This is a professional-grade Test Automation Framework for the Opencart Demo Application. It follows the Page Object Model (POM) design pattern to ensure high maintainability and is optimized for Distributed Testing using containerized infrastructure.

🛠 Tech Stack
Language: Java

Automation: Selenium WebDriver

Infrastructure: Selenium Grid 4 & Docker Compose

Test Framework: TestNG

Build Tool: Maven

Logging: Log4j2

Data Management: Apache POI (Excel) & Properties files

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