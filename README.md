# image-uploader
Image Uploader is a simple application written using Vaadin which uploads images to a server with some additional parameters like Caption and Alternative Text.

To run this application you can execute the following command:

mvn clean install -DskipTests=true tomcat7:run

To compile and see the full Cucumber Acceptance Tests you can just execute the following command:

mvn clean install

You might have to pass the version of the Chrome Driver which is compatible with the current machines using the parameter "chrome.driver.version" so that for example:

mvn clean install -Dchrome.driver.version=2.09

tells the build to use the ChromeDriver version 2.09 instead of the default 2.13, the latest.