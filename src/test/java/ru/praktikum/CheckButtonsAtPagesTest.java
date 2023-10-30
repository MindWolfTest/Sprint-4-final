package ru.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.pageobject.CheckButtonsAtPages;


public class CheckButtonsAtPagesTest
{
    private WebDriver driver;

    /*public CheckButtonsAtPagesTest()
    {
    }*/

    @Before
    public void setUp()
    {
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);*/
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
    }

    @Test
    public void checkFooterButtonOrderFromHomePage ()
    {
        CheckButtonsAtPages objCheckButtonInFooter = new CheckButtonsAtPages(driver);

        objCheckButtonInFooter
                .openHomePage()
                .enterToOrderPageFromFooter()
                .checkOpenFirstPageOrderFromFooterButton();
    }

    @Test
    public void checkButtonYandexFromHomePage()
    {
        CheckButtonsAtPages objCheckYandexLogoFromHomePage = new CheckButtonsAtPages(driver);
        objCheckYandexLogoFromHomePage
                .openHomePage()
                .clickAtButtonYandex()
                .switchToWindow()
                .checkDZEN();
    }


    @Test
    public void checkButtonScooterFromHomePage()
    {
        CheckButtonsAtPages objCheckScooterLogoFromHomePage = new CheckButtonsAtPages(driver);

        objCheckScooterLogoFromHomePage
                .openHomePage()
                .clickAtButtonSamokat()
                .checkHomePage();
    }

    @Test
    public void checkButtonYandexFromOrderPage()
    {
        CheckButtonsAtPages objCheckYandexLogoFromHomePage = new CheckButtonsAtPages(driver);
        objCheckYandexLogoFromHomePage
                .openOrderPage()
                .clickAtButtonYandex()
                .switchToWindow()
                .checkDZEN();
    }

    @Test
    public void checkButtonScooterFromOrderPage()
    {
        CheckButtonsAtPages objCheckScooterLogoFromHomePage = new CheckButtonsAtPages(driver);

        objCheckScooterLogoFromHomePage
                .openOrderPage()
                .clickAtButtonSamokat()
                .checkHomePage();
    }




    @After
    public void tearDown()
    {
        driver.quit();
    }
}

