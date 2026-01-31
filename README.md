\# Selenium Grid Automation Framework (TestNG + Cucumber)



This project is a real-world Selenium automation framework built to demonstrate:

\- Cross-browser execution

\- Parallel execution

\- Selenium Grid integration

\- CI readiness with Jenkins



---



\## 🔧 Tech Stack



\- Java 11

\- Selenium 4

\- TestNG

\- Cucumber (BDD)

\- Maven

\- Selenium Grid (Standalone / Distributed)

\- Jenkins (CI)



---



\## 📁 Framework Architecture



```text

src

&nbsp;├── main

&nbsp;│    └── java

&nbsp;│         ├── factory        → DriverFactory (Local + Grid)

&nbsp;│         ├── pages          → Page Object Model

&nbsp;│         └── utils          → Config, Waits, Helpers

&nbsp;│

&nbsp;├── test

&nbsp;│    ├── java

&nbsp;│    │     ├── runners       → TestNG Cucumber Runner

&nbsp;│    │     ├── stepdefinitions

&nbsp;│    │     └── hooks

&nbsp;│    │

&nbsp;│    └── resources

&nbsp;│          ├── features      → Cucumber feature files

&nbsp;│          └── config        → config.properties





🌐 Selenium Grid Support



The framework supports execution on:



Local browsers



Selenium Grid (RemoteWebDriver)



Configuration is controlled via:



config.properties



Maven profiles



Example:



grid.enabled=true

grid.url=http://<GRID-IP>:4444/wd/hub

browser=chrome



🚀 Execution Modes

1️⃣ Local Execution

mvn clean test



2️⃣ Cross-Browser Execution

mvn clean test -Pchrome

mvn clean test -Pfirefox

mvn clean test -Pedge



3️⃣ Parallel Execution



Enabled via TestNG + Maven Surefire



Thread-safe driver management using ThreadLocal



🔁 Jenkins Ready



This project is designed to run directly from Jenkins:



Source Code: GitHub



Build Tool: Maven



Supports Grid-based execution from CI



📌 Key Highlights



Thread-safe WebDriver handling



Clean Page Object Model



Environment-driven execution



Grid + Parallel execution ready



CI-friendly design



👩‍💻 Author



Shilpa

QA Automation Engineer

7+ years experience in Manual + Automation Testing

