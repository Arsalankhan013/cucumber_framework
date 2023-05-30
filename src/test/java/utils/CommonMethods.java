package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Pageinitializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class CommonMethods extends Pageinitializer {
    public static WebDriver driver;




    public static void openBrowserAndLaunchApplication(){
ConfigReader.readProperties(Constants.Config_file_path);
        //cross browser testing
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.setHeadless(true);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
       initializePageObjects();
    }
    public static void closeBrowser() {

        driver.quit();
    }





    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }


    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;
    }

    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    public static void selectDropdown(WebElement element, String text){
        Select s = new Select(element);
        s.selectByVisibleText(text);
    }
    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return js;
    }

public static byte[] takeScreenShot(String filename){

    TakesScreenshot ts=(TakesScreenshot)driver;
       byte [] picByte = ts.getScreenshotAs(OutputType.BYTES);

     File Sourcefile=  ts.getScreenshotAs(OutputType.FILE);

    try {
        FileUtils.copyFile(Sourcefile,
                new File(new File(Constants.SCREENSHOT_FILEPATH) + filename + " " + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
    } catch (IOException e) {
       e.printStackTrace();
    }

    return picByte;
}


    public static String getTimeStamp(String pattern){

        Date date=new Date();
        //to format code to our choice
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);

        return sdf.format(date);
    }

}



