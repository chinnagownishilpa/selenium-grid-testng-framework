Selenium Grid TestNG Automation Framework
A real-world Selenium automation framework built using Java, Selenium 4, TestNG, Cucumber, Maven, with support for Selenium Grid, parallel execution, and Jenkins CI.

Tech Stack:
- Java 11
- Selenium 4
- TestNG
- Cucumber
- Maven
- Selenium Grid
- Jenkins


📂 Project Structure 
├── src
│   ├── main
│   │   └── java
│   │       ├── factory
│   │       │   └── DriverFactory.java
│   │       ├── pages
│   │       │   ├── LoginPage.java
│   │       │   └── ManagerHomePage.java
│   │       └── utils
│   │           ├── AlertUtil.java
│   │           ├── ConfigReader.java
│   │           ├── ExtentReportManager.java
│   │           └── ScreenshotUtil.java
│   │
│   └── test
│       ├── java
│       │   ├── hooks
│       │   │   └── Hooks.java
│       │   ├── runners
│       │   │   └── TestRunner.java
│       │   └── stepdefinitions
│       │       ├── Guru99LoginSteps.java
│       │       └── ManagerHomeSteps.java
│       │
│       └── resources
│           ├── config
│           │   └── config.properties
│           └── features
│               ├── Guru99Login.feature
│               └── ManagerAccess.feature
│
├── pom.xml
├── README.md
├── target
└── test-output

⚙️ Default Configuration:
By default, the framework runs locally on Chrome.

config.properties:
browser=chrome
grid.enabled=false
grid.url=http://localhost:4444/wd/hub

No Grid or browser parameters are required for a basic run.

▶️ Run Tests Locally
Run with default settings (Chrome, Local)
mvn clean test

🌐 Run with Selenium Grid
Start Selenium Grid (example using standalone)
java -jar selenium-server-4.x.x.jar standalone

Ensure Grid is running at: http://localhost:4444

Run on Grid with Chrome:
mvn clean test -Pchrome -Dgrid.enabled=true

Run on Grid with Edge:
mvn clean test -Pedge -Dgrid.enabled=true

ℹ️ Important
Edge is not the default browser.
It must be passed explicitly using the Maven profile -Pedge.

🔁 Parallel Execution
Parallel execution is enabled using:
TestNG DataProvider(parallel = true)
Thread-safe ThreadLocal<WebDriver>
Selenium Grid for cross-browser concurrency

This allows:
Multiple scenarios
Multiple browsers
Parallel execution without session conflicts

🧪 Test Runner Configuration
TestRunner.java
@DataProvider(parallel = true)
public Object[][] scenarios() {
    return super.scenarios();
}

🔄 Jenkins CI Configuration
Jenkins executes Chrome and Edge in parallel using separate Maven profiles.

Sample Jenkins Pipeline
pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/chinnagownishilpa/selenium-grid-testng-framework.git'
            }
        }

        stage('Parallel Browser Execution') {
            parallel {
                stage('Chrome Tests') {
                    steps {
                        bat 'mvn clean test -Pchrome -Dgrid.enabled=true'
                    }
                }
                stage('Edge Tests') {
                    steps {
                        bat 'mvn clean test -Pedge -Dgrid.enabled=true'
                    }
                }
            }
        }
    }
}

✅ Key Highlights

Supports local and Grid execution
Chrome is default, Edge must be passed explicitly
Thread-safe WebDriver using ThreadLocal
Parallel execution at scenario level
CI-ready with Jenkins

📌 Notes
All configuration is externalized
System properties override config.properties
Same commands work locally and in Jenkins

📎 GitHub Repository
https://github.com/chinnagownishilpa/selenium-grid-testng-framework

Author
Shilpa Chinnagowni 
QA Automation Engineer