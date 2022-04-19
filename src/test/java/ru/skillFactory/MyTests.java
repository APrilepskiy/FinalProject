package ru.skillFactory;

import org.junit.Assert;
import org.junit.Test;
import static ru.skillFactory.TestValues.*;

public class MyTests extends WebDriverSettings{

    //поиск курса QAJA на главной странице (позитивный тест)
    @Test
    public void checkSearchBarQAJA() {
        MainPage mainPage = new MainPage();
        CoursesPage findPage = mainPage.findCourse(nameOfCourse);
        //проверяем, что на странице есть название курса из поиска
        Assert.assertTrue(findPage.getTextTitleOfCourseQAJA().contains(nameOfCourse));
    }

    //вход на страницу (позитивный тест)
    @Test
    public void checkAuth() {
        MainPage mainPage = new MainPage();
        PersonalAccountPage openLoginPage = mainPage.openLoginPage().
                auth(loginForTest, passwordForTest);
        //проверяем, что имя пользователя страницы совпадает с ожидаемым
        Assert.assertEquals(openLoginPage.getMyName(), userName);
    }

    //переход на страницу курсов из личного кабинета (позитивный тест)
    @Test
    public void checkShowCoursers() {
        MainPage mainPage = new MainPage();
        PersonalAccountPage personalAccountPage = mainPage.
                openLoginPage().
                auth(loginForTest, passwordForTest).
                showMyCourses();
        //проверяем, что title страницы совпадает с ожидаемым
        Assert.assertEquals(personalAccountPage.getTitlePage(), personalAccountTitlePage);
    }

    //переход (открытие) на страницу "курсы" через кнопку "просмотреть курсы" (позитивный тест)
    @Test
    public void openCourses() {
        MainPage mainPage = new MainPage();
        CoursesPage coursesPage = mainPage.openViewCourses();
        //проверяем, что title страницы совпадает с ожидаемым
        Assert.assertEquals(coursesPage.getTitlePage(), courseTitlePage);
    }

    //переход (открытие) на страницу "курсы" через кнопку "посмотреть все курсы" (позитивный тест)
    @Test
    public void openAllCourses() {
        MainPage mainPage = new MainPage();
        CoursesPage coursesPage = mainPage.openViewAllCourses();
        //проверяем, что title страницы совпадает с ожидаемым
        Assert.assertEquals(coursesPage.getTitlePage(), courseTitlePage);
    }

    //переход на страницу помощи в футоре
    @Test
    public void openHelpPage() {
        MainPage mainPage = new MainPage();
        HelpCenterPage helpCenterPage = mainPage.openHelpCenterPage();
        //проверяем, что title страницы совпадает с ожидаемым
        Assert.assertEquals(helpCenterPage.getTitlePage(), helpCenterTitlePage);
    }

    //переход на страницу пользовательского соглашения в футоре
    @Test
    public void openUserAgreementPage() {
        MainPage mainPage = new MainPage();
        UserAgreementPage userAgreementPage = mainPage.openUserAgreementPage();
        //проверяем, что title страницы совпадает с ожидаемым
        Assert.assertEquals(userAgreementPage.getTitlePage(), userAgreementTitlePage);
    }

    //переход на страницу пользовательснокго соглашения через кнопку "политика конфеденциальности"
    @Test
    public void openPrivacyPolicePage() {
        MainPage mainPage = new MainPage();
        UserAgreementPage userAgreementPage = mainPage.openPrivacyPolicyPage();
        //проверяем, что title страницы совпадает с ожидаемым
        Assert.assertEquals(userAgreementPage.getTitlePage(), userAgreementTitlePage);
    }

    //переход на страницу "яндекс дзен" в футоре
    @Test
    public void openDzenPage() {
        MainPage mainPage = new MainPage();
        DzenPage dzenPage = mainPage.openDzenPage();
        //проверяем, что title страницы совпадает с ожидаемым
        Assert.assertEquals(dzenTitlePage, dzenPage.getTitlePage());
    }

