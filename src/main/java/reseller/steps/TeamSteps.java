package reseller.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import reseller.pages.TeamPage;

/**
 * Created by rusu on 3/24/15.
 */
public class TeamSteps extends BaseSteps {
    public TeamSteps() {
        super();
    }

    public TeamSteps(Pages pages) {
        super(pages);
    }

    public TeamPage teamPage() {
        return getPages().currentPageAt(TeamPage.class);
    }

    @Step
    public void clickAddButton() {
        teamPage().clickAddButton();
    }

    @Step
    public void addTeamMember(String teamMember) {
        teamPage().addTeamMember(teamMember);
    }

    @Step
    public void clickSendInvitationButton() {
        teamPage().sendInvitation();
    }

    @Step
    public void checkNewInvitationPending(String teamMember) {
        Boolean ok = teamPage().isPending(teamMember);
        if (ok == true) {
            System.out.println("OK!");
        } else System.out.println("Failed");
    }
}
