package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlbumPage extends PageBase{

    @FindBy (xpath = "//p[@role='link']")
    public WebElement artistName;

    @FindBy (xpath = "//img[@class='play']")
    public WebElement playButton;




}
