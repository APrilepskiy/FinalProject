package ru.skillFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalAccountPage extends BaseSeleniumPage {

    //имя пользователя
    @FindBy(xpath = "/html/body/div[1]/div[2]/header/div[1]/div[2]/div[2]/div[2]/a/span[2]")
    private WebElement personalPage;

    //инициализация элементов
    public PersonalAccountPage() {
        PageFactory.initElements(driver, this);
    }

    //поиск списка куросов в личном кабинете пользователя
    public PersonalAccountPage showMyCourses() {
        personalPage.click();
        return new PersonalAccountPage();
    }

    //имя пользователя
    public String getMyName() {
        return personalPage.getText();
    }

    //имя страницы личного кабинета
    public String getTitlePage() {
        return driver.getTitle();
    }
}
