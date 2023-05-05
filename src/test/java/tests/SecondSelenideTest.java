package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import pages.HomePage;
import pages.HotelPage;
import pages.SearchPage;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

@Feature("Second Test")
@Owner("Григорий Герасимов")
@Description("Добавляем нужный отель в избранное и удаляем его из избранного на новой странице")
@DisplayName("Добавляем нужный отель в избранное и удаляем его из избранного на новой странице")
public class SecondSelenideTest extends BaseTest {
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    HotelPage hotelPage = new HotelPage();
    private String city = "Паттайя";
    static LocalDate startDate = LocalDate.now().plusDays(7);
    static LocalDate endDate = LocalDate.now().plusDays(21);
    private final static By DATA_START = By.xpath("//span[@ data-date='" + startDate + "']");

    private final static By DATA_END = By.xpath("//span[@ data-date='" + endDate + "']");

    //Второй тест-кейс:
//     1.1 зайти на сайт https://www.booking.com/
//     1.2 ввести в поиске другой город(заграничный)
//     1.3 выбрать случайные другие даты
//     1.4 нажать на кнопку «Найти»
//     1.5 cортировать по «Лучшие отзывы и самая низкая цена»
//     1.6 добавить в избранное и перейти на страницу лучшего отеля
//     1.7 проверить название открытого отеля
//     1.8 удалить отель из избранного
    @Test
    public void bookingFindHotel2() {
        homePage.openHomePage()
                .acceptCookie()
                .searchCity(city)
                .selectData();
        $(DATA_START).click();
        $(DATA_END).click();
        homePage.searchHotels();

        searchPage.sortSearch()
                .searchFreeCancel()
                .visibleHotel();

        String expectNameHotel = searchPage.checkHotelName2();

        searchPage.setHotel();
        switchTo().window(1);

        hotelPage.wishList().checkHotel2NamePage(expectNameHotel);

    }

}

