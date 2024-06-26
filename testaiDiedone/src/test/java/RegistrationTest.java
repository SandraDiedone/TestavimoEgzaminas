
import org.example.DashboardPage;
import org.example.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {
    WebDriver driver;
    RegistrationPage registrationPage;
    DashboardPage dashboardPage = new DashboardPage(driver);

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/registruoti");
        registrationPage = new RegistrationPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test(priority=1)
    public void registrationLoginPositive() throws InterruptedException {
        registrationPage.setUsername("testTest29");
        registrationPage.setPassword("testTest123");
        registrationPage.setConfirmPassword("testTest123");
        registrationPage.clickLoginButton();
        Thread.sleep(5000);
        String str1 = "Logout, testTest28";
        String str2 = dashboardPage.clickLogout();
        Assert.assertEquals(str2, str1, "Nesutampa");
    }
    @Test(priority=2)
    public void registrationLoginUsernameNegative() throws InterruptedException {
        registrationPage.setUsername("testTest29");
        registrationPage.setPassword("testTest123");
        registrationPage.setConfirmPassword("testTest123");
        registrationPage.clickLoginButton();
        Thread.sleep(5000);
        String str11 = "Toks vartotojo vardas jau egzistuoja";
        String str22 = registrationPage.setUsernameErrorMessage();
        Assert.assertEquals(str22, str11, "Nesutampa");
    }

    @Test(priority=3)
    public void registrationLoginPasswordNegative() throws InterruptedException {
        registrationPage.setUsername("testTest30");
        registrationPage.setPassword("testTest123");
        registrationPage.setConfirmPassword("testTest");
        registrationPage.clickLoginButton();
        Thread.sleep(5000);
        String str11 = "Įvesti slaptažodžiai nesutampa";
        String str22 = registrationPage.setPasswordErrorMessage();
        Assert.assertEquals(str22, str11, "Nesutampa");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
