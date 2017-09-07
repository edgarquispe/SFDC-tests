# sfdc-tests

WHAT IS IT?
-----------

sfdc-tests project has as main objective to automate acceptance test cases of SalesForce web page using REST-Assured,
Selenium, TestNG and Cucumber technologies, and use other services like docker, BrowserStack and SauceLabs for automated
testing.

Additional technologies:

    -SonarQube.

FEATURES TESTED
---------------

The following main features are implemented in this framework.

Acceptance tests.

    -Login.
    -Account.
        -Create.
        -Edit, Delete.
    -Chatters.
        -Create.
        -Edit, Delete and Comment Post.
    -Opportunity.
        -Create.
        -Edit and Delete.
    -Products.
        -Create.
        -Edit And Delete.

REQUIREMENTS AND SET CONFIGURATIONS
-----------------------------------

The required configuration for this framework is the following:

    -IntelliJ idea IDE.
    -Download Gradle 3.5 or superior: https://gradle.org/gradle-download/
    -Clone/download the project from GitHub repository: https://github.com/AT-04/sfdc-tests.git

Once those requirements are done, follow these steps:

    -Open the project downloaded with the IntelliJ IDE.
    -Open the Gradle properties file e.g. gradle.properties file

Set the required parameters:

    *username= Is the user account name of SalesForce.
    *password= Is the Password of the user in SalesForce.
    *browser= Is the browser where the test are going to be executed, it could have 4 values: Firefox, Chrome,
    Browserstack or Saucelabs.
        In case to fill with Browserstack or Saucelabs to remote execution, the following variables should
        have a configured value:
        -remoteUserName= Is the username of Saucelabs or Browserstack.
        -remoteKey= Is the key provided by your account on Saucelabs or Browserstack.
        -remoteBrowser= Is the browser that you want to execute your test remotely. (e.g. Chrome)
        -remoteBrowserVersion= Is the version of the browser wrote before ^. (e.g. 54.0)
        -remotePlatform= Is the OS where you want to execute your test. (e.g. Windows)
        -remotePlatformVersion= Is the OS version. (e.g. 8.1)
        -remoteResolution= Is the resolution of the screen. (e.g. 1920x1080)
After executing those steps the frame should be executed.

To execute by command line you can use the following:

        ```javascript

        gradle clean check
        -Pusername= SalesForce username -Ppassword= SalesForce password
        -PremoteUserName= remoteUserName  -PremoteKey= remoteKey
        -Pbrowser= remoteBrowser(COULD BE REMOTE AS BROWSERSTACK OR SAUCELABS)
        -PremoteBrowser=remoteBrowser -PremoteBrowserVersion=remoteBrowserVersion - PdockerUrl= dockerUrl
        -PremotePlatformVersion=remotePlatformVersion -PremotePlatform=remotePlatform -PremoteResolution=remoteResolution

        ```
CONTACTS
--------

    -If you want to be informed about new code releases, bug fixes, security fixes, general news and information about
    pivotal-tests project check to the GitHub repository https://github.com/AT-04/sfdc-tests.git

CONTRIBUTORS
------------

Current contributors:

    -Juan Jose Torrez (JoseTorrez) - https://github.com/JoseTorrez
    -Marcos Lara (marcos-x86) - https://github.com/marcos-x86
    -Abel Barrientos (Sphinix27) - https://github.com/Sphinix27
    -Richard Severiche (RichardSeverich) - https://github.com/RichardSeverich
    -Sergio Navarro (GioSerden) - https://github.com/GioSerden
    -Ovidio Miranda (OvidioMiranda) - https://github.com/OvidioMiranda
    -Cynthia Terrazas  (CynthiaTerrazas) - https://github.com/CynthiaTerrazas
    -Yury Ortuño (yuryver) - https://github.com/yuryver
    -Carlos Gonzales (carledriss) - https://github.com/carledriss