# OrangeHRM – Hybrid Test Automation Framework (Selenium + TestNG)

A robust, scalable, hybrid automation framework designed for testing the OrangeHRM application.  
This framework follows industry-standard best practices, combining Page Object Model (POM),  
Selenium WebDriver, TestNG, data-driven testing, reporting utilities, and CI/CD readiness.
if test class > 500 < 1000 for that the framework i m building is sustainable because will be adding selenium grid with Docker
if test class > 1000 can be added kubernetes to manage the docker containerization running the regressin test will be fast 
when selenium grid will be implemented with docker while spining up the aws Ec2 instance .
---

## 🚀 Key Features

### 🔹 **Hybrid Framework Architecture**
- Modular design combining multiple automation approaches
- Clear separation of concerns using Page Object Model (POM)
- Scalable for UI + API (REST Assured integration coming soon)

### 🔹 **Selenium WebDriver**
- Web interaction layer built using a reusable `ActionDriver` class
- Handles:
  - Clicks, sendKeys
  - WebDriverWait / Explicit Waits
  - Dropdowns, Frames, Alerts
  - Mouse hover, Actions class integration
  - Also to achieve singleton design pattern creating action driver class in bases class using encapsulation geting that class and passing into pageObjects class constructor 

### 🔹 **TestNG Integration**
- Organized test suite structure
- Parallel execution support
- Data-driven testing using:
  - **Apache POI** (Excel-driven)
  - **TestNG DataProvider**
- Parameterization & Groups support

### 🔹 **Page Object Model (POM)**
- Dedicated page classes for:
  - Login Page
  - Home Page
  - Additional pages coming soon (Admin/User Management, etc.)
- Low maintenance, scalable design

### 🔹 **Base Class**
- WebDriver initialization
- ThreadLocal WebDriver support (parallel-ready)
- Configuration setup (Properties file)
- Test setup and teardown

### 🔹 **Utilities Layer**
- Extent Reports (customized reporting)
- Logger Manager (centralized logging)
- Screenshot Utility
- Config Reader
- Browser Factory (Chrome, Firefox, Edge)

---

## 📂 Project Structure

src
├── main
│ ├── java
│ │ ├── base/ # BaseClass & WebDriver setup
│ │ ├── actions/ # ActionDriver with reusable Selenium methods
│ │ ├── pages/ # Page Object classes
│ │ ├── utilities/ # Reports, Logging, Config, Screenshots
│ └── resources
│ └── config.properties # Application & environment configs
│
└── test
├── java
│ └── testcases/ # TestNG test cases (Login, HomePage, etc.)
└── resources
└── testdata/ # Excel files for data-driven testing


---

## 🧪 Test Execution

### **Run from TestNG**


testng.xml


### **Run via Command Line**


mvn clean test


### **Run Parallel Tests**
Configure `testng.xml` with parallel attributes  
(ThreadLocal WebDriver already supported)

---

## 📊 Reporting

- **Extent Reports** integrated  
- Automatic screenshot capture on failure  
- Logs generated for every test execution  
- Report available at:


/reports/extent-report.html


---

## 🔌 CI/CD Integration (Planned)

This framework is designed to integrate with:

- ✔ Jenkins freestyle & pipeline jobs  
- ✔ GitHub Actions (future)  
- ✔ Docker-based execution  
- ✔ Selenium Grid (local & distributed)

Upcoming features:
- Dockerfile
- docker-compose for Selenium Grid
- Headless execution

---

## 🌐 API Testing Integration (Coming Soon)

REST Assured will be integrated to support:

- GET/POST/PUT/DELETE  
- JSON schema validation  
- API + UI combined test flows

---

## 🎯 Target Application
**Application Under Test:**  
OrangeHRM – Open Source HR Management System  
https://www.orangehrm.com/

---

## 🛠 Technologies & Tools

| Layer             | Tools/Tech |
|-------------------|-----------|
| UI Automation     | Selenium WebDriver |
| Test Runner       | TestNG |
| Language          | Java |
| Build Tool        | Maven |
| Reporting         | Extent Reports |
| Logging           | Logger (Log4j / Custom) |
| Data-Driven       | Apache POI + DataProvider |
| CI/CD             | Jenkins (planned) |
| Grid Execution    | Selenium Grid + Docker (planned) |
| API Automation    | REST Assured (planned) |

---

## 📌 Current Status
- Login Page automation ✔  
- Home Page automation ✔  
- Page Objects, BaseClass, Actions ✔  
- Extent Reports + Logging ✔  
- Screenshot capture ✔  
- Properties file setup ✔  
- DataProvider + Apache POI setup (in progress)  
- More test cases coming…

---

## 🔮 Upcoming Enhancements
- Add API test layer  
- Add Selenium Grid + Docker setup  
- Add Jenkins pipeline file  
- Add Retry mechanism  
- Add custom annotations  
- Add dynamic waits  
- Add global exception handling

---

## 👨‍💻 Author
**Mohammed Masood**  
Senior QA Automation Engineer  
Specializing in Selenium, REST Assured, TestNG, Docker, CI/CD & Hybrid Framework Design

---
