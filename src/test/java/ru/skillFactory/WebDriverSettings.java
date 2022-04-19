package ru.skillFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

abstract public class WebDriverSettings {
    protected WebDriver webDriver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();//установка chromedriver
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize(); //запуск chrome на весь экран
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(16)); //ждём загрузку страницы 160 секунд
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));  //ждём загрузку всех элементов 160 секунд
        BaseSeleniumPage.setDriver(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.close(); //закрываем chromedriver
        webDriver.quit();  //закрываем браузер
    }
}
