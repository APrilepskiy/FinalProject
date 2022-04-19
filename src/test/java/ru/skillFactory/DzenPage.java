package ru.skillFactory;

import org.openqa.selenium.support.PageFactory;

public class DzenPage extends BaseSeleniumPage{

    //инициализация
    public DzenPage() {
        driver.get("https://zen.yandex.ru/skillfactory");
        PageFactory.initElements(driver, this);
    }

    //название страницы
    public String getTitlePage() {
        return driver.getTitle();
    }
}
