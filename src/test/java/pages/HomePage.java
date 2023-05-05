package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static tests.BaseTest.config;

import static com.codeborne.selenide.Selenide.$;


public class HomePage {
    private final static By ACCEPT_COOKIE_BUTTON = By.xpath("//button[@id='onetrust-accept-btn-handler']");

    private final static By SEARCH_FIELD = By.xpath("//input[@ id=':Ra9:']");

    private final static By SUBMIT_BUTTON = By.xpath("//button[@ type='submit']");

    private final static By FIRST_IN_DROPDOWN = By.cssSelector("div.e4b761c8b0");

    private final static By DATA_FIELD = By.cssSelector("div[data-testid='searchbox-dates-container']");

    @Step("Открыть страницу https://www.booking.com/")
    public HomePage openHomePage() {
        Selenide.open(config.baseUrl());
        return this;
    }
    @Step("Принять Cookie")
    public HomePage acceptCookie() {
        $(ACCEPT_COOKIE_BUTTON).click();
        return this;
    }
    @Step("Ввести в поле поиска нужный город")
    public HomePage searchCity(String city) {
        $(SEARCH_FIELD).sendKeys(city);
        $(FIRST_IN_DROPDOWN).shouldHave(Condition.text(city));
        return this;
    }
    @Step("Нажать на поле ввода дат")
    public HomePage selectData() {
        $(DATA_FIELD).click();
        return this;
    }
    @Step("Нажать на поле кнопку Найти")
    public HomePage searchHotels() {
        $(SUBMIT_BUTTON).click();
        return this;
    }
}
