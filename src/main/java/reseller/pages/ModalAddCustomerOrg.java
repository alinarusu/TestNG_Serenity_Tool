package reseller.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by rusu on 3/27/15.
 */
public class ModalAddCustomerOrg extends BasePage {

    /* Locator */
    private By insertOrganizationNameLocator = By.name("orgName");
    private By insertAddress1Locator = By.name("street1");
    private By insertAddress2Locator = By.name("street2");
    private By insertCityLocator = By.name("city");
    private By insertZipCodeLocator = By.name("zipCode");
    private By insertEmailLocator = By.name("email");
    private By insertFirstNameLocator = By.name("firstName");
    private By insertLastNameLocator = By.name("lastName");
    private By chooseAllowLocator = By.id("usadEnabledCheckBox");
    private By inviteCustomerButtonLocator = By.cssSelector("button.btt-add-customer");
    private By selectMarketSegmentLocator = By.name("marketSegment");
    private By selectCountryLocator = By.name("country");
    private By insertStateLocator = By.name("region");

    public ModalAddCustomerOrg(WebDriver driver) {
        super(driver);
    }

    /* WebElements */
    public WebElementFacade insertOrganizationName() {
        return find(insertOrganizationNameLocator);
    }

    public WebElementFacade insertAddress1() {
        return find(insertAddress1Locator);
    }

    public WebElementFacade insertAddress2() {
        return find(insertAddress2Locator);
    }

    public WebElementFacade insertCity() {
        return find(insertCityLocator);
    }

    public WebElementFacade insertState() {
        return find(insertStateLocator);
    }

    public WebElementFacade insertZipCode() {
        return find(insertZipCodeLocator);
    }

    public WebElementFacade insertEmail() {
        return find(insertEmailLocator);
    }

    public WebElementFacade insertFirstName() {
        return find(insertFirstNameLocator);
    }

    public WebElementFacade insertLastName() {
        return find(insertLastNameLocator);
    }

    public WebElementFacade chooseAllow() {
        return find(chooseAllowLocator);
    }

    public WebElementFacade inviteCustomerButton() {
        return find(inviteCustomerButtonLocator);
    }

    public WebElementFacade selectMarketSegment() {
        return find(selectMarketSegmentLocator);
    }

    public WebElementFacade selectCountry() {
        return find(selectCountryLocator);
    }

    /* Methods */
    public void setOrganizationName(String orgName) {
        insertOrganizationName().type(orgName);
    }

    public void setAddress1(String adr1) {
        insertAddress1().type(adr1);
    }

    public void setAddress2(String adr2) {
        insertAddress2().type(adr2);
    }

    public void setCity(String city) {
        insertCity().type(city);
    }

    public void setZipCode(String zipCode) {
        insertZipCode().type(zipCode);
    }

    public void setEmail(String email) {
        insertEmail().type(email);
    }

    public void setFirstName(String firstName) {
        insertFirstName().type(firstName);
    }

    public void setLastName(String lastName) {
        insertLastName().type(lastName);
    }

    public void setChooseAllow() {
        click_me(chooseAllow(), chooseAllowLocator);
    }

    public void clickInviteCustomerButton() {
        click_me(inviteCustomerButton(), inviteCustomerButtonLocator);
    }

    public void setSelectMarketSegment(int index) {
        selectMarketSegment().selectByIndex(index);
    }

    public void setCountry(int index) {
        selectCountry().selectByIndex(index);
    }

    public void setState(int indexState) {
        insertState().selectByIndex(indexState);
    }
}

