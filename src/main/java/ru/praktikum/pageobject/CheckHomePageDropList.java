package ru.praktikum.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckHomePageDropList
{
    private WebDriver driver;
    private By homeHeader = By.className("Home_Header__iJKdX");
    private By questionsHeader = By.className("Home_FourPart__1uthg");

    public CheckHomePageDropList(WebDriver driver)
    {
        this.driver = driver;
    }

    //Метод ожидания когда загрузится главная стр
    public CheckHomePageDropList waitForLoadHomePage()
    {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(driver -> (driver.findElement(homeHeader).getText() != null
                && !driver.findElement(homeHeader).getText().isEmpty()
        ));
        return this;
    }

    //Ожидание загрузки ответа на вопрос
    public void waitAfterClickOnQuestion(By questionAfterOpen)
    {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(driver -> (driver.findElement(questionAfterOpen).getText() != null
                && !driver.findElement(questionAfterOpen).getText().isEmpty()
        ));
    }

    //Метод прокрутки до блока Вопросы о важном
    public CheckHomePageDropList scrollMoveToQuestion()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionsHeader));
        return this;
    }

    //Метод клика по вопросу
    public CheckHomePageDropList clickForQuestion(By question)
    {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(question))
                .click();
        return this;
    }
}
