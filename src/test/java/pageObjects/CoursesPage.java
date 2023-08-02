package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class CoursesPage {
    public String pageTitleText = "//*[text()='%s']";

    public String buttonLogOut = "//a[text()='Log Out']";
    public String courseHeader = "//*[@class='blog_post'][%s]";

    public String buttonAttend = "(//*[@class='blog_post'][%s]//div/descendant::button)[1]";
    public String buttonDate = "//*[@class='today']";
    public String attendDropDown = "//tr[@class='student-col']//td/descendant::select";
    public String statusAttend = "//option[text()=\"Present\"]";
    public String buttonSubmit = "//button[@type=\"submit\"]";

    public SelenideElement getTitle(String headText) {
        return $x(pageTitleText.replace("%s", headText));
    }

    public SelenideElement getLogOut() { return $x(buttonLogOut);}

    public SelenideElement getCourseHeader(String courseId) {
        return $x(courseHeader.replace("%s", courseId));
    }
    public SelenideElement getAttendButton(String courseId) {
        return $x(buttonAttend.replace("%s", courseId));
    }
    public SelenideElement getTodayButton() {
        return $x(buttonDate);
    }
    public ElementsCollection getAttendMenu() {
        return $$x(statusAttend);
    }

    public SelenideElement getSubmitButton(){
        return $x(buttonSubmit);
    }
}
