import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Util {

    public void myImplicitWait(WebDriver driver, int timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }

    }
