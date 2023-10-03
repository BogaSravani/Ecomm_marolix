package basics;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

 public class WebTable {
 public static void main(String[] args) {
 WebDriver driver=new ChromeDriver();
 driver.get("https://cosmocode.io/automation-practice-webtable/");
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 
int row=driver.findElements(By.tagName("tr")).size();
System.out.println(row);
int coloumn=driver.findElements(By.xpath("//tr[1]/td")).size();
System.out.println(coloumn);
 
for(int i=2;i<=row;i++)
{
	for(int j=2;j<=coloumn;j++)
	{
		String value=driver.findElement(By.xpath("//tr["+i+"]/td["+j+"]")).getText();
		//System.out.println(value);
		if(value.contains("Ottawa"))
		{
	    driver.findElement(By.xpath("//tr["+i+"]//td[1]//input")).click();
			break;
		}
	}
}
}
}






 /** public static void Cellvalue(WebDriver driver,String rownum,String collnum)
  {
	  WebElement cellvalue=driver.findElement(By.xpath("//table[@id='countries']//tr["+rownum+"]//td["+collnum+"]"));
	  System.out.println(cellvalue.getText());
	  if(cellvalue.getText().contains("Ottawa"))
	  {
		  checkboxes(driver,rownum);
	  }
  }**/
  /**public static void checkboxes(WebDriver driver,int i)
{
	  driver.findElement(By.xpath("//table[@id='countries']//tr["+i+"]//td[1]//input")).click();
}**/



