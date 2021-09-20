package application.Poster;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.stereotype.Service;

@Service
public class Driver {

    public FirefoxDriver launchDriver() {
        FirefoxOptions opt = new FirefoxOptions();
        opt.setHeadless(true);
        FirefoxDriver driver = new FirefoxDriver(opt);

        return driver;
    }

    public void quitingDriver(FirefoxDriver driver){
        driver.quit();
    }
}
