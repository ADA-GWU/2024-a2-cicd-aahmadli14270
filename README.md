<h3>Description:</h3>
This project aims to demonstrate a basic setup for continuous integration and delivery (CI/CD) using a YAML configuration file. The configuration file (.yml) included in this repository defines the workflow for automating the build, test, and deployment processes for the project.

<h3>Configuration File:</h3>
main.yml: This YAML file contains the configuration for the CI/CD pipeline. It defines the steps to build the application, run unit tests, interface tests, and functionality tests, and deploy the application to the specified environment.

<h3>Updates:</h3>
*** Two new test cases have been added to the UnitTests.<br>
*** One new test case has been added to the webInterfaceTests.<br>
*** One new test case has been added to the FunctionalityTests.<br>

<h3>Usage:</h3>
*** Ensure that you have access to a CI/CD platform that supports YAML configuration file such as GitHub Actions.<br>
*** Copy the contents of the main.yml file into your project repository.<br>
*** Commit and push the changes to your repository to trigger the CI/CD pipeline. (Note: pull requests are another option to trigger CI/CD pipeline. ) <br>

<h3>SPECIAL NOTES:</h3>
*** I have not changed any source code during the assigment in feature context. I have only added 4 new test cases on existing project.  <br>
*** I have not used your config.yml file for CI/CD pipeline. I wrote my own one which is more understandable (for me). It builds, then checks test cases in different file paths. I haven't use "mvn test" to run all files is Test directory because it was hard for me to see at which stage tests fail (not easy to debug for me). I seperated all tests and run them in different stages, so that I could see easily that at what stage it fails.
