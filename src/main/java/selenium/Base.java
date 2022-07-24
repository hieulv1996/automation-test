package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com.vn/");
        webDriver.close();
    }
}
