package Advertisement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * OLX
 * Created by Yuliya Chyrva on 14.12.2016.
 */
public class NewAdvertisement {

    @FindBy (id = "add-title")
    private WebElement TitleField;

    @FindBy (id = "targetrenderSelect1-0")
    private WebElement CategoryField;

    @FindBy (id = "add-description")
    private WebElement DescriptionField;

    @FindBy (id = "mapAddress")
    private WebElement AddressField;

    @FindBy (id = "add-person")
    private WebElement PersonField;

    @FindBy (id = "add-phone")
    private WebElement MobileField;

    @FindBy (xpath = "//span[contains(text(),'Подать')]")
    private WebElement CreateNewAdvButton;

    @FindBy (id = "save")
    private WebElement PostAdvButton;

    protected WebDriver driver;

    public NewAdvertisement(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method is used for creating and posting new advertisement
     *
     * @param title - a title of the advertisement
     * @param parentCategory - a parent category of the advertisement
     * @param childCategory - a child category of the advertisement
     * @param description - a description of the advertisement
     * @param address - author's address
     * @param person - a person who is submitted the advertisement
     * @param mobile - a person's phone number who is submitted the advertisement
     * @throws InterruptedException
     */
    public void CreateNewAdvertisement(String title, String parentCategory, String childCategory, String state,
                                       String privateBusiness, String description, String address, String person,
                                       String mobile) throws InterruptedException {

        CreateNewAdvButton.click();

        ClearFieldAndInputNewValue(TitleField, title);
        SelectCategory(parentCategory, childCategory, state, privateBusiness);
        ClearFieldAndInputNewValue(DescriptionField, description);
        ClearFieldAndInputNewValue(AddressField, address);
        driver.findElement(By.xpath("//a[contains(@id, 'suggested-city')]")).click();
        ClearFieldAndInputNewValue(PersonField, person);
        ClearFieldAndInputNewValue(MobileField, mobile);

        PostAdvButton.click();

    }

    /**
     * The method is used for find necessary element on the page, then clicks in it, clears it and inputs value
     *
     * @param element - the necessary WebElement on the page
     * @param value - the value which should be entered in the field
     * @throws InterruptedException
     */
    public void ClearFieldAndInputNewValue (WebElement element, String value) throws InterruptedException {
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    /**
     * Method Initializes Category.class
     *
     * @param parentCategory
     * @param childCategory
     * @param state
     * @param privateBusiness
     * @throws InterruptedException
     */
    public void SelectCategory (String parentCategory, String childCategory,  String state,
                                String privateBusiness) throws InterruptedException {
        CategoryField.click();
        Category Categories = PageFactory.initElements(driver, Category.class);
        Categories.SelectCategory(parentCategory, childCategory, state, privateBusiness);
    }


}
