package io.cucumber.skeleton;

import io.cucumber.java.en.Given;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.net.URL;


public class StepDefinitions {

    @Given("I execute a selenium test")
    public void iExecuteASeleniumTest() throws Exception{
        final String AUTOMATE_USERNAME = "pascal_rDhTa5";
        final String AUTOMATE_ACCESS_KEY = "xPxLNTLHpoUsz9uwBZst";
        final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "iPhone");
        caps.setCapability("device", "iPhone 11");
        caps.setCapability("realMobile", "true");
        caps.setCapability("os_version", "14.0");
        caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
        caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
        final WebDriver driver = new ChromeDriver();
//        final WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        try {
            driver.get("https://www.google.com");
            driver.findElement(By.xpath("//div[text()='Ik ga akkoord']")).click();
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");
            driver.findElement(By.xpath("//input[@name='q']")).submit();

//            Screenshot maken van zoekresultaten pagina
            System.out.println(caps.getBrowserName());
            File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String path = "./target/screenshots/Zoekresultaat_" + caps.getBrowserName() + ".png";
            FileUtils.copyFile(source, new File(path));
        } finally {
                driver.close();
        }
    }

}
