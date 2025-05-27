# qa-automation-tech-challenge

This project is an automated test suite built with Selenium WebDriver, Java, and Cucumber, designed to validate chatbot functionalities through UI interaction.

📁 Project Structure

├── ...
├── src
│ └── test
│ └── java
│ ├── pages # Page Object Model classes
│ ├── runner # Test runners using Cucumber
│ └── steps # Step definitions for Cucumber
│
└── resources
└── features # Feature files written in Gherkin

🚀 How to Run the Automation

1. Register a valid user in the application under test.

2. Go to src/test/java/steps/ChatbotSteps.java.

3. src\test\java\steps\ChatbotStesps.java Replace the login credentials in the login method:

Ejm
login.fillUsernameInput("usuarioPrueba.com");
login.fillPasswordInput("test123");

4. Ensure that a chatbot named "ZapBot" has been created in the application. This is the bot used for intent testing.

✅ Tools Used
Selenium WebDriver

- Java

- TestNG

- Cucumber

- Maven/Gradle (según tu proyecto)
