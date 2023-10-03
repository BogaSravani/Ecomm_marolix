package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.id("alert")).click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//alert handling with waits//
	wait.until(ExpectedConditions.alertIsPresent());
	driver.switchTo().alert().accept();
	System.out.println("alert handled");
	
	//changing of text//
	driver.findElement(By.id("populate-text")).click();
	WebElement text=driver.findElement(By.className("target-text"));
	wait.until(ExpectedConditions.textToBePresentInElement(text,"Selenium Webdriver"));
	System.out.println(text.isDisplayed());
	
	//Button displaying
	driver.findElement(By.id("display-other-button")).click();
	WebElement button=driver.findElement(By.id("hidden"));
	wait.until(ExpectedConditions.visibilityOf(button));
	System.out.println(button.isDisplayed());
	
	//enable button
	driver.findElement(By.id("enable-button")).click();
	WebElement Ebutton=driver.findElement(By.id("disable"));
	wait.until(ExpectedConditions.elementToBeClickable(Ebutton));
	System.out.println(Ebutton.isEnabled());
	
	//selecting checkbox
	driver.findElement(By.id("checkbox")).click();
	WebElement check=driver.findElement(By.id("ch"));
	wait.until(ExpectedConditions.elementSelectionStateToBe(check,true));
	System.out.println(check.isSelected());
}
}
