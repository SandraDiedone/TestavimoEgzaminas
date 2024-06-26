package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // Elementai
    @FindBy(xpath = "/html/body/div/form/div/input[1]")
    WebElement usernameField;
    @FindBy(xpath = "/html/body/div/form/div/input[2]")
    WebElement passwordField;
    @FindBy(xpath = "/html/body/div/form/div/button")
    WebElement loginButton;
    @FindBy(xpath = "/html/body/div/form/div/span[2]")
    WebElement loginErrorMessage;

    // Konstruktor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Veiksmai
    public void setUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String setLoginErrorMessage() {
        String message  = loginErrorMessage.getText();
        return message;

    }

}
