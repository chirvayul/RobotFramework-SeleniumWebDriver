import Advertisement.NewAdvertisement;
import org.openqa.selenium.support.PageFactory;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

/**
 * OLX
 * Created by Yuliya Chyrva on 15.12.2016.
 */

@RobotKeywords
public class Keywords extends WebDriverInitialization{

    @RobotKeyword
    @ArgumentNames({"networkName","login","password"})
    public void SignIn(String networkName, String login, String password) throws InterruptedException {
        Authorization Auth = PageFactory.initElements(getWebDriver(), Authorization.class);
        Auth.SingIn(networkName, login, password);
    }

    @RobotKeyword
    @ArgumentNames({"title","parentCategory","childCategory","state","privateBusiness","description","address","person","mobile"})
    public void NewAd(String title, String parentCategory, String childCategory,
                      String state, String privateBusiness, String description,
                      String address, String person, String mobile) throws InterruptedException {
        NewAdvertisement Advertisement = PageFactory.initElements(getWebDriver(), NewAdvertisement.class);
        Advertisement.CreateNewAdvertisement(title, parentCategory, childCategory, state, privateBusiness, description, address,
                                                person, mobile);
    }

}
