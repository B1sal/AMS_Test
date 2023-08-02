import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import pageObjects.CoursesPage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Platform {

    private WebDriver driver;
    private Util util;
    private LoginPage loginPage;
    private CoursesPage coursesPage;
    private ProfilePage profilePage;
    private DriverFactory driverFactory;

    public Platform(){
        driverFactory = new DriverFactory();
        driver = driverFactory.createDriver("Chrome");
        if(driver!=null){
            util = new Util();
            loginPage = new LoginPage();
            coursesPage = new CoursesPage();
            profilePage = new ProfilePage();
            WebDriverRunner.setWebDriver(driver);
            Configuration.timeout = 5000;
        }
        else{
            System.out.println("the driver entered is invalid!!!");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void hitURL(String urlValue) {
        driver.get(urlValue);
    }

    public void loginUsingUsernameAndPassword(String loginName, String password) {
        loginPage.getUserName().should(visible, Duration.ofSeconds(5)).sendKeys(loginName);
        loginPage.getPassword().sendKeys(password);
    }

    public void validateCurrentUrl(String expectedUrl){
        String currentUrl = getWebDriver().getCurrentUrl();
        if (currentUrl.equals(expectedUrl)){
            System.out.println("URL validation successful!");
        } else {
            System.out.println("URL validation failed. Expected URL: " + expectedUrl + ", Actual URL: " + loginPage.getPageUrl());
        }
    }

    public void navigateBack(){
        driver.navigate().back();
    }
    public void clickOnLoginButton(){
        loginPage.getLoginButton().should(visible, Duration.ofSeconds(5)).click();
    }
    public void validateProfilePhoto(){
        if (profilePage.getPhoto().isDisplayed()) {
            System.out.println("Profile photo is displayed.");
        } else {
            System.out.println("Profile photo is not displayed.");
        }
    }

    public void validateDefaultProfile(){
        String actualImagePath = profilePage.getPhoto().getAttribute("src");
        String expectedImagePath = "{% static 'images/pp.png' %}";

        if (actualImagePath.equals(expectedImagePath)) {
            System.out.println("Profile photo is removed");
        } else {
            System.out.println("Profile photo is NOT removed");
        }
    }
    public void clickRemove(){
        profilePage.getRemoveButton().click();
    }
    public void clickOnLogoutButton() { coursesPage.getLogOut().should(visible, Duration.ofSeconds(5)).click();}
    public void clickOnProfileTab(){ profilePage.getProfile().should(visible, Duration.ofSeconds(5)).click();}

    public void validatePageTitle(String headText){
        coursesPage.getTitle(headText).shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(text(headText));
    }

    public void validateErrorInvalidMsg(String Message){
        loginPage.getErrorMessage(Message).shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(text(Message));

    }

    public void validateUserCourses(String courseId, String courseTitle) {
        coursesPage.getCourseHeader(courseId).shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(text(courseTitle));
    }

    public void clickTakeAttendance(String courseId){
        coursesPage.getAttendButton(courseId).click();
    }

    public void clickTodayDate(){
        coursesPage.getTodayButton().click();
    }
    public void clickAttendStat(){
        ElementsCollection studentList = coursesPage.getAttendMenu();
        for (int i = 0; i < studentList.size(); i++) {
            // Click on the element
            studentList.get(i).click();
        }
    }

    public void clickSubmit(){
        coursesPage.getSubmitButton().click();
    }

    public void clickEditButton(){
        profilePage.getEditProfile().click();
    }

    public void typeEmail(String emailId){
        profilePage.getEmailBox().sendKeys(emailId);
    }

    public void typePNum(String pNum){
        profilePage.getPNumBox().sendKeys(pNum);
    }
    public void typeSNum(String sNum){
        profilePage.getSNumBox().sendKeys(sNum);
    }
    public void typeAddress(String address){
        profilePage.getAddressBox().sendKeys(address);
    }

    public void clickSaveProfile(){
        profilePage.getSaveButton().click();
    }

    }
