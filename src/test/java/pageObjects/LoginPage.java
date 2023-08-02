package pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginPage {
    public String inputUsername = "//input[@name='username']";
    public String inputPassword = "//input[@name='password']";
    public String buttonLogin = "//input[@value='Login']";

    public String checkBoxRememberMe = "";
    public String linkReset = "";
    public String pageTitle ="";
    public String textInvalidMsg = "//p[text()='%s']";

    public SelenideElement getUserName() {
        return $x(inputUsername);
    }

    public SelenideElement getPassword() {

        return $x(inputPassword);
    }

    public SelenideElement getLoginButton() {
        return $x(buttonLogin);
    }

    public SelenideElement getErrorMessage(String title) {
        return $x(textInvalidMsg.replace("%s", title));
    }

    public SelenideElement getPageUrl(){ return $x(getWebDriver().getCurrentUrl());}

}
