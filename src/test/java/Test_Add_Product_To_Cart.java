import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.util.Random;



public class Test_Add_Product_To_Cart extends BaseTest {




    HomePage homePage ;
    ProductsPage productsPage ;
    ProductDetailPage productDetailPage ;
    CartPage cartPage ;
    LoginPage loginPage ;


    @Test
    @Order(1)
    public void go_to_login(){
        homePage = new HomePage(driver);
        homePage.closeCookies();
        logger.info("Cerez Bildirimi Kapandi.");
        driver.get("https://www.gittigidiyor.com/uye-girisi?s=1");
        logger.info("Uye Girisi Sayfasina Gidildi.");

    }

    @Test
    @Order(2)
    public  void user_login() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.mailwrite("seleniumtestemre@gmail.com");
        Thread.sleep(2000);
        loginPage.passwordwrite("Selen123456");
        Thread.sleep(2000);
       // driver.get("https://www.gittigidiyor.com/");
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "https://www.gittigidiyor.com/","Giriş Yapıldı." );
        Thread.sleep(2000);
        logger.info("Kullanici Girisi Yapildi.");
    }


    @Test
    @Order(3)
    public void search_a_product(){
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("Bilgisayar");
        Assertions.assertTrue(productsPage.isOnProductPage() ,
                "Arama Sayfasına Ulaşılamadı.");
        logger.info("Bilgisayar Kelimesi Arandi.");
        productsPage.selectSecondPage();
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "https://www.gittigidiyor.com/arama/?k=Bilgisayar&sf=2","2. Sayfa Açıldı." );
        logger.info("2. Sayfa Acildi.");
    }


    @Test
    @Order(4)
    public void select_a_product(){
        productDetailPage = new ProductDetailPage(driver);
        Random random = new Random();
        int randomNumber = random.nextInt(48);
        productsPage.selectProduct(randomNumber);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
                "Bilgisayar Seçilemedi.");
        logger.info("Rastgele Bir Urun Secildi.");
    }


    @Test
    @Order(5)
    public void add_product_to_cart() throws InterruptedException {
        productDetailPage.addToCart();
        Thread.sleep(2000);
        logger.info("Urun Sepete Eklendi.");
    }


    @Test
    @Order(6)
    public void go_to_cart() throws InterruptedException {
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Thread.sleep(2000);
        Assertions.assertTrue(cartPage.isProductPrice(),"Ürün Fiyatı Karşılatırması Hatalı.");
        logger.info("Fiyat Karsilastirildi.");
        Thread.sleep(2000);
        cartPage.selectTwoProducts();
        Thread.sleep(2000);
        Assertions.assertTrue(cartPage.isCountedProduct(),"Ürün Sayısı Karşılatırması Hatalı.");
        logger.info("urun Sayisi Karsilastirildi.");
        Thread.sleep(2000);
        cartPage.deleteProducts();
        Thread.sleep(2000);
        Assertions.assertTrue(cartPage.isEmptyCart() ,
                "Ürünler Silinemedi.");
        logger.info("Urunler Silindi.");
        Thread.sleep(2000);
    }


}