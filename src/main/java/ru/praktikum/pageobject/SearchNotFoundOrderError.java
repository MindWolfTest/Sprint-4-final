package ru.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.praktikum.pageobject.constants.URL.HOME_PAGE;

public class SearchNotFoundOrderError
{
    private WebDriver driver;
    private By buttonStatusOrder = By.className("Header_Link__1TAG7");
    private By searchFieldForOrderNumber = By.xpath(".//input[@placeholder = 'Введите номер заказа']");
    private By goButton = By.xpath(".//button[text() = 'Go!']");
    private By notFound = By.xpath(".//img[@alt = 'Not found']");
    public SearchNotFoundOrderError(WebDriver driver)
    {
        this.driver = driver;
    }

    public SearchNotFoundOrderError openHomePage()
    {
        driver.get(HOME_PAGE);
        return this;
    }

    public SearchNotFoundOrderError clickButtonStatusOrder()
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(buttonStatusOrder))
                .click();
        return this;
    }
    public SearchNotFoundOrderError inputSearchField (String orderNumber)
    {
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(searchFieldForOrderNumber))
                .sendKeys(orderNumber);
        return this;
    }

    public SearchNotFoundOrderError clickGoButton()
    {
        driver.findElement(goButton).click();
        return this;
    }

    public boolean checkForNotFound()
    {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(notFound));
        return !driver.findElements(notFound).isEmpty();
    }
}
