package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase
{
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="user-name")
	WebElement nameTxtBox ;

	@FindBy(id="password")
	WebElement passwordTxtBox ; 

	@FindBy(id="login-button")
	WebElement loginBtn ;


	public void UserLogin(String UserName , String password) 
	{
		nameTxtBox.clear();
		setTextElementText(nameTxtBox, UserName);
		passwordTxtBox.clear();
		setTextElementText(passwordTxtBox, password);
		clickButton(loginBtn);



	}

}
