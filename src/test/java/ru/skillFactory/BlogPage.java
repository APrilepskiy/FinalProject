package ru.skillFactory;

import org.openqa.selenium.support.PageFactory;

public class BlogPage extends BaseSeleniumPage{

    //инициализация
    public BlogPage() {
        driver.get("http://blog.skillfactory.ru/");
        PageFactory.initElements(driver, this);
    }

    //название страницы
    public String getTitlePage() {
        return driver.getTitle();
    }

}
