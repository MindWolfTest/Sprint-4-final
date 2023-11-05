package ru.praktikum;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BeforeAndAfterForAll
{
    protected WebDriver driver;
    @Before
    public void setUp()
    {
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);*/
        /*FirefoxProfile options = new FirefoxProfile();
        options.setPreference("browser.fullscreen.autohide",true);
        options.setPreference("browser.fullscreen.animateUp",0);*/
        //driver = new FirefoxDriver(options);
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();

    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
