package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;

    // Elementai
    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement usernameField;
    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"passwordConfirm\"]")
    WebElement passwordConfirmField;
    @FindBy(xpath = "//*[@id=\"userForm\"]/button")
    WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"username.errors\"]")
    WebElement usernameErrorMessage;
    @FindBy(xpath = "//*[@id=\"passwordConfirm.errors\"]")
    WebElement passwordErrorMessage;

    // Konstruktorius
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Veiksmai
    public void setUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void setConfirmPassword(String passwordConfirm) {
        passwordConfirmField.sendKeys(passwordConfirm);
    }
    public String setUsernameErrorMessage() {
        String message  = usernameErrorMessage.getText();
        return message;
    }
    public String setPasswordErrorMessage() {
        String message  = passwordErrorMessage.getText();
        return message;
    }
    public void clickLoginButton() {
        loginButton.click();
    }
}

