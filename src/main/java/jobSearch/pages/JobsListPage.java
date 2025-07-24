package jobSearch.pages;

import jobSearch.base.Base;
import jobSearch.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JobsListPage extends Base {

    @FindBy(xpath = " //input[@type='text' and @placeholder='Search By Job Description / Company Name']")
    WebElement searchJobInput;

    @FindBy(xpath = "//form //select[@name='type']")
    WebElement jobType;

    @FindBy(xpath = "//button[text()='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,'grid grid-cols-1')] //div/a")
    List<WebElement> jobs;
    //  //div[contains(@class,'grid grid-cols-1')] //div/a

    public JobsListPage(){
        PageFactory.initElements(driver, this);
    }

    public void enterKeyword(){
        searchJobInput.sendKeys(prop.getProperty("keyword"));
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void showAllJobs() throws InterruptedException {
        int previousCount = 0;
        int currentCount = 0;
        //doing the below steps so that all the jobs can be loaded.
        do {
            previousCount = currentCount;//js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            JavascriptExecutor js = (JavascriptExecutor)driver;
            Thread.sleep(1000);
//            WaitUtils.waitForElementsVisibility(jobs,2);
            js.executeScript("arguments[0].scrollIntoView(true);", jobs.get(jobs.size() -1));
            Thread.sleep(800);
            jobs = driver.findElements(By.xpath("//div[contains(@class,'grid grid-cols-1')] //div/a"));
            currentCount = jobs.size();
        } while (currentCount > previousCount);
        System.out.println("No. of jobs:" + currentCount);
    }

    public void clickOnAllJobs(){

        for(WebElement job : jobs){
            job.click();
        }
    }

}
