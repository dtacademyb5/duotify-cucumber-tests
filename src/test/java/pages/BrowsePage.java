package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrowsePage extends PageBase{


    @FindBy(xpath = "//div[@class='gridViewInfo']")
    public List<WebElement> albums;

    @FindBy(xpath = "//span[.='Your Music']")
    public WebElement yourMusicLink;


    @FindBy(id = "nameFirstAndLast")
    public WebElement username;

    @FindBy(xpath = "//button[.='USER DETAILS']")
    public WebElement userdetailsButton;


    @FindBy(name = "email")
    public WebElement emailField;
}
