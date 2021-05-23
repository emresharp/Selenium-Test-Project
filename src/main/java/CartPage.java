import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage {

    By deleteIconLocator = new By.ByCssSelector("a[title='Sil']");
    By emptyCartTextLocator = new By.ByXPath("//*[@id=\"empty-cart-container\"]/div[1]/div[1]/div/div[1]/i");
    By selectProductCountLocator = new By.ByCssSelector("select.amount");
    By selectOptionTwoProductCountLocator = new By.ByCssSelector("select.amount>:nth-child(2");
    By totalProductCountTextLocator = new By.ByXPath("//*[@id=\"submit-cart\"]/div/div[2]/div[3]/div/div[1]/div/div[5]/div[1]/div/ul/li[1]/div[1]");
    By productCartPriceTextLocator = new By.ByXPath("//*[@id=\"cart-price-container\"]/div[3]/p");



    public CartPage(WebDriver driver) {
        super(driver);
    }


  public void deleteProducts(){
          click(deleteIconLocator);
      }

    public boolean isEmptyCart() {  //fiyat karşılaştırma isdipslay denicez
        return isDisplayed(emptyCartTextLocator);
    }

    public boolean isCountedProduct() {
        return isDisplayed(totalProductCountTextLocator);
    }

    public void selectTwoProducts(){
        click(selectProductCountLocator);
        click(selectOptionTwoProductCountLocator);
    }

    public boolean isProductPrice() {
        return isDisplayed(productCartPriceTextLocator);
    }


}