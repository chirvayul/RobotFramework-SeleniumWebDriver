import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * OLX
 * Created by Yuliya Chyrva on 15.12.2016.
 */

public class Authorization {

    @FindBy (xpath = "//input[contains(@id,'userEmail')]|//input[contains(@name,'email')]")
    private WebElement Login;

    @FindBy (xpath = "//input[contains(@id,'userPass')]|//input[contains(@name,'pass')]")
    private WebElement Password;

    @FindBy (xpath = "//button[contains(@id,'se_userLogin')]|//button[contains(@type,'submit')]")
    private WebElement SubmitButton;

    @FindBy (id = "vkontakteLogin")
    private WebElement VkontakteLogin;

    protected WebDriver driver;

    public Authorization (WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method enters login and password in to an authorization form and submit the form
     *
     * @param networkName - type of authorization - by email or by Vkontakte
     * @param login - login for email or Vkontakte
     * @param password - password for email or Vkontakte
     * @throws InterruptedException
     */
    public void SingIn(String networkName, String login, String password) throws InterruptedException {
        driver.get("https://www.olx.ua/myaccount/");
        driver.findElement(By.xpath("//div[contains(@id, 'cookiesBar')]/a")).click();
        switch (networkName) {
            case "email":
                break;
            case "vkontakte":
                VkontakteLogin.click();
                break;
            default:
                throw new IllegalArgumentException ("Enumeration is invalid");
        }
        SubmitLoginForm(login, password);
    }

    /**
     *
     * @param login
     * @param password
     * @throws InterruptedException
     */
    private void SubmitLoginForm (String login, String password) throws InterruptedException {
        Login.sendKeys(login);
        Password.sendKeys(password);
        SubmitButton.click();
    }
}
