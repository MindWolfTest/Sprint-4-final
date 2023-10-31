package ru.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.pageobject.CreateNewOrderAndCancel;

@RunWith(Parameterized.class)
public class CreateNewOrderTest extends BeforeAndAfterForAll
{
    private final String renterFirstName;
    private final String renterSecondName;
    private final String renterDeliveryAddress;
    private final String renterMetroStation;
    private final String renterPhoneNumber;
    private final String dateWhenDeliveryScooter;
    private final String rentalPeriod;
    private final String firstColorForScooter;
    private final String secondColorForScooter;
    private final String renterComment;

    public CreateNewOrderTest (String renterFirstName,String renterSecondName,String renterDeliveryAddress,
                               String renterMetroStation,String renterPhoneNumber,String dateWhenDeliveryScooter,
                               String rentalPeriod,String firstColorForScooter,String secondColorForScooter,String renterComment)
    {
        this.renterFirstName = renterFirstName;
        this.renterSecondName = renterSecondName;
        this.renterDeliveryAddress = renterDeliveryAddress;
        this.renterMetroStation= renterMetroStation;
        this.renterPhoneNumber= renterPhoneNumber;
        this.dateWhenDeliveryScooter = dateWhenDeliveryScooter;
        this.rentalPeriod = rentalPeriod;
        this.firstColorForScooter = firstColorForScooter;
        this.secondColorForScooter = secondColorForScooter;
        this.renterComment = renterComment;
    }


    @Parameterized.Parameters
    public static Object[][] getParameters()
    {
        return new Object[][]
        {
                {"Ва", "Петров", "Арбат", "Таганская", "+79991002277", "30.10.2023", "сутки", "grey", "black", "1"},
                {"Вас", "ПетровПетров", "Балчуг", "Пушкинская", "+79991002277", "31.10.2023", "двое суток", "black", "", "2"},
                {"ВасяВасяВасяВа", "ПетровПетровПетро", "Центральный проезд Хорошёвского Серебряного бора7",
                        "Лихоборы", "+79991002277", "30.10.2023", "трое суток" , "black", "black", "3"},
                {"ВасяВасяВасяВас", "Петро", "Абельмановская Застава", "Калужская", "+79991002277", "30.11.2023", "четверо суток", "grey", "grey", "4"},
                {"Вася Вася", "ПятаяФамилия", "Таганская улица д. 29", "Минская", "89991002277", "01.12.2023", "пятеро суток", "", "grey", "5"},
                {" ВасяВася", "ШестаяФамилия", "Таганская улица, 29", "Беговая", "899910022771", "5.5.2023", "шестеро суток", "", "black", "6"},
                {"ВасяВася ", "СедьмаяФамилия", "Антонова-Овсеенко", "Филёвский парк", "8999100227714", "10.10.2020", "семеро суток", "", "black", "7"}
        };
    }

    @Test
    public void checkCreateOrderAndCancelOrder()
    {
        CreateNewOrderAndCancel objCreateNewOrderForTestFromHeaderAndCancel = new CreateNewOrderAndCancel(driver);

        objCreateNewOrderForTestFromHeaderAndCancel
                .enterToOrderPageFromHeader()
                .createNewOrderFirstPage(renterFirstName, renterSecondName, renterDeliveryAddress,
                                         renterMetroStation, renterPhoneNumber)

                .gotoNextPageInOrder()
                .createNewOrderSecondPage(dateWhenDeliveryScooter, rentalPeriod,
                                          firstColorForScooter, secondColorForScooter, renterComment)

                .confirmAndCheckOrderFromSecondPage()
                .cancelOrder();
    }
}
