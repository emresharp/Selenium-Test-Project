import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage extends BasePage {

    By mailBoxLocator = new By.ByXPath("//*[@id=\"L-UserNameField\"]");
    By passwordBoxLocator =new By.ByXPath("//*[@id=\"L-PasswordField\"]");
    By loginButtonLocator =new By.ByXPath("//*[@id=\"gg-login-enter\"]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void mailwrite(String text){
        type(mailBoxLocator, text);
    }

    public void passwordwrite(String text){
        type(passwordBoxLocator, text);
        click(loginButtonLocator);
    }


}
