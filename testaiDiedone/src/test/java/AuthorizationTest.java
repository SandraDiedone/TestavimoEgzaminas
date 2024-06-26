import org.example.DashboardPage;
import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertNotEquals;


public class AuthorizationTest {
    WebDriver driver;
    DashboardPage dashboardPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/skaiciuotuvas");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test(priority = 2)
    public void authorizationTestNegative() {
        driver.get("http://localhost:8080/skaiciuotuvas");
        assertNotEquals(driver.getCurrentUrl(), "http://localhost:8080/skaiciuotuvas");
        System.out.println(driver.getCurrentUrl());


    }

    @Test(priority = 1)
    public void authorizationTest() {
        loginPage.setUsername("sandra");
        loginPage.setPassword("sandra123");
        loginPage.clickLoginButton();
        dashboardPage.setFirstNumber("1");
        dashboardPage.setSecondNumber("2");
        dashboardPage.setSelectField();
        dashboardPage.clickAdditionField();
        dashboardPage.clickCount();
        driver.get("http://localhost:8080/skaiciuotuvas");
        String str1 = "Logout, sandra";
        String str2 = dashboardPage.clickLogout();
        Assert.assertEquals(str2, str1, "Nesutampa");
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
