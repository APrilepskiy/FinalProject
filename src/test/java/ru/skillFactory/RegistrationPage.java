package ru.skillFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseSeleniumPage{

    //поле почта
    @FindBy(xpath = "//*[@id=\"register-email\"]")
    private WebElement emailField;

    //поле полное пользователя
    @FindBy(id = "register-name")
    private WebElement fullNameField;

    //поле имя пользователя
    @FindBy(id = "register-username")
    private WebElement userNameField;

    //поле пароль
    @FindBy(id = "register-password")
    private WebElement passwordField;

    //страна Россия
    @FindBy(xpath = "//*[@id=\"register-country\"]/option[171]")
    private WebElement countryRussian;

    //кнопка создать учетную запись
    @FindBy(xpath = "//*[@id=\"register\"]/button")
    private WebElement createButton;

    //поле сообщения об ошибке
    @FindBy(className = "message-title")
    private WebElement messageTitle;

    //инициализация элементов
    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    //ввод неверных тестовых данных и возвращение текущей страницы
    public RegistrationPage failRegistration(String email, String fullName, String userName, String password) {
        emailField.sendKeys(email);
        fullNameField.sendKeys(fullName);
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        countryRussian.click();
        createButton.click();
        return new RegistrationPage();
    }

    //ввод неверной почты
    public RegistrationPage failRegistrationMail(String email) {
        emailField.sendKeys(email, Keys.ENTER);
        return new RegistrationPage();
    }

    //ввод неверного пароля
    public RegistrationPage failRegistrationPassword(String password) {
        passwordField.sendKeys(password, Keys.ENTER);
        return new RegistrationPage();
    }

    //заполнение только одного поля "полное имя"
    public RegistrationPage oneFieldFullName(String fullName) {
        fullNameField.sendKeys(fullName, Keys.ENTER);
        return new RegistrationPage();
    }

    //заполняем только одно поле "имя пользователя"
    public RegistrationPage oneFieldUserName(String userName) {
        userNameField.sendKeys(userName, Keys.ENTER);
        return new RegistrationPage();
    }

    //вывод сообщения об ошибки
    public String getMessageTitle() {
        return messageTitle.getText();
    }

    //название страницы
    public String getTitlePage() {
        return driver.getTitle();
    }

}
