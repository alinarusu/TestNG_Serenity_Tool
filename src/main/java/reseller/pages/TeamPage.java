package reseller.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by rusu on 3/24/15.
 */
public class TeamPage extends BasePage {

    private By addButtonLocator = By.cssSelector("div.site-toolbar-menu button.site-toolbar-menu-button.icon-add-circle.no-icon-margins.ng-scope");
    private By addTeamMemberAreaLocator = By.cssSelector("div.modal-body textarea.ng-pristine.ng-valid");
    private By sendInvitationLocator = By.cssSelector("div.modal-footer button.primary.btt-submit.ng-scope");

    public TeamPage(WebDriver driver) {
        super(driver);
    }

    public WebElementFacade addButton() {
        return find(addButtonLocator);
    }

    public WebElementFacade addTeamMemberArea() {
        return find(addTeamMemberAreaLocator);
    }

    public WebElementFacade sendInvitationButton() {
        return find(sendInvitationLocator);
    }

    public Boolean isPending(String teamMember) {

        List<WebElementFacade> elements = findAll(By.cssSelector("div.data-list td.column-team-member-email"));

        for (WebElementFacade element : elements) {
            if (element.getText().equals(teamMember)) {
                WebElementFacade find = element.find(By.xpath("./following-sibling::td"));
                String status = find.getText();

                if (status.equals("Pending")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clickAddButton() {
        click_me(addButton(), addButtonLocator);
    }

    public void addTeamMember(String teamMember) {
        addTeamMemberArea().type(teamMember);
    }

    public void sendInvitation() {
        click_me(sendInvitationButton(), sendInvitationLocator);
    }
}
