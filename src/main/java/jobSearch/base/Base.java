package jobSearch.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {

    public static Properties prop;
    public static WebDriver driver;

    public Base(){
        prop = new Properties();
        FileInputStream fis;
        String path = System.getProperty("user.dir") + "\\src\\main\\java\\jobSearch\\config\\config.properties";
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void setup(){
        String browserName = prop.getProperty("browser");
        switch (browserName){
            case "chrome" :
                driver = new ChromeDriver();
                break;
            case "firefox" :
                driver = new FirefoxDriver();
                break;
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void teardown(){
        driver.quit();
    }

}
