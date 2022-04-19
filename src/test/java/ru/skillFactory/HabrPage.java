package ru.skillFactory;

import org.openqa.selenium.support.PageFactory;

public class HabrPage extends BaseSeleniumPage{

    //инициализация
    public HabrPage() {
        driver.get("https://habr.com/ru/users/skillfactory_school/");
        PageFactory.initElements(driver, this);
    }

    //название страницы
    public String getTitlePage() {
        return driver.getTitle();
    }

}
