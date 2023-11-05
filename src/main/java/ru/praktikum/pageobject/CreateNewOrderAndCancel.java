package ru.praktikum.pageobject;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.core.StringStartsWith.startsWith;
import static ru.praktikum.pageobject.constants.ScooterColorConstant.BLACK;
import static ru.praktikum.pageobject.constants.ScooterColorConstant.GREY;
import static ru.praktikum.pageobject.constants.URL.HOME_PAGE;

public class CreateNewOrderAndCancel
{
    private WebDriver driver;

    //Кнопка заказать в хеддере
    private By buttonInHeader = By.className("Button_Button__ra12g");

    //Поле Имени
    private By renterFirstNameField = By.xpath(".//input[@placeholder = '* Имя']");

    //Поле Фамилии
    private By renterSecondNameField = By.xpath(".//input[@placeholder = '* Фамилия']");

    //Поле Адреса
    private By renterDeliveryAddressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");

    //Поле станции метро
    private By renterMetroStationField = By.className("select-search__input");

    //Поле номер телефона
    private By renterPhoneNumberField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    //Кнопка Далее
    private By nextPageInOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Поле даты доставки
    private By dateWhenDeliveryScooterField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    //Поле срока аренды
    private By rentalPeriodField = By.xpath(".//div[text()='* Срок аренды']");

    //чекбокс черного цвета
    private By colorBlackForScooterCheckBox = By.id("black");

    //чекбокс серого цвета
    private By colorGreyForScooterCheckBox = By.id("grey");

    //поле комментарий для курьера
    private By renterCommentField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");

    //Кнопка Заказать на стр "Про аренду"
    private By buttonInSecondPage = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Кнопка Да в окне Хотите оформить заказ?
    private By buttonForConfirmOrder = By.xpath(".//button[text()='Да']");

    //Кнопка посмотреть статус в окне с информацией о заказе
    private  By checkOrderStatus = By.xpath(".//button[text()='Посмотреть статус']");

    //Окно с сообщением о статусе заказа
    private By orderStatusMessage = By.xpath(".//div[@class= 'Order_ModalHeader__3FDaJ']");

    //Кнопка Отменить заказ
    private By cancelOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");

    //Кнопка Отменить в окне Хотите отменить заказ?
    private By confirmCancelButton = By.xpath(".//button[text()='Отменить']");

    //Кнопка хорошо в окне Заказ отменён
    private By confirmOkButton = By.xpath(".//button[text()='Хорошо']");

    //Ожидаемое сообщение
    private String expectedOrderMessage = "Заказ оформлен";

    public CreateNewOrderAndCancel (WebDriver driver)
    {
        this.driver = driver;
    }

    //Метод открытия главной стр сайта
    public void openHomePage()
    {
        driver.get(HOME_PAGE);
    }

