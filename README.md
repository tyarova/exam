# exam
Exam task that need to be done for successful graduation from the QA Automation course. It contains best practices of usage OOP and PageObject/PageFactory patterns for Java/WebDriver/TestNG project.

# How to run tests:

1. Install JDK 1.8 or above corresponding to your OS
2. Install Maven command line utility corresponding to your OS
3. Make sure that following command line commands mvn -version and java -version give you information on mvn and java installed in your OS. Otherwise go back to #1 and #2 and google for proper installation guides.
4. Clone repository with source code via Git
5. In command line change directory (cd) to project root folder
6. To run test from command line use following command:
mvn clean install -DsuiteName=google_search_test_chrome.xml
where google_search_test_chrome.xml is a name of specific TestNG xml file with tests.
 
# Additional information

The tests are run on Chrome by default. There are 2 playlists have been created to run tests in different browsers.

#ToDo: please list the scenario that was automated, otherwise it's not fully clear what is the purpose of this project

