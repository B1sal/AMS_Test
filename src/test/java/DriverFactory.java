import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    public WebDriver createDriver(String driverName){
        switch (driverName.toLowerCase()){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*", "--window-size=1920,1080");
                return new ChromeDriver(options);

            case "firefox":
                return new FirefoxDriver();

            case "ie":
                return  new InternetExplorerDriver();

            case "safari":
                return new SafariDriver();

            default:
                System.out.println("The driver you have entered "+driverName+" is not identified by the system!!!");
                break;
        }
        return null;
    }
}