    //Зашли на 1 стр оформления заказа через хедер
    public CreateNewOrderAndCancel enterToOrderPageFromHeader()
    {
        openHomePage();
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonInHeader))
                .click();
        return this;
    }

    //Метод ввода имени заказчика
    public CreateNewOrderAndCancel inputRenterFirstNameField(String renterFirstName)
    {
        driver.findElement(renterFirstNameField).sendKeys(renterFirstName);
        return this;
    }

    //Метод ввода фамилии заказчика
    public CreateNewOrderAndCancel inputRenterSecondNameField(String renterSecondName)
    {
        driver.findElement(renterSecondNameField).sendKeys(renterSecondName);
        return this;
    }

    //Метод ввода адреса доставки
    public CreateNewOrderAndCancel inputDeliveryAddressField (String deliveryAddress)
    {
        driver.findElement(renterDeliveryAddressField).sendKeys(deliveryAddress);
        return this;
    }

    //Метод выбора станции метро
    public CreateNewOrderAndCancel chooseRenterMetroStationField (String renterMetroStation)
    {

        driver.findElement(renterMetroStationField).click();
        WebElement element = driver.findElement(By.xpath(".//div[2]/ul/li/button/div[text()='"+renterMetroStation+"']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath(".//div[2]/ul/li/button/div[text()='"+renterMetroStation+"']")).click();
        return this;
    }

    //Метод ввода номера телефона
    public CreateNewOrderAndCancel inputRenterPhoneNumberField (String renterPhoneNumber)
    {
        driver.findElement(renterPhoneNumberField).sendKeys(renterPhoneNumber);
        return this;
    }

    //Метод перехода на следующую стр формы
    public CreateNewOrderAndCancel gotoNextPageInOrder()
    {
        driver.findElement(nextPageInOrder).click();
        return this;
    }

    //Метод ввода даты доставки самоката
    public CreateNewOrderAndCancel inputDateWhenDeliveryScooterField (String dateWhenDeliveryScooter)
    {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(dateWhenDeliveryScooterField));
        driver.findElement(dateWhenDeliveryScooterField).sendKeys(dateWhenDeliveryScooter);
        return this;
    }

    //Метод выбора станции метро
    public CreateNewOrderAndCancel chooseRentalPeriodField (String rentalPeriod)
    {
        driver.findElement(By.xpath(".//div[text()='Про аренду']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(30))
                            .until(ExpectedConditions.elementToBeClickable(rentalPeriodField))
                            .click();

        driver.findElement(By.xpath(".//div[text()='"+rentalPeriod+"']")).click();
        return this;
    }

    //Метод выбора первого цвета для скутера

    public CreateNewOrderAndCancel chooseFirstColor(String firstColorForScooter)
    {
        if (firstColorForScooter.equals(BLACK))
        {
            driver.findElement(colorBlackForScooterCheckBox).click();
        }
        else if(firstColorForScooter.equals(GREY))
        {
            driver.findElement(colorGreyForScooterCheckBox).click();
        }
        return this;
    }

    //Метод выбора второго цвета для скутера
    public CreateNewOrderAndCancel chooseSecondColor(String secondColorForScooter)
    {
        if (secondColorForScooter.equals(BLACK))
        {
            driver.findElement(colorBlackForScooterCheckBox).click();
        }
        else if (secondColorForScooter.equals(GREY))
        {
            driver.findElement(colorGreyForScooterCheckBox).click();
        }
        return this;
    }
    /*public CreateNewOrderAndCancel chooseColorForScooterCheckBox (String firstColorForScooter, String secondColorForScooter)
    {
        //реализовал if else для упрощения ввода тестовых данных (цвета можно менять местами)
        if (firstColorForScooter.equals(BLACK) && secondColorForScooter.equals(GREY) || firstColorForScooter.equals(GREY) && secondColorForScooter.equals(BLACK))
        {
            driver.findElement(colorBlackForScooterCheckBox).click();
            driver.findElement(colorGreyForScooterCheckBox).click();
        }

        else if (firstColorForScooter.equals(BLACK) && secondColorForScooter.equals(BLACK))
        {
            driver.findElement(colorBlackForScooterCheckBox).click();
        }

        else if (firstColorForScooter.equals(GREY) && secondColorForScooter.equals(GREY))
        {
            driver.findElement(colorGreyForScooterCheckBox).click();
        }

        else if (firstColorForScooter.equals(BLACK) && secondColorForScooter.isEmpty() || firstColorForScooter.isEmpty() && secondColorForScooter.equals(BLACK))
        {
            driver.findElement(colorBlackForScooterCheckBox).click();
        }

        else if (firstColorForScooter.equals(GREY) && secondColorForScooter.isEmpty() || firstColorForScooter.isEmpty() && secondColorForScooter.equals(GREY))
        {
            driver.findElement(colorGreyForScooterCheckBox).click();
        }

        return this;
    }*/

    //Метод ввода комментария
    public CreateNewOrderAndCancel inputRenterCommentField(String renterComment)
    {
        driver.findElement(renterCommentField).sendKeys(renterComment);
        return this;
    }

    //Метод клика по кнопкам для оформления заказа
    public CreateNewOrderAndCancel pressButtonsForOrder()
    {
        driver.findElement(buttonInSecondPage).click();
        driver.findElement(buttonForConfirmOrder).click();
        return this;
    }

    //Метод сравнения полученного сообщения
    public CreateNewOrderAndCancel orderStatus (String expectedOrderMessage)
    {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(orderStatusMessage));

        String receivedOrderMessage = driver.findElement(orderStatusMessage).getText();
        MatcherAssert.assertThat("Ошибка! Заказ не оформлен!",receivedOrderMessage, startsWith(expectedOrderMessage));
        return this;
    }

    //Метод отмены полученного заказа
    public CreateNewOrderAndCancel cancelOrder ()
    {
        driver.findElement(checkOrderStatus).click();
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(cancelOrderButton))
                .click();

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(confirmCancelButton))
                .click();

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(confirmOkButton))
                .click();
        return this;
    }



    //Суммирующий метод для создания заказа через хедер

    public CreateNewOrderAndCancel createNewOrderFirstPage(String renterFirstName,String renterSecondName,String renterDeliveryAddress,
                                        String renterMetroStation,String renterPhoneNumber)
    {
        inputRenterFirstNameField(renterFirstName);
        inputRenterSecondNameField(renterSecondName);
        inputDeliveryAddressField(renterDeliveryAddress);
        chooseRenterMetroStationField(renterMetroStation);
        inputRenterPhoneNumberField(renterPhoneNumber);
        return this;
    }

    /*public CreateNewOrderAndCancel createNewOrderSecondPage(String dateWhenDeliveryScooter,
                                         String rentalPeriod,String firstColorForScooter,
                                         String secondColorForScooter,String renterComment)
    {
        inputDateWhenDeliveryScooterField(dateWhenDeliveryScooter);
        chooseRentalPeriodField(rentalPeriod);
        chooseColorForScooterCheckBox(firstColorForScooter, secondColorForScooter);
        inputRenterCommentField(renterComment);
        return this;
    }*/

    public CreateNewOrderAndCancel confirmAndCheckOrderFromSecondPage()
    {
        pressButtonsForOrder();
        orderStatus(expectedOrderMessage);
        return this;
    }
}
