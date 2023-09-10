package base;

import org.openqa.selenium.WebDriver;

public class appDriver {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver getDriver()
    {
    return  driver.get();
    }

    public static void setDriver(WebDriver Driver)
    {
        driver.set(Driver);
    }
}


