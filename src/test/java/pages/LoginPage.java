package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage extends PageBase{



    @FindBy(id = "loginUsername")
    public WebElement usernameField;

    @FindBy(id = "loginPassword")
    public WebElement passwordField;

    @FindBy(name = "loginButton")
    public WebElement loginButton;

    @FindBy(id = "hideLogin")
    public WebElement signUpLink;




    public void login(String username, String pass){
        usernameField.sendKeys(username);
       passwordField.sendKeys(pass);
        loginButton.click();
    }


}
