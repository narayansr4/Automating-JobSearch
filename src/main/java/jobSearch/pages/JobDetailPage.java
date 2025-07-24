package jobSearch.pages;

import jobSearch.base.Base;
import jobSearch.utils.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobDetailPage extends Base {

    @FindBy(xpath = "//div[contains(@class,'w-full')] //div[@class='flex items-center justify-between pt-2']/a")
    WebElement companyName;

    @FindBy(xpath = "//div/span/a")
    WebElement email;

    @FindBy(xpath = "//span[@class='bodybold mt-2 ml-2']")
    WebElement closingDate;

    public JobDetailPage(){
        PageFactory.initElements(driver,this);
    }

    public String getCompanyname(){
        WaitUtils.waitForElementVisibility(companyName,2);
         return companyName.getText();
    }

    public String getEmail(){
        return email.getText();
    }

    public String getClosingDate(){
        return closingDate.getText().split(":")[1];
    }

}
