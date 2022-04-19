package ru.skillFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSeleniumPage {

    //поле логина
    @FindBy(xpath = "//*[@id=\"login-email\"]")
    private WebElement loginField;

    //поле пароля
    @FindBy(xpath = "//*[@id=\"login-password\"]")
    private WebElement passwordField;

    //поле сообщения об ошибке
    @FindBy(className = "message-title")
    private WebElement messageTitle;

    //инициализация элементов
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //ввод логина/пароля и возвращение страницы личного кабинета
    public PersonalAccountPage auth(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password, Keys.ENTER);
        return new PersonalAccountPage();
    }

    //ввод неверных логина/пароля и возвращение текущей страницы
    public LoginPage failAuth(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password, Keys.ENTER);
        return new LoginPage();
    }

    //вывод сообщения об ошибки
    public String getMessageTitle() {
        return messageTitle.getText();
    }

}
