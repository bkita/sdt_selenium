package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PopularItemsPage;
import url.Url;
import utils.PageTitles;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HomePageTest extends BaseTest {

    private PopularItemsPage popularItemsPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(Url.BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitles.HOME_PAGE_TITLE);

        popularItemsPage = new PopularItemsPage(driver);
    }

    @Test
    void shouldSeeSevenPopularItemsOnHomePage() {
        List<String> productNames = popularItemsPage.getProductNames();
        assertThat(productNames.size()).isEqualTo(7);
    }
}
