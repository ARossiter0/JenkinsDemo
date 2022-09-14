package utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {
    public WebDriver driver;

    public  GenericUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void switchWindowToChild() {
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> iterator = s1.iterator();
        iterator.next();
        driver.switchTo().window(iterator.next());
    }

}
