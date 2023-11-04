package ru.praktikum.pageobject.constants;
import org.openqa.selenium.By;

public class ConstantForTestingDropList
{

    public static final By QUESTION_HOW_MUCH_COST_RENT = By.id("accordion__heading-0");
    public static final By QUESTION_WANNA_MORE_THEN_ONE_SCOOTER = By.id("accordion__heading-1");
    public static final By QUESTION_HOW_RENTAL_TIME_CALCULATED = By.id("accordion__heading-2");
    public static final By QUESTION_CAN_I_TAKE_SCOOTER_RENT_FOR_TODAY = By.id("accordion__heading-3");
    public static final By QUESTION_CAN_I_RETURN_SCOOTER_EARLIER_OR_EXTEND_RENT = By.id("accordion__heading-4");
    public static final By QUESTION_ARE_YOU_GIVE_CHARGING = By.id("accordion__heading-5");
    public static final By QUESTION_CAN_I_CANCEL_RENT = By.id("accordion__heading-6");
    public static final By QUESTION_I_LEAVE_OUT_OF_MKAD = By.id("accordion__heading-7");


    public static final By ANSWER_FOR_HOW_MUCH_COST_RENT = By.id("accordion__panel-0");
    public static final By ANSWER_FOR_QUESTION_WANNA_MORE_THEN_ONE_SCOOTER = By.id("accordion__panel-1");
    public static final By ANSWER_FOR_HOW_RENTAL_TIME_CALCULATED = By.id("accordion__panel-2");
    public static final By ANSWER_FOR_CAN_I_TAKE_SCOOTER_RENT_FOR_TODAY = By.id("accordion__panel-3");
    public static final By ANSWER_FOR_CAN_I_RETURN_SCOOTER_EARLIER_OR_EXTEND_RENT = By.id("accordion__panel-4");
    public static final By ANSWER_FOR_ARE_YOU_GIVE_CHARGING = By.id("accordion__panel-5");
    public static final By ANSWER_FOR_CAN_I_CANCEL_RENT = By.id("accordion__panel-6");
    public static final By ANSWER_FOR_I_LEAVE_OUT_OF_MKAD = By.id("accordion__panel-7");
    public static final By ITEM_ANSWER_FOR_HOW_MUCH_COST_RENT = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' " +
            "and @aria-labelledby='accordion__heading-0']");
    public static final By ITEM_ANSWER_FOR_QUESTION_WANNA_MORE_THEN_ONE_SCOOTER = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' " +
            "and @aria-labelledby='accordion__heading-1']");
    public static final By ITEM_ANSWER_FOR_HOW_RENTAL_TIME_CALCULATED = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' " +
            "and @aria-labelledby='accordion__heading-2']");
    public static final By ITEM_ANSWER_FOR_CAN_I_TAKE_SCOOTER_RENT_FOR_TODAY = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' " +
            "and @aria-labelledby='accordion__heading-3']");
    public static final By ITEM_ANSWER_FOR_CAN_I_RETURN_SCOOTER_EARLIER_OR_EXTEND_RENT = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' " +
            "and @aria-labelledby='accordion__heading-4']");
    public static final By ITEM_ANSWER_FOR_ARE_YOU_GIVE_CHARGING = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' " +
            "and @aria-labelledby='accordion__heading-5']");
    public static final By ITEM_ANSWER_FOR_CAN_I_CANCEL_RENT = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' " +
            "and @aria-labelledby='accordion__heading-6']");
    public static final By ITEM_ANSWER_FOR_I_LEAVE_OUT_OF_MKAD = By.xpath(".//*[@data-accordion-component='AccordionItemPanel' " +
            "and @aria-labelledby='accordion__heading-7']");
    public static final String TEXT_ANSWER_FOR_HOW_MUCH_COST_RENT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String TEXT_ANSWER_FOR_QUESTION_WANNA_MORE_THEN_ONE_SCOOTER = "Пока что у нас так: один заказ — один самокат. Если хотите покататься " +
            "с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String TEXT_ANSWER_FOR_HOW_RENTAL_TIME_CALCULATED = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат " +
            "8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
            "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String TEXT_ANSWER_FOR_CAN_I_TAKE_SCOOTER_RENT_FOR_TODAY = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String TEXT_ANSWER_FOR_CAN_I_RETURN_SCOOTER_EARLIER_OR_EXTEND_RENT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в " +
            "поддержку по красивому номеру 1010.";
    public static final String TEXT_ANSWER_FOR_ARE_YOU_GIVE_CHARGING = "Самокат приезжает к вам с полной зарядкой. Этого хватает на " +
            "восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String TEXT_ANSWER_FOR_CAN_I_CANCEL_RENT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной " +
            "записки тоже не попросим. Все же свои.";
    public static final String TEXT_ANSWER_FOR_I_LEAVE_OUT_OF_MKAD = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

}
