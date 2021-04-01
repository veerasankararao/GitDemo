package Testing.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FacebookPOM {
	
	WebDriver driver;
	public FacebookPOM(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver1, this);
	}
/*	
By usename=By.id("email");
By password=By.id("pass");
By loginbutton=By.name("login");
	public WebElement username() {
		return driver.findElement(usename);
	}
	public WebElement password() {
		return driver.findElement(password);
		}

	public WebElement loginbutton() {
		return driver.findElement(loginbutton);
	}
	*/
@FindBy(id="email")
WebElement emailid;
@FindBy(id="pass")
WebElement pwsd;
@FindBy(name="login")
WebElement login;

public WebElement getEmailid() {
	return emailid;
}
public WebDriver getDriver() {
	return driver;
}
public WebElement getPwsd() {
	return pwsd;
}
public WebElement getLogin() {
	return login;
} 







}
