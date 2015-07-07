package reseller.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import reseller.pages.ModalAddCustomerOrg;

/**
 * Created by rusu on 3/27/15.
 */

public class MAddCustomerOrgSteps extends BaseSteps {
    public MAddCustomerOrgSteps() {
        super();
    }

    public MAddCustomerOrgSteps(Pages pages) {
        super(pages);
    }

    public ModalAddCustomerOrg modalAddCustomerOrg() {
        return getPages().currentPageAt(ModalAddCustomerOrg.class);
    }

    @Step("Set the organization name: {0}")
    public void setOrganizationName(String orgName) {
        modalAddCustomerOrg().setOrganizationName(orgName);
    }

    @Step("Set the market segment: {0}")
    public void selectMarketSegment(int index) {
        modalAddCustomerOrg().setSelectMarketSegment(index);
    }

    @Step("Set the country: {0}")
    public void setCountry(int indexCountry) {
        modalAddCustomerOrg().setCountry(indexCountry);
    }

    @Step("Set the state: {0}")
    public void setState(int indexState) {
        modalAddCustomerOrg().setCountry(indexState);
    }

    @Step("Enter first address: {0}")
    public void setAddress1(String adr1) {
        modalAddCustomerOrg().setAddress1(adr1);
    }

    @Step("Enter second address: {0}")
    public void setAddress2(String adr2) {
        modalAddCustomerOrg().setAddress2(adr2);
    }

    @Step("Choose the city: {0}")
    public void setCity(String city) {
        modalAddCustomerOrg().setCity(city);
    }

    @Step("Enter tge ZIP code: {0}")
    public void setZipCode(String zipCode) {
        modalAddCustomerOrg().setZipCode(zipCode);
    }

    @Step("Enter the e-mail address: {0}")
    public void setEmail(String email) {
        modalAddCustomerOrg().setEmail(email);
    }

    @Step("Enter first name: {0}")
    public void setFirstNameF(String firstName) {
        modalAddCustomerOrg().setFirstName(firstName);
    }

    @Step("Enter second name: {0}")
    public void setLastName(String lastName) {
        modalAddCustomerOrg().setLastName(lastName);
    }

    @Step("Choose: Allow")
    public void setChooseAllow() {
        modalAddCustomerOrg().setChooseAllow();
    }

    @Step("Click the button: \"Invite Customer\"")
    public void clickInviteCustomerButton() {
        modalAddCustomerOrg().clickInviteCustomerButton();
    }

}
