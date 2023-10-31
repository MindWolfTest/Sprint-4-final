package ru.praktikum;

import org.junit.Test;
import ru.praktikum.pageobject.SearchNotFoundOrderError;

import static org.junit.Assert.assertTrue;

public class SearchNotFoundOrderErrorTest extends BeforeAndAfterForAll
{
    private String orderNumber = "1234";

    @Test
    public void checkSearchAtHomePage()
    {
        SearchNotFoundOrderError objTestSearch = new SearchNotFoundOrderError(driver);
        objTestSearch
                .openHomePage()
                .clickButtonStatusOrder()
                .inputSearchField(orderNumber)
                .clickGoButton();
        assertTrue("Ошибка! Нет сообщения об отсутствии заказа", objTestSearch.checkForNotFound());
    }
}
