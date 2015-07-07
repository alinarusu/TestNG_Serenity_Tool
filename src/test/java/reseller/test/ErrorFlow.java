package reseller.test;

import net.thucydides.core.annotations.Story;
import org.testng.annotations.Test;

/**
 * Created by rusu on 6/29/15.
 */
@Story(ErrorFlow.class)
public class ErrorFlow extends BaseFlow {
    @Test
    public void error_test() {
        mPendingInvitationsSteps.modalPendingInvitations();
    }
}
