package com.launch;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebook {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;

		Properties prop = new Properties();
		FileInputStream f = new FileInputStream("C:\\Users\\SHABEER AHMED\\eclipse-workspace"
				+ "\\com.facebook\\src\\main\\java\\com\\config\\config.properties");
		prop.load(f);

		String stringProperty = prop.getProperty("Browser");

		if (stringProperty.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\SHABEER AHMED\\eclipse-workspace" + "\\com.facebook\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.out.println("no browser is given");
		}
		
		driver.get(prop.getProperty("url"));
		driver.findElement(By.cssSelector("#email")).sendKeys(prop.getProperty("username"));
		
        driver.findElement(By.cssSelector("#pass"))
        .sendKeys(prop.getProperty("password"));
        driver.findElement(By.cssSelector("#loginbutton")).click();
        driver.quit();
        
	}

}
