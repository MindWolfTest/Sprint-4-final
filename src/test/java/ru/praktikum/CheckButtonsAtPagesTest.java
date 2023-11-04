package ru.praktikum;

import org.junit.Test;
import ru.praktikum.pageobject.CheckButtonsAtPages;
public class CheckButtonsAtPagesTest extends BeforeAndAfterForAll
{
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
}

