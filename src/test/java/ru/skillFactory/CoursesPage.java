package ru.skillFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursesPage extends BaseSeleniumPage{
    //строка поиска на странице курсов
    @FindBy(xpath = "//*[@id=\"discovery-input\"]")
    private WebElement searchBar;

    //поиск курса "Профессия QA-инженер на Java"
    @FindBy(xpath = "//*[@id=\"main\"]/section/section/div[3]/ul[3]/li[1]/article/a/section/h2/span[3]")
    private WebElement titleOfCourse;

    //поиск названия курса по имени класса
    @FindBy(className = "course-title")
    private WebElement courseTitle;

    //инициализация элементов
    public CoursesPage() {
        PageFactory.initElements(driver, this);
    }

    //поиск курса QAVA
    public String getTextTitleOfCourseQAJA() {
        return titleOfCourse.getText();
    }

    //проверка наличия строки из поля поиска в названиях курса
    public String getTextCourseTitle() {
        return courseTitle.getText();
    }

    //название страницы
    public String getTitlePage() {
        return driver.getTitle();
    }

}
