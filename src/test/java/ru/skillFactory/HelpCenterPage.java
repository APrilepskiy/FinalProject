package ru.skillFactory;

import org.openqa.selenium.support.PageFactory;

public class HelpCenterPage extends BaseSeleniumPage{

    //инициализация
    public HelpCenterPage() {
        driver.get("https://forms.yandex.ru/cloud/5c5a843f6b6a50004cde4563/?from_connect=1");
        PageFactory.initElements(driver, this);
    }

    //название страницы
    public String getTitlePage() {
        return driver.getTitle();
    }
}
