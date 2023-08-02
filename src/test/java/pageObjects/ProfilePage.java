package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.eo.Se;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    public String tabProfile = "//a[text()='Profile']";
    public String profilePhoto = "//img[@alt='profile']";
    public String buttonRemove = "//button[text()='Remove']";
    public String buttonEditProfile = "//button[text()='Edit Profile']";
    public String inputEmail = "//input[@type='email']";
    public String inputPNum = "//input[@name=\"primary_number\"]";
    public String inputSNum = "//input[@name=\"secondary_number\"]";
    public String inputAddress = "//input[@name='address']";
    public String buttonSave = "//button[text()='Submit']";


    public SelenideElement getProfile() { return $x(tabProfile);}
    public SelenideElement getPhoto(){return $x(profilePhoto);}

    public SelenideElement getRemoveButton(){return $x(buttonRemove);}

    public SelenideElement getEditProfile(){
        return $x(buttonEditProfile);
    }
    public SelenideElement getEmailBox(){
        return $x(inputEmail);
    }
    public SelenideElement getPNumBox(){
        return $x(inputPNum);
    }

    public SelenideElement getSNumBox(){
        return $x(inputSNum);
    }
    public SelenideElement getAddressBox(){
        return $x(inputAddress);
    }
    public SelenideElement getSaveButton() {
        return $x(buttonSave);
    }
}
