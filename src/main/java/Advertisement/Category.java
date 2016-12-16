package Advertisement;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * OLX
 * Created by Yuliya Chyrva on 15.12.2016.
 */
public class Category {

    private WebElement ParentCategory;
    private WebElement ChildCategory;
    private WebElement PriceField;
    private WebElement element;
    private WebElement el;
    private String IDstateField = "targetparam13";
    private String IDprivateBusinessField = "targetid_private_business";

    protected WebDriver driver;

    public Category(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method is used for selecting necessary parent category and child
     *
     * @param parentCategory - name of a parent category
     * @param childCategory - name of a child category
     * @param state
     * @param privateBusiness
     * @throws InterruptedException
     */
    public void SelectCategory (String parentCategory, String childCategory, String state, String privateBusiness) throws InterruptedException {
        ParentCategory = driver.findElement(By.xpath("//strong[contains(text(),'"+parentCategory+"')]"));
        ParentCategory.click();

        ChildCategory = driver.findElement(By.xpath("//span[contains(text(),'"+childCategory+"')]"));
        ChildCategory.click();
        Thread.sleep(2000);

        PriceField = driver.findElement(By.xpath("//input[contains(@name, 'data[param_price][1]')]"));
        PriceField.click();
        PriceField.sendKeys(RandomStringUtils.randomNumeric(3));

        choseValueFromDropdown(IDstateField, state);
        choseValueFromDropdown(IDprivateBusinessField, privateBusiness);
    }

    /**
     * This method is used for selecting state of product and type of person - private or business
     *
     * @param ID - element ID in HTML
     * @param dropDownList - value from the dropdown list
     */
    public void choseValueFromDropdown(String ID, String dropDownList){

        element = driver.findElement(By.xpath("//dl[contains(@id, '"+ID+"')]"));
        element.click();
        el = driver.findElement(By.xpath("//a[contains(text(), '"+dropDownList+"')]"));
        el.click();
    }

}
