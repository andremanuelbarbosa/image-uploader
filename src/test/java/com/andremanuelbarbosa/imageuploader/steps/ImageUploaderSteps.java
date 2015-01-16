package com.andremanuelbarbosa.imageuploader.steps;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ImageUploaderSteps {

  private static final String BASE_URL = "http://localhost:8080/image-uploader";
  private static final String CHROME_DRIVER_VERSION = "2.13";

  static WebDriver webDriver = createChromeDriver();

  Scenario scenario;

  static {

    Runtime.getRuntime().addShutdownHook(new Thread() {

      @Override
      public void run() {

        if (webDriver != null) {

          webDriver.quit();
        }
      }
    });
  }

  private static WebDriver createChromeDriver() {

    String osName = System.getProperty("os.name").toLowerCase();
    String osArch = System.getProperty("os.arch");
    String osBits = osName.equals("linux") && osArch.endsWith("64") ? "64" : "32";

    String chromeDriverVersion = System.getProperty("chrome.driver.version") != null ? System
        .getProperty("chrome.driver.version") : CHROME_DRIVER_VERSION;

    String webDriverChromeDriver = "src/test/resources/selenium/drivers/chrome/" + chromeDriverVersion + "/" + osName
        + "/" + osBits + "/chromedriver";

    if (!new File(webDriverChromeDriver).canExecute()) {

      throw new IllegalStateException("The specified Chrome Driver cannot be found or cannot be executed : "
          + webDriverChromeDriver);
    }

    System.setProperty("webdriver.chrome.driver", webDriverChromeDriver);

    return new ChromeDriver();
  }

  void takeScreenshot() {

    scenario.write(webDriver.getCurrentUrl());
    scenario.embed(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES), "image/png");
  }

  void waitAndTakeScreenshot(int millis) throws InterruptedException {

    Thread.sleep(millis);

    takeScreenshot();
  }

  @Before
  public void setUp(Scenario scenario) {

    this.scenario = scenario;
  }

  @When("^the User navigates to \"(.*?)\"$")
  public void the_User_navigates_to(String url) throws Throwable {

    webDriver.get(BASE_URL + url);

    waitAndTakeScreenshot(10000);
  }

  private void assertComponentIsDisplayed(String componentId) {

    assertTrue(webDriver.findElement(By.id(componentId)).isDisplayed());
  }

  @Then("^the User should see the component with ID \"(.*?)\"$")
  public void the_User_should_see_the_component_with_ID(String componentId) throws Throwable {

    assertComponentIsDisplayed(componentId);
  }

  @Then("^the User should see all the components for the Image Panel with index \"(.*?)\"$")
  public void the_User_should_see_all_the_components_for_the_Image_Panel_with_index(String imageIndex) throws Throwable {

    assertComponentIsDisplayed("imageUploaderImagePanel" + imageIndex);
    assertComponentIsDisplayed("imageFile" + imageIndex);
    assertComponentIsDisplayed("imageCaption" + imageIndex);
    assertComponentIsDisplayed("imageAltTag" + imageIndex);
  }

  @When("^the User clicks on the component with ID \"(.*?)\"$")
  public void the_User_clicks_on_the_component_with_ID(String componentId) throws Throwable {

    WebElement webElement = webDriver.findElement(By.id(componentId));

    webElement.click();

    takeScreenshot();
  }

  @When("^the User selects the Image File \"(.*?)\" on the Image Panel with index \"(.*?)\"$")
  public void the_User_selects_the_Image_File_on_the_Image_Panel_with_index(String imageFile, String imageIndex)
      throws Throwable {

    WebElement webElementImageFile = webDriver.findElement(By.id("imageFile" + imageIndex)).findElement(
        By.xpath("//input[@type=\"file\"]"));

    webElementImageFile.sendKeys(new File("src/test/resources/images/" + imageFile).getAbsolutePath());

    waitAndTakeScreenshot(10000);
  }
}
