package reseller.steps;

import net.thucydides.core.pages.Pages;
import reseller.pages.ModalPendingRequest;

/**
 * Created by rusu on 3/24/15.
 */
public class MPendingRequestSteps extends BaseSteps {
    public MPendingRequestSteps() {
        super();
    }

    public MPendingRequestSteps(Pages pages) {
        super(pages);
    }

    public ModalPendingRequest modalPendingRequest() {
        return getPages().currentPageAt(ModalPendingRequest.class);
    }
}
