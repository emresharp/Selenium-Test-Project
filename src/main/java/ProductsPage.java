import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductsPage extends BasePage {

    By filterOptionLocator = new By.ByXPath ("//*[@id=\"srp-popular-filter\"]/p/span[1]");
    By productLinkLocator = new By.ByClassName("product-link");
    By secondPageButtonLocator = new By.ByXPath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        return isDisplayed(filterOptionLocator);
    }

    public void selectProduct(int i) {
        getAllProducts().get(i).click();
    }

    public void selectSecondPage(){
        click(secondPageButtonLocator);
    }

    private List<WebElement> getAllProducts(){
        return findAll(productLinkLocator);
    }
}