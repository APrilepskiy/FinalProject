package ru.skillFactory;

import org.openqa.selenium.support.PageFactory;

public class UserAgreementPage extends BaseSeleniumPage{

    //инициализация
    public UserAgreementPage() {
        driver.get("https://skillfactory.ru/position_of_user_personal_data");
        PageFactory.initElements(driver, this);
    }

    //название страницы
    public String getTitlePage() {
        return driver.getTitle();
    }
}
