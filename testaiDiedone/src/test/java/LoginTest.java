import org.example.DashboardPage;
import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/prisijungti");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test(priority = 1)
    public void testLogin() {
        loginPage.setUsername("sandra");
        loginPage.setPassword("sandra123");
        loginPage.clickLoginButton();
        String str1 = "Logout, sandra";
        String str2 = dashboardPage.clickLogout();
        Assert.assertEquals(str2, str1, "Nesutampa");
    }

    @Test(priority = 2)
    public void testLoginNegative() {
        loginPage.setUsername("sandra");
        loginPage.setPassword("sandra");
        loginPage.clickLoginButton();
        String str1 = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";
        String str2 = loginPage.setLoginErrorMessage();
        Assert.assertEquals(str2, str1, "Nesutampa");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}