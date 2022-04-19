package application.Poster;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Connection {

    public void connectFacebook(FirefoxDriver driver, Values values) throws InterruptedException {
        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys(values.getLogin());
        WebElement element = driver.findElement(By.name("pass"));
        element.sendKeys(values.getPassword());
        element.submit();
        Thread.sleep(2000);
    }

    public void closeConnection(FirefoxDriver driver){
        driver.quit();
    }
}
