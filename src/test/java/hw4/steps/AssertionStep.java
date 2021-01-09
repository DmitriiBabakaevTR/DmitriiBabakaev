package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionStep extends AbstractStep{
    public AssertionStep(WebDriver driver, SoftAssert soft) {
        super(driver,soft);
    }

    @Step("Проверка URL и заголовка сайта")
    public void verifyHomePageURLAndTitle(){
        Assert.assertEquals(homePage.getURL(), "https://jdi-testing.github.io/jdi-light/index.html", "Wrong URL!");
        Assert.assertEquals(homePage.getTitle(), "Home Page", "Wrong title!");
    }

    @Step("Проверка успешности логина")
    public void verifyLoggIn(){
        Assert.assertEquals(homePage.getHeaderPageElements().getUserNameText().getText(), "ROMAN IOVLEV", "Invalid user!");
    }

    @Step("Проверка наличия четырех элементов на верхней панели")
    public void verifyHeaderElementsAreDisplayed(){
        soft.assertTrue(homePage.getHeaderPageElements().getHomeItem().isDisplayed(), "Element 'Home' is not displayed!");
        soft.assertTrue(homePage.getHeaderPageElements().getContactFormItem().isDisplayed(), "Element 'Contact form' is not displayed!");
        soft.assertTrue(homePage.getHeaderPageElements().getServiceItem().isDisplayed(), "Element 'Service' is not displayed!");
        soft.assertTrue(homePage.getHeaderPageElements().getMetalsColorsItem().isDisplayed(), "Element 'Metals & Colors' is not displayed!");
    }

    @Step("Проверка корректности текста четырех элементов на верхней панели")
    public void verifyHeaderElementsText(){
        soft.assertEquals(homePage.getHeaderPageElements().getHomeItem().getText(),"HOMEE", "Invalid text on button 'Home'!");
        soft.assertEquals(homePage.getHeaderPageElements().getContactFormItem().getText(),"CONTACT FORM", "Invalid text on button 'Contact form'!");
        soft.assertEquals(homePage.getHeaderPageElements().getServiceItem().getText(),"SERVICE", "Invalid text on button 'Service'!");
        soft.assertEquals(homePage.getHeaderPageElements().getMetalsColorsItem().getText(),"METALS & COLORS", "Invalid text on button 'Metals & Colors'!");
    }

    @Step("Проверка наличия четырех картинок на Index Page")
    public void verifyImagesAreDisplayedOnTheIndexPage(){
        soft.assertTrue(homePage.getIndexPageImagesWithTextPageElement().getMicroscopeImage().isDisplayed(), "Microscope image is not displayed!");
        soft.assertTrue(homePage.getIndexPageImagesWithTextPageElement().getHeadphonesImage().isDisplayed(), "Headphones image is not displayed!");
        soft.assertTrue(homePage.getIndexPageImagesWithTextPageElement().getMonitorImage().isDisplayed(), "Monitor image is not displayed!");
        soft.assertTrue(homePage.getIndexPageImagesWithTextPageElement().getRocketImage().isDisplayed(), "Rocket image is not displayed!");
    }

    @Step("Проверка корректности текста под каждой из четырех картинок")
    public void verifyImagesOnTheIndexPageText(){
        soft.assertEquals(homePage.getIndexPageImagesWithTextPageElement().getMicroscopeText().getText(),"To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project", "Invalid text under microscope image!");
        soft.assertEquals(homePage.getIndexPageImagesWithTextPageElement().getHeadphonesText().getText(),"To be flexible and\n" +
                "customizable", "Invalid text under headphones image!");
        soft.assertEquals(homePage.getIndexPageImagesWithTextPageElement().getMonitorText().getText(), "To be multiplatform", "Invalid text under monitor image!");
        soft.assertEquals(homePage.getIndexPageImagesWithTextPageElement().getRocketText().getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…", "Invalid text under rocket image!");
    }

    @Step("Проверка наличия фрэйма с кнопкой “Frame Button” на Index Page")
    public void verifyIframeExist(){
        soft.assertTrue(homePage.getIframe().isDisplayed(), "Valid iframe is not displayed!");
    }

    @Step("Проверка наличия кнопки “Frame Button” внутри фрейма")
    public void verifyFrameButtonExist(){
        soft.assertTrue(homePage.getFrameButton().isDisplayed(), "Frame Button is not displayed!");
    }

    @Step("Проверка фокуса на главном окне")
    public void verifyFocusOnOriginalWindow(){
        soft.assertTrue(homePage.getTextToCheckFocus().isDisplayed(), "You are not focused on the original window!");
    }

    @Step("Проверка наличия пяти элементов на левой панели")
    public void verifyLeftElementsAreDisplayed(){
        soft.assertTrue(homePage.getLeftSideMenuElement().getHomeLeftElement().isDisplayed(), "Left element 'Home' is not displayed!");
        soft.assertTrue(homePage.getLeftSideMenuElement().getContactFormLeftElement().isDisplayed(), "Left element 'Contact form' is not displayed!");
        soft.assertTrue(homePage.getLeftSideMenuElement().getServiceLeftElement().isDisplayed(), "Left element 'Service' is not displayed!");
        soft.assertTrue(homePage.getLeftSideMenuElement().getMetalsColorsLeftElement().isDisplayed(), "Left element 'Metals & Colors' is not displayed!");
        soft.assertTrue(homePage.getLeftSideMenuElement().getElementsPacksLeftElement().isDisplayed(), "Left element 'Elements packs' is not displayed!");
    }

    @Step("Проверка корректности текста элементов на левой панели")
    public void verifyLeftElementsText(){
        soft.assertEquals(homePage.getLeftSideMenuElement().getHomeLeftElement().getText(), "Home", "Invalid text on left button 'Home'!");
        soft.assertEquals(homePage.getLeftSideMenuElement().getContactFormLeftElement().getText(), "Contact form", "Invalid text on left button 'Contact form'!");
        soft.assertEquals(homePage.getLeftSideMenuElement().getServiceLeftElement().getText(), "Service", "Invalid text on left button 'Service'!");
        soft.assertEquals(homePage.getLeftSideMenuElement().getMetalsColorsLeftElement().getText(), "Metals & Colors", "Invalid text on left button 'Metals & Colors'!");
        soft.assertEquals(homePage.getLeftSideMenuElement().getElementsPacksLeftElement().getText(), "Elements packs", "Invalid text on left button 'Elements packs'!");
    }

    @Step("Проверка URL сайта")
    public void verifyDifferentElementsPageURL() {
        Assert.assertEquals(differentElementsPage.getURL(), "https://jdi-testing.github.io/jdi-light/different-elements.html", "Wrong URL!");
    }

    @Step("Проверка, что чекбосы 'Water' и 'Wind' выбраны")
    public void verifyCheckboxesAreSelected(){
        soft.assertTrue(differentElementsPage.getWaterCheckbox().isSelected(),"Checkbox 'Water' is not selected!");
        soft.assertTrue(differentElementsPage.getWindCheckbox().isSelected(),"Checkbox 'Wind' is not selected!");
    }

    @Step("Проверка, что радио-кнопка 'Selen' выбрана")
    public void verifyRadioButtonIsSelected(){
        soft.assertTrue(differentElementsPage.getRadioSelen().isSelected(),"Radio 'Selen' is not selected!");
    }

    @Step("Проверка, что выбран нужный цвет")
    public void verifyYellowColorIsSelected(){
        soft.assertTrue(differentElementsPage.getYellowColor().isDisplayed(),"Yellow color is not selected!");
    }

    @Step("Проверка наличия индивидуальных логов для чекбоксов и их значений")
    public void verifyCheckboxesLogsAndItsStatus(){
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getWaterLog().isDisplayed(),"The Water checkbox log is not displayed!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getWaterLog().getText().contains("true"),"The Water checkbox log has invalid value!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getWindLog().isDisplayed(),"The Wind checkbox log is not displayed!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getWindLog().getText().contains("true"),"The Wind checkbox log has invalid value!");
    }

    @Step("Проверка наличия индивидуального лога для радио-кнопки и его значения")
    public void verifyRadioButtonLogAndItsStatus(){
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getMetalRadioLog().isDisplayed(),"The metal radio button log is not displayed!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getMetalRadioLog().getText().contains("Selen"),"The metal radio button log has invalid value!");
    }

    @Step("Проверка наличия индивидуального лога для выпадающего списка и его значения")
    public void verifyDropDownLogAndItsStatus(){
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getColorsLog().isDisplayed(),"The Colors dropdown log is not displayed!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getColorsLog().getText().contains("Yellow"),"The Colors dropdown log has invalid value!");
    }
}