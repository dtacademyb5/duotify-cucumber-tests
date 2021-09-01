package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

import java.util.List;

public class PlaylistsPage extends PageBase{


    @FindBy(xpath = "//button[.='NEW PLAYLIST']")
    public WebElement newPlayListButton;

    @FindBy(xpath = " //div[@class='gridViewContainer']//div[@class='gridViewItem']")
    public List<WebElement> allPlaylistsList;




    public void enterPlayListName(String name){
        Driver.getDriver().switchTo().alert().sendKeys(name);
        Driver.getDriver().switchTo().alert().accept();
    }


    public String grabTheLastPlayListsText(){

        return allPlaylistsList.get(allPlaylistsList.size()-1).getText();

    }

}
