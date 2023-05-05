package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class HotelPage {
    private final static By CHECK_NAME = By.xpath("//div [@ id='hp_hotel_name']//h2");

    private final static By CHECK_STARS = By.xpath("//span[@ class='b6dc9a9e69 adc357e4f1 fe621d6382']");

    private final static By CHECK_RATE = By.xpath("//div[@ class='b5cd09854e d10a6220b4']");

    private final static By CHECK_REVIEW = By.xpath("//span[@ class='b5cd09854e c90c0a70d3 db63693c62']");

    private final static By CHECK_PRICE = By.xpath("//span [@ class='prco-valign-middle-helper']");

    private final static By WISHLIST_BOX = By.xpath("//button[@ id='wl--wl_entrypoint_hp_head']");

    private final static By CHECK_NAME_HOTEL = By.xpath("//h2[@ class='d2fee87262 pp-header__title']");
    @Step("Проверить видимость полей на странице")
    public HotelPage openPageHotel() {
        $(CHECK_NAME).shouldBe(visible);
        $(CHECK_RATE).shouldBe(visible);
        $(CHECK_REVIEW).shouldBe(visible);
        $(CHECK_PRICE).shouldBe(visible);
        return this;
    }
    @Step("Проверить название отеля на открывшейся новой странице")
    public HotelPage checkHotelNamePage(String name) {
        $(CHECK_NAME).shouldHave(Condition.text(name));
        return this;
    }
    @Step("Проверить рейтинг отеля на открывшейся новой странице")
    public HotelPage checkHotelRatePage(String rate) {
        $(CHECK_RATE).shouldHave(Condition.text(rate));
        return this;
    }
    @Step("Проверить количество звезд отеля на открывшейся новой странице")
    public HotelPage checkHotelStarsPage(int stars) {
        $$(CHECK_STARS).shouldBe(CollectionCondition.size(stars));
        return this;
    }
    @Step("Проверить количество отзывов отеля на открывшейся новой странице")
    public HotelPage checkHotelReviewPage(String review) {
        $(CHECK_REVIEW).shouldHave(Condition.text(review));
        return this;
    }
    @Step("Проверить цену отеля на открывшейся новой странице")
    public HotelPage checkHotelPricePage(String price) {
        $(CHECK_PRICE).shouldHave(Condition.text(price));
        return this;
    }
    @Step("Нажать на кнопку Избранное на открывшейся странице")
    public HotelPage wishList() {
        $(WISHLIST_BOX).shouldBe(visible).click();
        return this;
    }
    @Step("Проверить название отеля на открывшейся новой страницеПроверить название отеля на открывшейся новой странице")
    public HotelPage checkHotel2NamePage(String name) {
        $(CHECK_NAME_HOTEL).shouldBe(Condition.text(name));
        return this;
    }

}