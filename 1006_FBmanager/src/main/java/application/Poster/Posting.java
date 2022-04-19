package application.Poster;

import org.apache.commons.exec.util.StringUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class Posting {

    @Autowired
    Driver FFdriver;
    @Autowired
    private Connection conn;

    private FirefoxDriver driver;
    private List<String> listToPost;
    private String textToPost;
    private String picToPost;
    private String hours;
    private String minutes;
    private int hrs;
    private int min;
    private int count;
    private String dateToPost;
    private Values values;

    public void init(Values valuesIN) throws Exception {
        this.values = valuesIN;
        this.driver = FFdriver.launchDriver();
        this.listToPost = checkFolder(values.getTargetFolder());
        count = 1;
        conn.connectFacebook(driver, values);
        while (!listToPost.isEmpty()) {
            textToPost = getText();
            picToPost = setPic(values.getTargetFolder());
            setTime();
            setDate();
            postRepeat();
            count++;
        }
        conn.closeConnection(driver);
    }

    private void sleeping(int times) throws InterruptedException {
        Thread.sleep(times * 100);
    }

    private void postRepeat() throws InterruptedException {
        try {

            driver.get(values.getTargetUrl());
            sleeping(10);
            driver.findElement(By.cssSelector("div[class*='_3ixn']")).click();
            sleeping(10);
            driver.findElement(By.cssSelector("div[class*='_1mf _1mj']")).click();
            sleeping(10);
            driver.findElement(By.cssSelector("div[data-testid*='photo-video-button']")).click();
            sleeping(10);
            driver.findElement(By.cssSelector("input[type*='file']")).sendKeys(picToPost);
            sleeping(30);
            WebElement currentElement = driver.switchTo().activeElement();
            currentElement.sendKeys(textToPost);
            sleeping(10);


            driver.findElement(By.cssSelector("button[class*='_271k _271l _271m _1qjd _7tvm _7tv2 _7tv4 _p']")).click();
            sleeping(10);
            driver.findElement(By.cssSelector("div[class*='_54nq _57di _558b _2n_z']")).click();

            /*CHANGE DATE*/
            Thread.sleep(5);
            for (int i = 0; i < 9; i++) {
                Thread.sleep(1);
                driver.findElement(By.cssSelector("input[class*='_3smp']")).sendKeys(Keys.BACK_SPACE);
            }
            driver.findElement(By.cssSelector("input[class*='_3smp']")).sendKeys(dateToPost);

            /*CHANGE TIME*/
            driver.findElement(By.cssSelector("input[class*='_4nx5']")).sendKeys(hours);
            driver.findElement(By.cssSelector("div[class*='_4nxe _4nww _5pw0']")).click();
            WebElement currWE = driver.switchTo().activeElement();
            currWE.sendKeys(minutes);

            driver.findElement(By.cssSelector("button[class*='layerConfirm _4jy0 _4jy3 _4jy1 _51sy selected _42ft']")).click();
            sleeping(5);
            try {
                driver.findElement(By.cssSelector("button[class*='_1mf7 _69g1 _4jy0 _4jy3 _4jy1 _51sy selected _42ft']")).click();
            } catch (WebDriverException e) {
                System.out.println("conrrolled error #1: " + e);
            }
            try {
                driver.findElement(By.cssSelector("button[class*='_1mf7 _4jy0 _4jy3 _4jy1 _51sy selected _42ft']")).click();
            } catch (WebDriverException e) {
                System.out.println("controlled error #2: " + e);
            }

        } catch (WebDriverException e) {
            System.out.println("Some shit happened. Post probably didn't worked: " + e);
        }
        deletePic(values.getTargetFolder(), values.getPostedFolder());

    }

    private String setPic(String workingDir) {
        String currPos = workingDir + "/" + listToPost.get(0);
        return currPos;

    }

    private String getText() {
        String filename = listToPost.get(0);
        String parts[] = StringUtils.split(filename, ".");
        String[] tags = parts[0].split("_");
        String text = "<3";
        for (int i = 0; i < tags.length; i++) {
            text += " #" + tags[i];
        }
        return text;
    }

    private void setTime() {
        getTime();
        hours = String.valueOf(hrs);
        minutes = String.valueOf(min);

    }

    private void getTime() {
        if (count == 1) {
            hrs = values.getHours();
            min = values.getMinutes();
            count++;
        } else {
            Random r = new Random();
            int gap = r.nextInt(values.getTimeAmplitude() + 1) + values.getTimeGap();
            min += gap;
            if (min > 60) {
                hrs = hrs + min / 60;
                min = min % 60;
            } else if (min % 60 == 0) {
                hrs += min / 60;
                min = 0;
            }
        }
    }

    private void setDate() {
        if (count == 1) {
            dateToPost = (values.getDayToPost() + "." + values.getMonthToPost() + "." + values.getYearToPost());
        } else if (hrs > 23) {
            int diff = hrs / 24;
            hrs = hrs % 23;
            diff = values.getDayToPost() + diff;
            dateToPost = (diff + "." + values.getMonthToPost() + "." + values.getYearToPost());
        }
    }

    private List<String> checkFolder(String workingDir) {
        List<String> list = new LinkedList<>();
        File directory = new File(workingDir);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                list.add(file.getName());
            } else if (file.isDirectory()) {
                System.out.println("YES PLEASE ?");
            }
        }
        return list;
    }

    private void deletePic(String workingDir, String postedDir) {
        String toDelete = workingDir + "/" + listToPost.get(0);
        File file = new File(toDelete);
        try {
            FileUtils.copyFileToDirectory(file, new File(postedDir));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.deleteIfExists(Paths.get(toDelete));
        } catch (IOException e) {
            e.printStackTrace();
        }
        listToPost.remove(0);
    }
}
