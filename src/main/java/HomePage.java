import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    SearchBox searchBox ;

    By closeCookiesLocator = new By.ByXPath("//*[@id=\"__next\"]/main/section/section/a");
    By myAccountLocator = new By.ByXPath("//*[@id=\"main-header\"]/div[3]/div/div/div[1]/div[3]/div/div[1]/div[1]/div[2]/span");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox(){
        return this.searchBox;
    }



    public void goToCart() {
        driver.get("https://www.gittigidiyor.com/sepetim");
    }



    public void closeCookies(){
        if (isDisplayed(closeCookiesLocator)){
            click(closeCookiesLocator);
        }
   }

    public boolean isOnHomePage() {
        return isDisplayed(myAccountLocator);
    }


}