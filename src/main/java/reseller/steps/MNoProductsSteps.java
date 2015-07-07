package reseller.steps;

import net.thucydides.core.pages.Pages;
import reseller.pages.ModalNoProducts;

/**
 * Created by rusu on 3/24/15.
 */

public class MNoProductsSteps extends BaseSteps {
    public MNoProductsSteps() {
        super();
    }

    public MNoProductsSteps(Pages pages) {
        super(pages);
    }

    public ModalNoProducts modalNoProducts() {
        return getPages().currentPageAt(ModalNoProducts.class);
    }
}
