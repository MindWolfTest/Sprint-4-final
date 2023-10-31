package ru.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.praktikum.pageobject.constants.ConstantsForTestPages.TEXT_IN_FIRST_ORDER_PAGE;
import static ru.praktikum.pageobject.constants.URL.DZEN_PAGE;
import static ru.praktikum.pageobject.constants.URL.HOME_PAGE;
import static ru.praktikum.pageobject.constants.URL.ORDER_PAGE;


public class CheckButtonsAtPages
{
    private WebDriver driver;
    private By buttonAcceptCookies = By.id("rcc-confirm-button");
    private By buttonInFooter = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By textInSecondPageForCheckPage = By.className("Order_Header__BZXOb");
    private By logoSamokat = By.className("Header_LogoScooter__3lsAR");
    private By logoYandex = By.className("Header_LogoYandex__3TSOI");

    public CheckButtonsAtPages(WebDriver driver)
    {
        this.driver = driver;
    }
    public CheckButtonsAtPages openHomePage()
    {
        driver.get(HOME_PAGE);
        return this;
    }

    public CheckButtonsAtPages openOrderPage()
    {
        driver.get(ORDER_PAGE);
        return this;
    }

    public CheckButtonsAtPages enterToOrderPageFromFooter()
    {
        driver.findElement(buttonAcceptCookies).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(buttonInFooter))
                .click();
        return this;
    }

    public CheckButtonsAtPages checkOpenFirstPageOrderFromFooterButton()
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(textInSecondPageForCheckPage));
        String receivedTextFromFirstOrderPage = driver.findElement(textInSecondPageForCheckPage).getText();
        assertThat("Ошибка! Страница не открылась!", receivedTextFromFirstOrderPage, containsString(TEXT_IN_FIRST_ORDER_PAGE));
        return this;
    }

    public CheckButtonsAtPages clickAtButtonYandex()
    {
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(logoYandex))
                .click();

        return this;
    }

    public CheckButtonsAtPages clickAtButtonSamokat()
    {
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(logoSamokat))
                .click();
        return this;
    }

    public CheckButtonsAtPages switchToWindow()
    {
        String handle = driver.getWindowHandles().toArray()[1]
                .toString();
        driver.switchTo().window(handle);
        return this;
    }

    public CheckButtonsAtPages checkDZEN()
    {
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.urlContains(DZEN_PAGE));

        assertThat("Ошибка! Страница Дзен не открылась!", driver.getCurrentUrl(), containsString(DZEN_PAGE));
        return this;
    }

    public CheckButtonsAtPages checkHomePage()
    {
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.urlContains(HOME_PAGE));

        assertThat("Ошибка! Страница самоката не открылась!", driver.getCurrentUrl(), containsString(HOME_PAGE));
        return this;
    }
}
