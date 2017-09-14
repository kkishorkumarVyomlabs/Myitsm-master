package com.vyomlabs.auto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.vyomlabs.bussiness.CheckCredential;

public class Tickets {
	String result="";
	FirefoxDriver driver=null;
	String str="";
	String temp="";
	public String apply(String userName,String pass,String type,String to,String services,String sla,String subject,String text) throws InterruptedException, ParseException {

		FirefoxDriver driver=new FirefoxDriver();
		String str="";
		WebElement we=null;
		Actions action = new Actions(driver);

		try{

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://itsmedge.vyom-labs.com/otrs/customer.pl");
			try{

				driver.findElement(By.xpath(".//*[@id='User']")).sendKeys(userName);
				driver.findElement(By.xpath(".//*[@id='Password']")).sendKeys(pass);
				driver.findElement(By.xpath(".//*[@id='Login']/form/div[3]/button")).click();

				Thread.sleep(1000);
				we =driver.findElement(By.xpath(".//*[@id='Navigation']/ul[1]/li[1]/a"));
				action.moveToElement(we).click().build().perform();
				
				try{

					we =driver.findElement(By.xpath(".//*[@id='Navigation']/ul[1]/li[1]/ul/li[1]/a"));
					action.moveToElement(we).click().build().perform();
					Thread.sleep(1000);

					Select dropdown1 = new Select(driver.findElement(By.xpath(".//*[@id='TypeID']")));
					int tp=Integer.valueOf((String)type);
					dropdown1.selectByIndex(tp);
					Thread.sleep(2000);

					Select dropdown2 = new Select(driver.findElement(By.xpath(".//*[@id='Dest']")));
					int t=Integer.valueOf((String)to);
					dropdown2.selectByIndex(t);
					Thread.sleep(2000);

					Select dropdown3 = new Select(driver.findElement(By.xpath(".//*[@id='ServiceID']")));
					int s=Integer.valueOf((String)services);
					dropdown3.selectByIndex(s);
					Thread.sleep(2000);

					Select dropdown4 = new Select(driver.findElement(By.xpath(".//*[@id='SLAID']")));
					dropdown4.selectByIndex(1);
					Thread.sleep(1000);

					we =driver.findElement(By.xpath(".//*[@id='Subject']"));
					we.clear();
					we.sendKeys(subject);
					Thread.sleep(1000);

					WebElement element =driver.findElement(By.xpath("html/body/div[3]/div/form/fieldset/div[6]/div[1]/div/div//iframe"));
					driver.switchTo().frame(element);
					driver.findElement(By.xpath("html/body")).sendKeys(text);
					driver.switchTo().parentFrame();
					Thread.sleep(1000);

					we=driver.findElement(By.xpath(".//*[@id='submitRichText']"));
					action.moveToElement(we).click().build().perform();
					Thread.sleep(2000);
					temp=driver.findElement(By.xpath("html/body/div[3]/div[2]/table/tbody/tr/td[1]/a")).getText();
					Thread.sleep(1000);
					we=driver.findElement(By.xpath("html/body/div[2]/ul[2]/li[2]/a"));
					action.moveToElement(we).click().build().perform();

				}catch(Exception e)
				{
					result="Sumthing goes wrong..! Please try aagin.";
					System.out.println(result);
					e.printStackTrace();
				}
			}catch(Exception e){
				result="Login failed! Your user name or password was entered incorrectly.";
				e.printStackTrace();
			}
		}catch(Exception e){
			result="Server not found. Please try again..!";
			e.printStackTrace();
		}
		finally{
			driver.close();
		}
		if(result=="")
		{
			result="Thank You...! Your ticket is successfully submited.Yor Ticket number is "+temp;
		}


		return result;
	}
}
