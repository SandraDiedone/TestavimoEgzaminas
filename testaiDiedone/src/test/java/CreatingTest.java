import org.example.DashboardPage;
import org.example.LoginPage;
import org.example.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreatingTest {
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

    @Test(priority = 1)
    public void countSomething() throws InterruptedException {
        loginPage.setUsername("sandra");
        loginPage.setPassword("sandra123");
        loginPage.clickLoginButton();
        dashboardPage.setFirstNumber("1");
        dashboardPage.setSecondNumber("2");
        dashboardPage.setSelectField();
        dashboardPage.clickAdditionField();
        dashboardPage.clickCount();
        Thread.sleep(5000);
        String str1 = "1 + 2 = 3";
        String str2 = dashboardPage.setShowCountRow();
        Assert.assertEquals(str2, str1, "Nesutampa");

        Thread.sleep(5000);
        driver.get("http://localhost:8080/skaiciuotuvas");
        Thread.sleep(5000);
        dashboardPage.setFirstNumber("10");
        dashboardPage.setSecondNumber("2");
        dashboardPage.setSelectField();
        dashboardPage.clickMultiplicationField();
        dashboardPage.clickCount();
        Thread.sleep(5000);
        String str3 = "10 * 2 = 20";
        String str4 = dashboardPage.setShowCountRow();
        Assert.assertEquals(str3, str4, "Nesutampa");

        Thread.sleep(5000);
        driver.get("http://localhost:8080/skaiciuotuvas");
        Thread.sleep(5000);
        dashboardPage.setFirstNumber("101");
        dashboardPage.setSecondNumber("2");
        dashboardPage.setSelectField();
        dashboardPage.clickSubtractionField();
        dashboardPage.clickCount();
        Thread.sleep(5000);
        String str5 = "101 - 2 = 99";
        String str6 = dashboardPage.setShowCountRow();
        Assert.assertEquals(str6, str5, "Nesutampa");

        Thread.sleep(5000);
        driver.get("http://localhost:8080/skaiciuotuvas");
        Thread.sleep(5000);
        dashboardPage.setFirstNumber("10");
        dashboardPage.setSecondNumber("2");
        dashboardPage.setSelectField();
        dashboardPage.clickDivisionField();
        dashboardPage.clickCount();
        Thread.sleep(5000);
        String str7 = "10 / 2 = 5";
        String str8 = dashboardPage.setShowCountRow();
        Assert.assertEquals(str8, str7, "Nesutampa");
    }

    @Test(priority = 2)
    public void countSomethingNegative() throws InterruptedException {
        loginPage.setUsername("sandra");
        loginPage.setPassword("sandra123");
        loginPage.clickLoginButton();
        dashboardPage.setFirstNumber("1");
        dashboardPage.setSecondNumber("-2");
        dashboardPage.setSelectField();
        dashboardPage.clickAdditionField();
        dashboardPage.clickCount();
        Thread.sleep(5000);
        String str1 = "Validacijos klaida: skaičius negali būti neigiamas";
        String str2 = dashboardPage.setSecondNumberValidationError();
        Assert.assertEquals(str2, str1, "Nesutampa");

        driver.get("http://localhost:8080/skaiciuotuvas");
        dashboardPage.setFirstNumber("");
        dashboardPage.setSecondNumber("2");
        dashboardPage.setSelectField();
        dashboardPage.clickAdditionField();
        dashboardPage.clickCount();
        Thread.sleep(5000);
        String str3 = "Failed to convert property value of type java.lang.String to required type int for property sk1; nested exception is java.lang.NumberFormatException: For input string: \"\"";
        String str4 = dashboardPage.setFirstNumberValidationError();
        Assert.assertEquals(str4, str3, "Nesutampa");
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
