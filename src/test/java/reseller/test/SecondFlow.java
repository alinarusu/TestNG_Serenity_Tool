package reseller.test;

import org.testng.annotations.Test;

/**
 * Created by rusu on 3/24/15.
 */

public class SecondFlow extends BaseFlow {
    @Test
    public void addTeamMemberFlow() {
        demoSteps.getStarted();
        dashboardSteps.waitABit(500);
        dashboardSteps.clickOnResellerTeam();
        teamSteps.waitABit(1000);
        teamSteps.clickAddButton();
        teamSteps.addTeamMember(teamMember);
        teamSteps.clickSendInvitationButton();
        teamSteps.waitABit(1000);
        teamSteps.checkNewInvitationPending(teamMember);
    }
}
