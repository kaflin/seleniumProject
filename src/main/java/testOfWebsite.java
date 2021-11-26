import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testOfWebsite {
    public String baseUrl ="http://automationpractice.com/index.php";
    String driverPath="/home/suraj/Downloads/selenium/chromedriver_linux64/chromedriver";
    public WebDriver driver;
    public String a="suraj5056526@gmail.com";



    @BeforeTest
    public void launchBrowser(){
        System.out.println("Launching Chrome Browser");
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver =new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    public void createAccount() throws InterruptedException {
        driver.findElement(By.className("login")).click();
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(a);
        driver.findElement(new By.ByName("SubmitCreate")).click();
        Thread.sleep(12000);
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Suraj");
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Gupta");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Suraj12345");
        driver.findElement(By.xpath("//select[@id='days']")).sendKeys("1");
        driver.findElement(By.xpath("//select[@id='months']")).sendKeys("September");
        driver.findElement(By.xpath("//select[@id='years']")).sendKeys("1996");
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Deerwalk Inc");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Sifal,Chabil -330000");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Kathmandu");
        driver.findElement(By.xpath("//select[@id='id_state']")).sendKeys("Arizona");
        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("33000");
        driver.findElement(By.xpath("//select[@id='id_country']")).sendKeys("United States");
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("9867488538");
        driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("Kikatol");

        driver.findElement(By.id("submitAccount")).click();
        System.out.println("Account Created");
        Thread.sleep(4000);
        driver.findElement(By.linkText("Home")).click();


    }
    @Test(priority = 2)
    public void loginAccount() throws InterruptedException {
        driver.findElement(By.className("logout")).click();
        driver.findElement(By.className("login")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(a);
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Suraj12345");
        driver.findElement(By.id("SubmitLogin")).click();
        System.out.println("Successfully Logged in");
        Thread.sleep(4000);
        driver.findElement(By.linkText("Home")).click();
    }
    @Test(priority = 3)
    public void home() throws InterruptedException {
        WebElement women = driver.findElement(By.cssSelector("ul>li:nth-child(1)>a[title='Women']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(women).perform();//this will hover to women
//        Thread.sleep(1000);//avoid using this type of wait. wait using until.
        driver.findElement(By.cssSelector("ul>li:nth-child(1)>a[title='T-shirts']")).click();//this will click on t-shirt
        System.out.println("Casual T-shirt selected");

    }
    @Test(priority = 4)
    public void searchBox() throws InterruptedException {
        driver.findElement(By.className("icon-home")).click();
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("shirt");
        driver.findElement(By.className("button-search")).click();
    }
    @Test(priority = 5)
    public void media() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.className("icon-home")).click();
//        driver.findElement(By.xpath("//*[text()='Follow us']"));
        WebElement Element = driver.findElement(By.xpath("//*[text()='Follow us']"));

        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
        driver.findElement(By.className("facebook")).click();
        driver.findElement(By.className("twitter")).click();
        driver.findElement(By.className("youtube")).click();
        driver.findElement(By.className("google-plus")).click();
    }

    @AfterTest
    public void terminateBrowser()
    {
        System.out.println("Terminating the browser");
        driver.close();
    }

}
