package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class SearchPage {

    private final static By MAP_BUTTON = By.xpath("//div[@ data-testid='map-trigger']");

    private final static By MAP_OPEN = By.xpath("//div[@ class='map_full_overlay__mask']");

    private final static By HOTEL_MAP_CARD = By.xpath("//a[@ class='map-card__container']|//a[@ class='b6ae4fce06']");

    private final static By HOTEL_RATE = By.xpath("//div [@ class='bui-review-score__badge']|//div[@ class='c3deae0c07']/div/div");

    private final static By HOTEL_NAME = By.xpath("//span [@ class='map-card__title-link']|//span[@ class='ac78a73c96 e3c18fe918']");

    private final static By STAR = By.xpath("//a [@ class='map-card__container'][1]//span [@ class='bui-icon bui-rating__item bui-icon--medium']|//a [@ class='b6ae4fce06'][1]//span[@ class='b6dc9a9e69 adc357e4f1 fe621d6382']");

    private final static By COUNT_REVIEWS = By.xpath("//a [@ class='map-card__container'][1]//div [@ class='bui-review-score__text']|//a[@ class='b6ae4fce06'][1]//div[@ class='d8eab2cf7f c90c0a70d3 db63693c62']");

    private final static By PRICE = By.xpath("//a [@ class='map-card__container'][1]//span [@ class='prco-valign-middle-helper']|//a [@ class='b6ae4fce06'][1]//span[@ class='fcab3ed991 bd73d13072']");

    private final static By POINT_MAP = By.xpath("//a[@ class='map-card__container']|//a[@ class='b6ae4fce06']");

    private final static By LOAD_BOX = By.xpath("//*[@ class='map_left_cards_loader_conatiner']");

    private final static By SORT_BOX = By.xpath("//button [@ data-testid='sorters-dropdown-trigger']");

    private final static By SORT_BEST_PRICE_AND_REVIEWS = By.xpath("//button[@ data-id='review_score_and_price']");

    private final static By FREE_CANCEL = By.cssSelector("div[data-filters-item='fc:fc=2']");

    private final static By CHECKBOX = By.cssSelector("span.bbdb949247");

    private final static By NAME_HOTEL_2 = By.xpath("//div[@ class='fcab3ed991 a23c043802']");

    private final static By WISHLIST_BOX = By.xpath("//div[@ class='d226e2f1b9']");

    @Step("Нажать на кнопку карты")
    public SearchPage setMap() {
        $(MAP_BUTTON).click();
        $(MAP_OPEN).shouldBe(visible);
        return this;
    }

    @Step("Навести курсор на первый отель")
    public SearchPage hoverHotel() {
        $(LOAD_BOX).shouldNotBe(visible);
        $(HOTEL_MAP_CARD).shouldBe(visible).hover();
        return this;
    }

    @Step("Запомнить название отеля")
    public String checkHotelName() {
        String name = $(HOTEL_NAME).text();
        return name;
    }

    @Step("Запомнить рейтинг отеля")
    public String checkHotelRate() {
        String name = $(HOTEL_RATE).text();
        return name;
    }

    @Step("Запомнить количество звезд отеля")
    public int checkHotelStar() {
        int star = $$(STAR).size();
        return star;
    }

    @Step("Запомнить количество отзывов отеля")
    public String checkHotelReview() {
        String review = $(COUNT_REVIEWS).text();
        return review;
    }

    @Step("Запомнить цену отеля")
    public String checkHotelPrice() {
        String price = $(PRICE).text();
        return price;
    }

    @Step("Нажать на маркер отеля")
    public SearchPage clickMap() {
        $(POINT_MAP).click();
        return this;
    }

    @Step("Сортировать отели по цене и отзывам")
    public SearchPage sortSearch() {
        $(SORT_BOX).click();
        $(SORT_BEST_PRICE_AND_REVIEWS).click();
        return this;
    }

    @Step("Выбрать отели с бесплатной отменой бронирования")
    public SearchPage searchFreeCancel() {
        $(FREE_CANCEL).shouldBe(visible).find(CHECKBOX).click();
        return this;
    }

    @Step("Выбрать первый отель")
    public SearchPage setHotel() {
        $(NAME_HOTEL_2).click();
        return this;
    }

    @Step("Нажать на Сердечко - добавить в избранное")
    public SearchPage visibleHotel() {
        $(LOAD_BOX).shouldNotBe(visible);
        $(NAME_HOTEL_2).shouldBe(visible).hover();
        $(WISHLIST_BOX).click();
        return this;
    }

    @Step("Запомнить название отеля")
    public String checkHotelName2() {
        return $(NAME_HOTEL_2).text();
    }
}
