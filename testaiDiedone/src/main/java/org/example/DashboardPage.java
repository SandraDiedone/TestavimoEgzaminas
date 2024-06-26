package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    WebDriver driver;

    // Elementai
    @FindBy(id = "sk1")
    WebElement firstNumberField;
    @FindBy(xpath = "//*[@id=\"command\"]/p[1]/input")
    WebElement firstNumberFieldForEdit;
    @FindBy(xpath = "//*[@id=\"command\"]/p[3]/input")
    WebElement secondNumberFieldForEdit;
    @FindBy(id = "sk2")
    WebElement secondNumberField;
    @FindBy(xpath = "//*[@id=\"command\"]/p[2]/input")
    WebElement writeSign;
    @FindBy(xpath = "//*[@id=\"command\"]/p[4]/input")
    WebElement result;
    @FindBy(xpath = "/html/body/div/table/tbody/tr[1]/td[2]")
    WebElement idNumber;
    @FindBy(xpath = "//*[@id=\"number\"]/select")
    WebElement selectField;
    @FindBy(xpath = "//*[@id=\"number\"]/select/option[1]")
    WebElement additionField;
    @FindBy(xpath = "//*[@id=\"number\"]/select/option[2]")
    WebElement subtractionField;
    @FindBy(xpath = "//*[@id=\"number\"]/select/option[3]")
    WebElement multiplicationField;
    @FindBy(xpath = "//*[@id=\"number\"]/select/option[4]")
    WebElement divisionField;
    @FindBy(xpath = "//*[@id=\"number\"]/input[3]")
    WebElement countButton;
    @FindBy(xpath = "/html/body/nav/div/ul[2]/a")
    WebElement logoutButton;
    @FindBy(xpath = "/html/body/nav/div/ul[1]/li/a")
    WebElement historyButton;
    @FindBy(xpath = "/html/body/h4")
    WebElement showCountRow;
    @FindBy(xpath = "//*[@id=\"sk2.errors\"]")
    WebElement secondNumberValidationError;

    @FindBy(xpath = "//*[@id=\"sk1.errors\"]")
    WebElement firstNumberValidationError;
    @FindBy(xpath = "//table/tbody/tr[td[contains(text(),'133')] and td[contains(text(),'*')] and td[contains(text(),'3')]] + /td/a[contains(@href, 'trinti')]")
    WebElement deleteButton;
    @FindBy(xpath = "//*[@id=\"command\"]/p[5]/input")
    WebElement refreshButton;

    // Konstruktorius
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Veiksmai
    public void setFirstNumber(String firstNumber) {
        firstNumberField.clear();
        firstNumberField.sendKeys(firstNumber);
    }
    public void setSecondNumber(String secondNumber) {
        secondNumberField.clear();
        secondNumberField.sendKeys(secondNumber);
    }
    public void setFirstNumberForEdit(String firstNumber) {
        firstNumberFieldForEdit.clear();
        firstNumberFieldForEdit.sendKeys(firstNumber);
    }
    public void setSecondNumberForEdit(String secondNumber) {
        secondNumberFieldForEdit.clear();
        secondNumberFieldForEdit.sendKeys(secondNumber);
    }
    public String setIdNumber() {
        String number = idNumber.getText();
        return number;
    }
    public void setWriteSign(String sign) {
        writeSign.clear();
        writeSign.sendKeys(sign);
    }
    public void setResult(String result1) {
        result.clear();
        result.sendKeys(result1);
    }

    public void setSelectField() {
        selectField.click();
    }
    public void setRefreshButton() {
        refreshButton.click();
    }
    public void clickAdditionField() {
        additionField.click();
    }
    public void clickSubtractionField() {
        subtractionField.click();
    }
    public void clickMultiplicationField() {
        multiplicationField.click();
    }
    public void clickDivisionField() {
        divisionField.click();
    }
    public void clickCount() {
        countButton.click();
    }
    public void clickDeleteButton() {
        deleteButton.click();
    }
    public void clickHistoryButton() {
        historyButton.click();
    }
    public String clickLogout() {
        String buttonText = logoutButton.getText();
        return buttonText;
    }
    public String setShowCountRow() {
        String row = showCountRow.getText();
        return row;
    }
    public String setFirstNumberValidationError() {
        String message = firstNumberValidationError.getText();
        return message;
    }
    public String setSecondNumberValidationError() {
        String message = secondNumberValidationError.getText();
        return message;
    }
}