    //переход на страницу "хабр"
    @Test
    public void openHabrPage() {
        MainPage mainPage = new MainPage();
        HabrPage habrPage = mainPage.openHabrPage();
        //проверяем, что title страницы совпадает с ожидаемым
        Assert.assertEquals(habrPage.getTitlePage(), habrTitlePage);
    }

    //переход на страницу "регистрация"
    @Test
    public void openRegistrationPage() {
        MainPage mainPage = new MainPage();
        RegistrationPage registrationPage = mainPage.openRegistrationPage();
        //проверяем, что title страницы совпадает с ожидаемым
        Assert.assertEquals(registrationPage.getTitlePage(), regisrationTitlePage);
    }

    //предача в поиск названия несуществуещего курса (негативный тест)
    @Test
    public void checkSearchBarFailNameOfCourse() {
        MainPage mainPage = new MainPage();
        CoursesPage findCourse = mainPage.findCourse(failNameOfCourse);
        //проверяем, что курса с таким названием нет
        Assert.assertFalse(findCourse.getTextCourseTitle().contains(failNameOfCourse));
    }

    //вход на страницу с неверными данными (негативный тест)
    @Test
    public void checkFailAuth() {
        MainPage mainPage = new MainPage();
        LoginPage openLoginPage = mainPage.openLoginPage().
                failAuth(badLoginName,badPassword);
        //проверяем, что появилось сообщение об ошибке
        Assert.assertEquals(openLoginPage.getMessageTitle(), failAuthMessage);
    }

    //создание новой УЗ с неверными данными (негативный тест)
    @Test
    public void checkFailRegistration() {
        MainPage mainPage = new MainPage();
        RegistrationPage openRegistrationPage = mainPage.
                openRegistrationPage().
                failRegistration(emailForRegistration, fullNameForTest, userNameForTest, passwordForRegistration);
        //проверсяем, что появилось сообщение об ошибке
        Assert.assertEquals(openRegistrationPage.getMessageTitle(), failRegistrationMessage);
    }

    //ввод некорректного пароля при регистрации (негативный тест)
    @Test
    public void checkFailMailRegistration() {
        MainPage mainPage = new MainPage();
        RegistrationPage enterFailMailRegistration = mainPage.
                openRegistrationPage().
                failRegistrationMail(emailForRegistration);
        //проверяем, что появилось сообщение об ошибке
        Assert.assertEquals(enterFailMailRegistration.getMessageTitle(), failRegistrationMessage);
    }

    //ввод некорректного пароля при регистрации (негативный тест)
    @Test
    public void checkFailPasswordRegistration() {
        MainPage mainPage = new MainPage();
        RegistrationPage failPassword = mainPage.
                openRegistrationPage().
                failRegistrationPassword(badPassword);
        //проверяем, что появилось сообщение об ошибке
        Assert.assertEquals(failPassword.getMessageTitle(), failRegistrationMessage);
    }

    //заполняем только одно обязательное поле "полное имя"
    @Test
    public void oneFeildCheckFullName() {
        MainPage mainPage = new MainPage();
        RegistrationPage oneFieldChech = mainPage.
                openRegistrationPage().
                oneFieldFullName(fullNameForTest);
        //проверяем, что появилось сообщение об ошибке
        Assert.assertEquals(oneFieldChech.getMessageTitle(), failRegistrationMessage);
    }

    //заполняем только одно обязательное поле "имя пользователя"
    @Test
    public void oneFieldCheckUserName() {
        MainPage mainPage = new MainPage();
        RegistrationPage oneFiledCheck = mainPage.
                openRegistrationPage().
                oneFieldUserName(userNameForTest);
        //проверяем, что появилось сообщение об ошибке
        Assert.assertEquals(oneFiledCheck.getMessageTitle(), failRegistrationMessage);
    }

}
