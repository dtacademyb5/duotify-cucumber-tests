package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

public class AlbumPage extends PageBase{

    @FindBy (xpath = "//p[@role='link']")
    public WebElement artistName;

    @FindBy (xpath = "//img[@class='play']")
    public WebElement playButton;




}
