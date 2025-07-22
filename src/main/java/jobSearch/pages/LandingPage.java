package jobSearch.pages;

import jobSearch.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends Base {


    @FindBy(linkText = "Careers@Technopark")
    WebElement careersLink;

    public LandingPage(){
        PageFactory.initElements(driver,this);
    }

    public JobsListPage clickOnCareersLink(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", careersLink);
        careersLink.click();
        return  new JobsListPage();
    }
}
