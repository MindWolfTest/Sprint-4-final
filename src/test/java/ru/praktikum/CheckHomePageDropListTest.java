package ru.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.pageobject.CheckHomePageDropList;

import static org.junit.Assert.assertEquals;
import static ru.praktikum.pageobject.constants.ConstantForTestingDropList.*;
import static ru.praktikum.pageobject.constants.URL.HOME_PAGE;

@RunWith(Parameterized.class)
public class CheckHomePageDropListTest extends BeforeAndAfterForAll
{
    private final By question;
    private final By answer;
    private final By answerResult;
    private final String expected;

    public CheckHomePageDropListTest(By question, By answer, By answerResult, String expected)
    {
        this.question = question;
        this.answer = answer;
        this.answerResult = answerResult;
        this.expected = expected;
    }

        @Parameterized.Parameters
        public static Object[][] getParameters()
        {
            return new Object[][]
            {
                {QUESTION_HOW_MUCH_COST_RENT, ANSWER_FOR_HOW_MUCH_COST_RENT,
                        ITEM_ANSWER_FOR_HOW_MUCH_COST_RENT, TEXT_ANSWER_FOR_HOW_MUCH_COST_RENT},

                {QUESTION_WANNA_MORE_THEN_ONE_SCOOTER, ANSWER_FOR_QUESTION_WANNA_MORE_THEN_ONE_SCOOTER,
                        ITEM_ANSWER_FOR_QUESTION_WANNA_MORE_THEN_ONE_SCOOTER, TEXT_ANSWER_FOR_QUESTION_WANNA_MORE_THEN_ONE_SCOOTER},

                {QUESTION_HOW_RENTAL_TIME_CALCULATED, ANSWER_FOR_HOW_RENTAL_TIME_CALCULATED,
                        ITEM_ANSWER_FOR_HOW_RENTAL_TIME_CALCULATED, TEXT_ANSWER_FOR_HOW_RENTAL_TIME_CALCULATED},

                {QUESTION_CAN_I_TAKE_SCOOTER_RENT_FOR_TODAY, ANSWER_FOR_CAN_I_TAKE_SCOOTER_RENT_FOR_TODAY,
                        ITEM_ANSWER_FOR_CAN_I_TAKE_SCOOTER_RENT_FOR_TODAY, TEXT_ANSWER_FOR_CAN_I_TAKE_SCOOTER_RENT_FOR_TODAY},

                {QUESTION_CAN_I_RETURN_SCOOTER_EARLIER_OR_EXTEND_RENT, ANSWER_FOR_CAN_I_RETURN_SCOOTER_EARLIER_OR_EXTEND_RENT,
                        ITEM_ANSWER_FOR_CAN_I_RETURN_SCOOTER_EARLIER_OR_EXTEND_RENT, TEXT_ANSWER_FOR_CAN_I_RETURN_SCOOTER_EARLIER_OR_EXTEND_RENT},

                {QUESTION_ARE_YOU_GIVE_CHARGING, ANSWER_FOR_ARE_YOU_GIVE_CHARGING,
                        ITEM_ANSWER_FOR_ARE_YOU_GIVE_CHARGING, TEXT_ANSWER_FOR_ARE_YOU_GIVE_CHARGING},

                {QUESTION_CAN_I_CANCEL_RENT, ANSWER_FOR_CAN_I_CANCEL_RENT,
                        ITEM_ANSWER_FOR_CAN_I_CANCEL_RENT, TEXT_ANSWER_FOR_CAN_I_CANCEL_RENT},

                {QUESTION_I_LEAVE_OUT_OF_MKAD, ANSWER_FOR_I_LEAVE_OUT_OF_MKAD,
                        ITEM_ANSWER_FOR_I_LEAVE_OUT_OF_MKAD, TEXT_ANSWER_FOR_I_LEAVE_OUT_OF_MKAD}
            };
        }



        @Before
        /*public void setUp()
        {
             ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
            driver = new ChromeDriver();
            //driver = new FirefoxDriver();
            driver.get(HOME_PAGE);
        }*/

        @Test
        public void checkHomePageList ()
        {
            driver.get(HOME_PAGE);
            CheckHomePageDropList objCheckDropListAtHomePage = new CheckHomePageDropList(driver);

            objCheckDropListAtHomePage
                                        .waitForLoadHomePage()
                                        .scrollMoveToQuestion()
                                        .clickForQuestion(question)
                                        .waitAfterClickOnQuestion(answerResult);
            String result = driver.findElement(answer).getText();
            assertEquals(expected, result);
        }
    /*@After
    public void tearDown()
    {
        driver.quit();
    }*/
}
