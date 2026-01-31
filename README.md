Selenium Grid + TestNG + Jenkins Automation Framework

This project demonstrates a real-world Selenium automation framework with cross-browser and parallel execution using Selenium Grid, TestNG, Maven, and Jenkins CI.

Tech Stack

Java 11

Selenium 4

TestNG

Cucumber

Maven

Selenium Grid

Jenkins

GitHub

Key Features

Cross-browser execution (Chrome, Edge, Firefox)

Parallel execution using TestNG and Jenkins Pipeline

Selenium Grid based execution using RemoteWebDriver

Thread-safe WebDriver management using ThreadLocal

Maven profiles for browser selection

CI-ready Jenkins pipeline

Cucumber BDD framework with TestNG runner

Project Structure
src
 └── test
     ├── java
     │   ├── factory        (DriverFactory)
     │   ├── hooks          (Cucumber Hooks)
     │   ├── runners        (TestNG Runner)
     │   ├── stepdefinitions
     │   └── utils
     └── resources
         ├── features
         └── config

Driver Strategy

Local Execution

Uses WebDriverManager

Grid Execution

Uses RemoteWebDriver

Controlled via grid.enabled=true

Configuration

config.properties

browser=chrome
grid.enabled=true
grid.url=http://<GRID-IP>:4444/wd/hub
app.url=https://demo.guru99.com/V4/

Maven Profiles
-Pchrome
-Pedge
-Pfirefox

Run Tests Locally
mvn clean test -Pchrome

mvn clean test -Pedge

Run Tests on Selenium Grid
mvn clean test -Pchrome -Dgrid.enabled=true

mvn clean test -Pedge -Dgrid.enabled=true

Jenkins Integration

Jenkins Freestyle and Pipeline jobs supported

Parallel execution using Jenkins Pipeline

Chrome and Edge executed in parallel

Grid-based execution avoids local browser dependency

Jenkins Pipeline (Parallel Browsers)
parallel {
    stage('Chrome') {
        steps {
            bat 'mvn clean test -Pchrome -Dgrid.enabled=true'
        }
    }
    stage('Edge') {
        steps {
            bat 'mvn clean test -Pedge -Dgrid.enabled=true'
        }
    }
}

Execution Highlights

Chrome and Edge run simultaneously

Stable execution in CI

No driver conflicts

Scalable and production-ready design

Author

Shilpa Chinnagowni
QA Automation Engineer