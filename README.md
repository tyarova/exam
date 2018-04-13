# exam
Exam task that need to be done for successful graduation from the QA Automation course.

The project has been created to verify simple search on google.com Web page.

# How to run tests from this project:

1. Install JDK 1.8 or above corresponding to your OS
2. Install Maven command line utility corresponding to your OS
3. Make sure that following command line commands mvn -version and java -version give you information on mvn and java 
installed in your OS. Otherwise go back to #1 and #2 and google for proper installation guides.
4.Clone repository with source code via Git
5. In command line change directory (cd) to project root folder
6. To run test from command line use following command: mvn clean install -DsuiteName=google_search_test_chrome.xml 
where google_search_test_chrome.xml is a name of specific TestNG xml file with tests.

# Additional information

The project contains best practices of usage OOP and PageObject/PageFactory patterns. It consists of:
- page package, which contains pages with described methods to use in the tests
- test package, which contains test, to verify Google search 
- google_search_test_chrome.xml file - playlist with tests to run in chrome browser
- google_search_test_firefox.xml file - playlist with tests to run in firefox browser
