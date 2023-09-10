package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class configFileReader {

    private static Properties properties;
    private final String propertyFile = "configurations//config.properties";

    public configFileReader (){
        BufferedReader reader;
        try {
            reader = new BufferedReader (new FileReader(propertyFile));
            properties = new Properties();
            try{
                properties.load(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getExcelPath() {
        String getExcelPath =  properties.getProperty("excelPath");
        if (getExcelPath != null) return getExcelPath;
        else throw new RuntimeException("Excelpath  Not Found");
    }


    public String getdeviceName(){
        String getdeviceName =  properties.getProperty("deviceName");
        if (getdeviceName != null) return getdeviceName;
        else throw new RuntimeException("Device name Not Found");
    }

    public String getplatformName(){
        String getplatformName =  properties.getProperty("platformName");
        if (getplatformName != null) return getplatformName;
        else throw new RuntimeException("Platform name Not Found");
    }

    public String getplatformVersion(){
        String getplatformVersion =  properties.getProperty("platformVersion");
        if (getplatformVersion != null) return getplatformVersion;
        else throw new RuntimeException("Platform version Not Found");
    }

    public String getautomationName(){
        String getautomationName =  properties.getProperty("automationName");
        if (getautomationName != null) return getautomationName;
        else throw new RuntimeException("Automation Name Not Found");
    }

    public String getappPath(){
        String getappPath =  properties.getProperty("appPath");
        if (getappPath != null) return getappPath;
        else throw new RuntimeException("App path Not Found");
    }
    public String getappiumServerURL(){
        String getappiumServerURL =  properties.getProperty("appiumServerURL");
        if (getappiumServerURL != null) return getappiumServerURL;
        else throw new RuntimeException("Appium Server Not Found");
    }

    public String getappPackage(){
        String getappPackage =  properties.getProperty("appPackage");
        if (getappPackage != null) return getappPackage;
        else throw new RuntimeException("App Package Not Found");
    }
    public String getappActivity(){
        String getappActivity =  properties.getProperty("appActivity");
        if (getappActivity != null) return getappActivity;
        else throw new RuntimeException("App Activity Not Found");
    }


}
