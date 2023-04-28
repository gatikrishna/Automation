package stepdefinations;


import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.junit.BeforeClass;
import utility.GlobalProperty;

import java.io.FileInputStream;
import java.util.Properties;

public class CommonUtility {
/**
@author - Gatikrishna
 */
    public void readPropertiesFile(String filePath) {
        System.out.println(String.format("Executing readPropertiesFile :- " + filePath));
        try {
            FileInputStream file = new FileInputStream(filePath);
            Properties prop = new Properties();
            prop.load(file);
            prop.forEach((k, v) -> GlobalProperty.setProperty(k.toString(), v.toString()));
            prop.forEach((k, v) -> System.out.println(k.toString() + " " + v.toString()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Before
    public void readFileAndSetValues() {
        try {
            readPropertiesFile(".\\..\\Automation\\src\\main\\resources\\application.properties");
            readPropertiesFile(".\\..\\Automation\\src\\main\\resources\\environment\\" + GlobalProperty.getProperty("env") + ".properties");
            readPropertiesFile(".\\..\\Automation\\src\\main\\resources\\environment\\endPoint.properties");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
