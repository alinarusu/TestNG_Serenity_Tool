package reseller.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import reseller.pages.ModalPendingInvitations;

/**
 * Created by rusu on 3/24/15.
 */

public class MPendingInvitationsSteps extends BaseSteps {
    public MPendingInvitationsSteps() {
        super();
    }

    public MPendingInvitationsSteps(Pages pages) {
        super(pages);
    }

    public ModalPendingInvitations modalPendingInvitations() {
        return getPages().currentPageAt(ModalPendingInvitations.class);
    }

    @Step("At the end, check if the member just added is found in page")
    public void isMemberAdded(String email) {
        Boolean ok = modalPendingInvitations().isMemberAdded(email);
        if (ok == true) {
            System.out.println("OK!");
        } else System.out.println("Failed");
    }
}
