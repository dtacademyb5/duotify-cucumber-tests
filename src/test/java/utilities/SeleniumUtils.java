package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;


public class SeleniumUtils {

    public static void switchToWindow(String targetTitle) {

        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    /**
     * To hover over an element
     * @param element
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }
    /**
     * Extract list of String out of list of webelements
     * @param list
     * @return
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }



    // Explicit Wait methods

    public static void waitForVisibility(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }
    public static void waitForVisibility(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(locator)));
    }


    public static void waitForClickablility(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }
    public static void waitForClickablility(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
    }

    public static void waitForPresenceOfElementLocated(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(locator)));
    }

    public static void waitForTitleContains(String partOfTitle, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.titleContains(partOfTitle)));
    }
    public static void waitForTitleIs(String title, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.titleIs(title)));
    }
    public static void waitForUrlContains(String partOfUrl, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.urlContains(partOfUrl)));
    }


    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void waitForPageToLoad(int seconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println("Timed out waiting for page load");
        }
    }



    public static WebElement fluentWait(WebElement webElement, int timeOutSeconds, int pollingSeconds) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(timeOutSeconds)).pollingEvery(Duration.ofSeconds(pollingSeconds))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });
        return element;
    }
    public static boolean elementExists(WebElement element, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
            return true;
        } catch (StaleElementReferenceException | TimeoutException | NoSuchElementException e) {
            return false;
        }
    }





    public static String getScreenshot(String name)  {
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String fileName = name + date + ".png";
        String target = System.getProperty("user.dir") + "/test-output/extentReports/" + fileName;
        File finalDestination = new File(target);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }



    public static void takeFullScreenshot(String fileName)  {
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(Driver.getDriver());
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + fileName + date
                + ".png";
        try {
            ImageIO.write(fpScreenshot.getImage(), "PNG", new File(path));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void scroll(int horizontalAxis, int verticalAxis) {
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy("+horizontalAxis+","+verticalAxis+")");
    }


    public static void jsClick(WebElement webelement) {
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].click();", webelement);
    }


    public static void uploadFile(By chooseFileButton, String pathToAFileToBeUploaded ) {
        Driver.getDriver().findElement(chooseFileButton).sendKeys(pathToAFileToBeUploaded);
    }




}