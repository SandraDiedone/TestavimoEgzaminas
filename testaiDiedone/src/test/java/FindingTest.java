import org.example.DashboardPage;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindingTest {
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
    public void findCount() throws InterruptedException {
        loginPage.setUsername("sandra");
        loginPage.setPassword("sandra123");
        loginPage.clickLoginButton();
        dashboardPage.setFirstNumber("100");
        dashboardPage.setSecondNumber("20");
        dashboardPage.setSelectField();
        dashboardPage.clickDivisionField();
        dashboardPage.clickCount();
        Thread.sleep(5000);
        driver.get("http://localhost:8080/skaiciai");
        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement historyTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/table/tbody")));

        List<WebElement> historyRows = historyTable.findElements(By.tagName("tr"));

        // Patikrinimas, ar lentelėje yra bent vienas įrašas
        if (historyRows.size() > 0) {
            // Paskutinio įrašo lentelėje gavimas
            WebElement lastRow = historyRows.get(historyRows.size() - 1);
            // Gaunama paskutinė eilutė
            List<WebElement> cells = lastRow.findElements(By.tagName("td"));
            String number1 = cells.get(0).getText();
            String operation = cells.get(1).getText();
            String number2 = cells.get(2).getText();
            String result = cells.get(3).getText();String expectedText = "100 / 20 = 5";
            String actualText = number1 + " " + operation + " " + number2 + " = " + result;
            Assert.assertEquals(actualText, expectedText, "Įrašai nesutampa");
        } else {
            Assert.fail("Lentelėje įrašų nėra");
        }
    }

    @Test(priority = 2)
    public void findCountNegative() throws InterruptedException {
        loginPage.setUsername("sandra");
        loginPage.setPassword("sandra123");
        loginPage.clickLoginButton();
        dashboardPage.setFirstNumber("1");
        dashboardPage.setSecondNumber("2");
        dashboardPage.setSelectField();
        dashboardPage.clickAdditionField();
        dashboardPage.clickCount();
        Thread.sleep(5000);
        driver.get("http://localhost:8080/skaiciai");
        Thread.sleep(5000);
        String xpathExpression = "//table/tbody/tr[td[contains(text(),'11')] and td[contains(text(),'*')] and td[contains(text(),'-2533')]]";
        List<WebElement> elements = driver.findElements(By.xpath(xpathExpression));
        Assert.assertTrue(elements.isEmpty(), "Įrašas rastas, nors jo neturėtų būti");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

