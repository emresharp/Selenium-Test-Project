import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    static final Logger logger = Logger.getLogger("Logging.class");


    WebDriver driver ;

    @BeforeAll
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Tarayici Acildi.");
        driver.get("https://www.gittigidiyor.com");
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "https://www.gittigidiyor.com/","Site Açıldı." );
        logger.info("Site Acildi.");
        driver.manage().window().maximize();
        logger.info("Tam Ekran Yapildi.");


    }

    @AfterAll
    public void tearDown(){
        driver.quit();
        logger.info("Tarayici Kapatildi.");
    }

}