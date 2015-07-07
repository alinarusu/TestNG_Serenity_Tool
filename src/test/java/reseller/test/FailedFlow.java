package reseller.test;

import org.testng.annotations.Test;

/**
 * Created by rusu on 3/24/15.
 */

public class FailedFlow extends BaseFlow {
    @Test
    public void failed_test() {
        demoSteps.waitABit();
        demoSteps.failed_step();
    }
}
