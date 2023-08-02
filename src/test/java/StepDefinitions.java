import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    public Platform platform;

    @Before
    public void init() {
        platform = new Platform();
    }

    @After
    public void tearDown() {
        platform.getDriver().quit();
    }

    @And("user opens AMS website")
    public void openUrl() {
        platform.hitURL("http://127.0.0.1:8000/auth/login/");
    }

    @When ("^user enters username (.*) and password (.*)$")
    public void login(String userName, String password) {
        platform.loginUsingUsernameAndPassword(userName, password);
    }

    @And ("user clicks on login button")
    public void clickLogin(){
        platform.clickOnLoginButton();
    }

    @Then ("user should be redirected to courses page")
    public void validateRedirectedPage(){
        platform.validatePageTitle("Courses Taught");
    }


    @Then ("user validates Invalid credentials error message")
    public  void validateMessage() {
        platform.validateErrorInvalidMsg("These credentials do not match our records!");
    }

//    @Then ("user validates empty fields errror message")
//
    @And ("user clicks on logout button")
    public void clickLogout(){
        platform.clickOnLogoutButton();
    }

    @Then ("user should be on the login page")
    public void validateLoginPageUrl(){
        platform.validateCurrentUrl("http://127.0.0.1:8000/auth/login/");
    }

    @And ("user clicks on browser back button")
    public void clickBackButton(){
        platform.navigateBack();
    }


    @And ("user spam clicks on login button")
    public void spamLogin(){
        platform.clickOnLoginButton();
        platform.clickOnLoginButton();
        platform.clickOnLoginButton();
        platform.clickOnLoginButton();
        platform.clickOnLoginButton();
        platform.clickOnLoginButton();

    }
    @When ("user signs into the AMS application and clicks on Profile tab in navbar")
    public void getProfilePage() {
        platform.loginUsingUsernameAndPassword("Badstriker7", "ggmunited12");
        platform.clickOnLoginButton();
        platform.clickOnProfileTab();
    }


    @Then ("user should land on Profile page")
    public void validateProfilePageUrl(){
        platform.validateCurrentUrl("http://127.0.0.1:8000/attendance/profile/");
    }


    @Then ("user's profile photo should be displayed")
    public void validateDisplayedProfile(){
        platform.validateProfilePhoto();
    }

    @And ("user clicks on remove button")
    public void clickOnRemovePhoto(){
        platform.clickRemove();
    }

    @Then ("user's profile photo should be replaced with default one")
    public void validateReplacedPhoto(){
        platform.validateDefaultProfile();

    }
    @And ("user clicks on edit profile button")
    public void clickOnEditProfile(){
        platform.clickEditButton();


    }
    @Then ("user lands of edit profile form page")
    public void validateEditProfile(){
        platform.validateCurrentUrl("http://127.0.0.1:8000/attendance/edit-profile/");
    }
    @Then ("^user's information <userName>, <fullName>, <gender>, <address>, <primaryNumber> and <secondaryNumber> should be displayed$")
    public void validateDisplayedUserInfo(){

    }

    @And ("user clicks on submit button")
    public void clickOnSaveButton(){
        platform.clickSaveProfile();
    }

    @And ("^user should change (.*), (.*), (.*) and (.*) with valid data in each enabled required fields$")
    public void changeUserInfo(String email, String address, String primaryNumber, String secondaryNumber ){
        platform.typeEmail(email);
        platform.typeAddress(address);
        platform.typePNum(primaryNumber);
        platform.typeSNum(secondaryNumber);
    }

    @When ("user signs into the AMS application with valid credentials")
    public void getCoursesPage(){
        platform.loginUsingUsernameAndPassword("Badstriker7", "ggmunited12");
        platform.clickOnLoginButton();
        platform.validateCurrentUrl("http://127.0.0.1:8000/attendance/logged-in/");
    }

    @Then ("^user's (.*) courses (.*) are displayed in courses page$")
    public void validateDisplayedCourses(String courseId, String courseTitle){
        platform.validateUserCourses(courseId, courseTitle);
    }

    @And("user clicks on take attendance button of a course")
    public void clickOnAttendance(){
        platform.clickTakeAttendance("1");
    }

    @And ("user clicks on today's date in the calendar page")
    public void clickOnTodayButton(){
        platform.clickTodayDate();
    }

    @And("user select attendance status for all students and submit")
    public void submitAttendStatus(){
        platform.clickAttendStat();
        platform.clickSubmit();
    }
    }
