package jobSearch.test;

import jobSearch.base.Base;
import jobSearch.pages.JobDetailPage;
import jobSearch.pages.JobsListPage;
import jobSearch.pages.LandingPage;
import jobSearch.utils.ExcelUtils;
import jobSearch.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class JobScrapper extends Base {
    public static void main(String[] args) throws InterruptedException {
        JobScrapper obj = new JobScrapper();
        obj.setup();
        LandingPage landingPage = new LandingPage();
        JobsListPage jobsListPage = landingPage.clickOnCareersLink();
        JobDetailPage jobDetailPage = new JobDetailPage();

        jobsListPage.enterKeyword();
        jobsListPage.clickOnSearchButton();
        jobsListPage.showAllJobs();
        jobsListPage.clickOnAllJobs();

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();
        it.next();
        Object[][] data = new Object[windowHandles.size()][3]; // Actually it should be "windowHandles.size() - 1" because there are 12 job postings and windowHandles.size() will return 13. But we are giving that extra one for Title
        data[0][0] = prop.getProperty("columnHeader1");
        data[0][1] = prop.getProperty("columnHeader2");
        data[0][2] = prop.getProperty("columnHeader3");

        int i = 1; //because i=0 is for title which is already given above
        int count = 1;
        while (it.hasNext()){
            driver.switchTo().window(it.next());
            data[i][0] = count;
            data[i][1] = jobDetailPage.getCompanyname();
            data[i][2] = jobDetailPage.getClosingDate();
            i++;
            count++;
        }
        ExcelUtils.writeIntoExcel(prop.getProperty("excel_path"),prop.getProperty("keyword") + " jobs",data);

        obj.teardown();
    }
}
