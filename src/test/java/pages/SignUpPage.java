package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends PageBase {



    @FindBy(id = "username")
    public WebElement usernameField;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "email2")
    public WebElement email2;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "password2")
    public WebElement password2;

    @FindBy(name = "registerButton")
    public WebElement registerButton;

}
