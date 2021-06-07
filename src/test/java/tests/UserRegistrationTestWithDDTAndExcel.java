package tests;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.LoginPage;

public class UserRegistrationTestWithDDTAndExcel extends TestBase
{
	LoginPage loginObject ;

	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}

	@Test(priority=1,alwaysRun=true,dataProvider="ExcelData")
	@Severity(SeverityLevel.BLOCKER)
	@Description(" Login test with multi scenarios")
	public void UserCanRegisterSuccssfully(String UserName , String password) {
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(UserName, password);
		String URL = driver.getCurrentUrl();

		if (URL.contentEquals("https://www.saucedemo.com/"))
		{
			System.out.println(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText());
		}

		else {
			driver.findElement(By.id("react-burger-menu-btn")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
		}

	}

}