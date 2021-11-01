package iLabTraining;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class WebDriverTest {
    @Test
     public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


        //Page tittle validation
        if(driver.getTitle().contains("OrangeHRM"))

            System.out.println("Page title contains \"OrangeHRM\" ");
        else

            System.out.println("Page title doesn't contains \"OrangeHRM\" ");


        //Login

        Thread.sleep(1000);
        WebElement uname = driver.findElement(By.id(OrangeFarmLocators.name));
        uname.clear();
        uname.sendKeys(OrangeFarmLocators.userName);
        WebElement passWord = driver.findElement(By.id(OrangeFarmLocators.Id));
        passWord.clear();
        passWord.sendKeys(OrangeFarmLocators.Password);
        driver.findElement(By.name("Submit")).click();

        //Validate Admin tab is displayed
        boolean Admin = driver.findElement(By.id("menu_admin_viewAdminModule")).isDisplayed();
        System.out.println(Admin);

        //Validate url
        if(driver.getCurrentUrl().contains("dashboard"))

            System.out.println("url contains \"dashboard\" ");
        else

            System.out.println("url doesn't contains \"dashboard\" you are in wrong url ");

        //Validate welcome

        //Click Admin tab

        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        //Validate if url contains
        if(driver.getCurrentUrl().contains("admin/viewSystemUser"))

            System.out.println("url contains \"admin/viewSystemUsers\" ");
        else

            System.out.println("url doesn't contains \"admin/viewSystemUsers\" you are in wrong url ");
        //Validate Add, Delete, Search and Reset button are displayed
        boolean AddBtn = driver.findElement(By.id("btnAdd")).isDisplayed();
        System.out.println(AddBtn);

        boolean Searchbtn = driver.findElement(By.id("searchBtn")).isDisplayed();
        System.out.println(Searchbtn);

        boolean btnReset = driver.findElement(By.id("resetBtn")).isDisplayed();
        System.out.println(btnReset);
        boolean Deletebtn = driver.findElement(By.id("btnDelete")).isDisplayed();
        System.out.println(Deletebtn);

        //Click Add button
        driver.findElement(By.id("btnAdd")).click();


        //Validate url
        if(driver.getCurrentUrl().contains("saveSystemUser"))

            System.out.println("url contains \"saveSystemUser\" ");
        else

            System.out.println("url doesn't contains \"saveSystemUser\" you are in wrong url ");

        //Validate add user H1
        boolean userH1 = driver.findElement(By.xpath("//*[@id=\"UserHeading\"]")).isDisplayed();
        System.out.println(userH1);

        //adding user
        //List<WebElement> homeElements = driver.findElements(By.xpath("//*[@id=\"systemUser_userType\"]"));
        //Assert.assertTrue("Not selected",homeElements.);

        Thread.sleep(5000);
        WebElement nameAdd = driver.findElement(By.xpath(OrangeFarmLocators.addNameXpath));
        nameAdd.clear();
        nameAdd.sendKeys(OrangeFarmLocators.employeeName);

        WebElement usernameAdd = driver.findElement(By.id(OrangeFarmLocators.adduserName));
        usernameAdd.clear();
        usernameAdd.sendKeys(OrangeFarmLocators.empuserName);

        WebElement userpasswordAdd = driver.findElement(By.id(OrangeFarmLocators.addPassword));
        userpasswordAdd.clear();
        userpasswordAdd.sendKeys(OrangeFarmLocators.empPassword);

        WebElement userpasswordreAdd = driver.findElement(By.id(OrangeFarmLocators.readdPassword));
        userpasswordreAdd.clear();
        userpasswordreAdd.sendKeys(OrangeFarmLocators.emprePassword);

        Thread.sleep(5000);
        driver.findElement(By.className("addbutton")).click();
        //
        //Validate user is created

        //Search
        WebElement searchUser = driver.findElement(By.id(OrangeFarmLocators.addSearch));
        searchUser.clear();
        searchUser.sendKeys(OrangeFarmLocators.addSearchfield);
       System.out.println("passed");
       Thread.sleep(5000);


        //Delete user

       Thread.sleep(5000);
       driver.findElement(By.id("ohrmList_chkSelectAll")).click();
       Thread.sleep(5000);
        driver.findElement(By.id("btnDelete")).click();
       Thread.sleep(5000);
        driver.findElement(By.id("dialogDeleteBtn")).click();

        //validate  No Record Found message
        boolean noRecordmsg = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td")).isDisplayed();
        System.out.println(noRecordmsg);
        //Log out
        driver.findElement(By.xpath("//*[@id=\"welcome\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a")).click();

        if(driver.getTitle().contains("OrangeHRM"))

            System.out.println("Page title contains \"OrangeHRM\" ");
        else

            System.out.println("Page title doesn't contains \"OrangeHRM\" ");


        if(driver.getCurrentUrl().contains("login"))

            System.out.println("url contains \"login\" ");
        else

            System.out.println("url doesn't contains \"login\" you are in wrong url ");



            driver.quit();
       System.out.println("All Tests Passed");


        }


    }






