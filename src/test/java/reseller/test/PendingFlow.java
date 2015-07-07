package reseller.test;

import net.thucydides.core.annotations.Pending;
import org.testng.annotations.Test;

/**
 * Created by rusu on 6/17/15.
 */
public class PendingFlow extends BaseFlow {
    @Pending
    @Test
    public void aPendingTest() {
    }
}
