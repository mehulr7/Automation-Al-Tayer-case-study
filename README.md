# Automation-Al-Tayer-case-study
Case study


This repository contains the case study

Case 1 case 1.2 Case 2 Case 2.2

To run the script I have created Run.bat file. Just double click on it. Test will run automatically. All the dependencies are added into the pom.xml file.

Last code was not easy to understand and readable so i have written the scripts from scratch using maven and cucumber(BDD). It is much easier to understand as compared to TDD. In this way the code is easy to manage. Anyone stakeholders/users can read the code easily as its methods name shows its flow.

I have given meaningful variable names. Anyone can understand what type of value is contained in the variable.

Yes I checked whole the scenario written in one function. But I have created one Action class where most of the actions are stored, Just used these function in frontend. I have separated all function and created 4 classes for each scenario. In Common class I have written reusable code and used it.

I have created two configuration files to store the locators (Page objects) by its name. In case in the future any locator will change then You just need to update it in that file not in the code.

I have added TestNG assertion in code to verify the functionality.

Note1: I have also added logs using extent report. You can see the logs(Steps) of the scenarios in Logs folder Note: I have also added a results folder you can see the execution result in the graphical html report. Thanks to Anish Aroora - He has a Github page and a really useful reusable tool to report!

If you want to alter the project. Import the project in eclipse or an IDE. Right click on project >> Go to maven >> Click on Update project >> Then right click on project >> Go to run and click on run with maven install.

Thanks!

Instructions
1 \src\test\java

1.1 >> actions Folder

Case1Action class >> In this class I have created all actions for case 1 like click, Enter etc and these actions are calling on Case 1 Scenario. I have only created for case 1. In case 2 I have directly written the code in Case 2 Scenario java file as it will create confusion for anyone  who is not familiar with cucumber.
Common class >> This is common class in which i created functions that will use repeatedly in the whole project like launch and exit browser, 
                URL, getvalue from config file. These are the reusable functions.

1.2 pageObject Folder

Case1PO >> In this all the locators are stored in variables which is used for case 1 all scenarios. In future if any locator changes then you just need to change the locator as each locator is given a variable name so no need to update locator in code. It will automatically fetch by locator variable name.
Case2PO >> In this all the locators are stored in variables which is used for case 2 all scenarios. In future if any locator changes then you just need to change the locator as each locator is given a variable name so no need to update locator in code. It will automatically fetch by locator variable name.
It's easy to manage the locators in separate files.

1.3 Step Definition
This is the main folder for scripts
stepDefinition >> Test execution starts from this file. This is working with cucumber option. Here we are giving the path of the feature file. Here we need to give the tags which automatically detect the feature file scenario (You can see in feature file). Here we can also use TestNG annotation to run the execution in symetric way.

Case 1 Scenario >> In this class test script is written for Case 1.1
Case 1.2 Scenario >> In this class test script is written for Case 1.2
Case2_1Scenario >> In this class test script is written for Case 2.1
Case2_2Scenario >> In this class test script is written for Case 2.2

2. \src\test\resources
2.1 configuration
Config.properties >> In this file all inputs are stored. Here you can change values except all URLS as if URL will change then test will fail.
2.2 feature
In this all the feature files are stored in which steps are mentioned as per the requirement. There should not be any change in feature file as it will affect the test cases. We are using gherkin here so if any mismatch between scenario exists and also within the feature file then it will not run. In all feature files we give tag name that will be used in stepDefinition class to map the feature file with scenario to be executed. Tag name should not be mismatch at both files (feature and stepDefinition)

3. Driver Folder  In this folder we store chromedriver that will help us to launch the chrome browser. In Common class you can see we give the path of that chromedriver. There is also other drivers for IE, Safari, Firefox etc but for now script is written for only chrome browser.
4. Logs Folder  After completing the execution a file will updated in this folder and you can check the logs(Steps) for all script execution.
5. Results  After completing the execution a file will be created in this folder and you can check the execution status like how many test cases pass, Fail and error maybe due to out of stock issues or discontinuation of stock as a potential edge test case. 
6.  target   These files are generated at run time (No Need )
7. test-output   Here a file is also generated during execution and also provides a TestNG report. There is no need as we are using Cucumber+Extent report.
8. pom.xml  In this file we give all dependencies/library. It automatically fetches dependencies from internet. We can also call it dynamic dependencies.
9. Run.bat  This is a shortcut file to execute the tests. In this file there is the written command to run the maven. If the project is imported in eclipse IDE then you can also run it by run button or any other IDE.
10. testing.xml  In this file we give the class name which is needed to execute. In this project the stepDefinition file is the main class where all the test cases are executed by given tag name. So here we only mention this class.


