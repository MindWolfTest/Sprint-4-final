package ru.praktikum;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BeforeAndAfterForAll
{
    protected WebDriver driver;
    @Before
    public void setUp()
    {
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);*/
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
