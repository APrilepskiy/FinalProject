package ru.skillFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {
    //строка поиска на главной странице
    @FindBy(xpath = "//*[@id=\"main\"]/section/header/div[2]/div/div[2]/form/label/input")
    private WebElement searchBarElement;

    //кнопка поиска на главной странице
    @FindBy(xpath = "//*[@id=\"main\"]/section/header/div[2]/div/div[2]/form/button")
    private WebElement searchBarButtonElement;

    //кнопка "регистрация" на главной странице
    @FindBy(xpath = "/html/body/div[1]/div[2]/header/div[1]/nav/div[2]/div/div[1]/a")
    private WebElement registrationButtonElement;

    //кнопка "вход" на главной странице
    @FindBy(xpath = "/html/body/div[1]/div[2]/header/div[1]/nav/div[2]/div/div[2]/a")
    private WebElement enterButtonElement;

    //кнопка "просмотреть курсы" на главной странице
    @FindBy(xpath = "/html/body/div[1]/div[2]/header/div[1]/nav/div[1]/div/a")
    private WebElement viewCoursesButtonElement;

    //кнопка "посмотреть все курсы" на главной странице
    @FindBy(xpath = "//*[@id=\"main\"]/section/section/section/div/a")
    private WebElement viewAllCoursesElement;

    //кнопка 'help center' в футоре
    @FindBy(xpath = "//*[@id=\"footer-openedx\"]/ul/li[1]/a")
    private WebElement helpCenterButton;

    //кнопка 'пользовательское соглашение' в футоре
    @FindBy(xpath = "//*[@id=\"footer-openedx\"]/ul/li[3]/a")
    private WebElement userAgreementButton;

    //кнопка "яндекс дзен" в футоре
    @FindBy(xpath = "//*[@id=\"footer-openedx\"]/div/ul/li[1]/a")
    private WebElement dzenButton;

    //кнопка "политика конфеденциальности"
    @FindBy(xpath = "//*[@id=\"footer-openedx\"]/ul/li[2]/a")
    private WebElement privacyPolicyButton;

    //кнопка "хабр"
    @FindBy(xpath = "//*[@id=\"footer-openedx\"]/div/ul/li[2]/a")
    private WebElement habrButton;

    //переход на главную страницу и инициализация элементов
    public MainPage() {
        driver.get("https://lms.skillfactory.ru/");
        PageFactory.initElements(driver, this);
    }

    //метод для нажатия на кнопку "яндекс дзен"
    public DzenPage openDzenPage() {
        dzenButton.click();
        return new DzenPage();
    }

    //метод для нажатия на кнопку "хабр"
    public HabrPage openHabrPage() {
        habrButton.click();
        return new HabrPage();
    }

    //метод для нажатия на кнопку "help center"
    public HelpCenterPage openHelpCenterPage() {
        helpCenterButton.click();
        return new HelpCenterPage();
    }

    //метод для нажатия на кнопку "пользовательское соглашение"
    public UserAgreementPage openUserAgreementPage() {
        userAgreementButton.click();
        return new UserAgreementPage();
    }

    //метод для нажатия на кнопку "политика конфеденциальности" (возвращает страницу UserAgreementPage)
    public UserAgreementPage openPrivacyPolicyPage() {
        privacyPolicyButton.click();
        return new UserAgreementPage();
    }

    //метод для поиска курса
    public CoursesPage findCourse (String titleCourse) {
        searchBarElement.click();
        searchBarElement.sendKeys(titleCourse);
        searchBarButtonElement.click();
        return new CoursesPage();
    }

    //метод для открытия страницы входа
    public LoginPage openLoginPage() {
        enterButtonElement.click();
        return new LoginPage();
    }

    //метод для откытия страницы регистрации
    public RegistrationPage openRegistrationPage() {
        registrationButtonElement.click();
        return new RegistrationPage();
    }

    //метод для нажатия на кнопку "просмотреть курсы" на главной странице
    public CoursesPage openViewCourses() {
        viewCoursesButtonElement.click();
        return new CoursesPage();
    }

    //метод для нажатия на кнопку "посмотреть все курсы"
    public CoursesPage openViewAllCourses() {
        viewAllCoursesElement.click();
        return new CoursesPage();
    }

}
