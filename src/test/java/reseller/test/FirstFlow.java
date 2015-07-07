package reseller.test;

import org.testng.annotations.Test;

/**
 * Created by rusu on 4/1/15.
 */

public class FirstFlow extends BaseFlow {

    @Test
    public void firstSimpleFlow() {
        demoSteps.waitABit();
        demoSteps.getStarted();
    }

    @Test
    public void test2(){
        demoSteps.waitABit();
    }
}
