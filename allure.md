# Allure Framework 

It is a flexible lightweight multi-language test report tool with the possibility to add screenshots, logs and so on. 

It provides modular architecture and neat web reports with the ability to store attachments, steps, parameters and many more.

### To generate Allure report, use commands:

```
mvn clean test
```
```
mvn allure:serve
```
Report will be generated into temp folder. 
Web server with results will start.

### To see report in 'target/site/allure-maven-plugin/index.html', use:
```
mvn allure:report
```
Test cases are shown on "Suites" tab. Test details can be reached via clicking on corresponded test row.