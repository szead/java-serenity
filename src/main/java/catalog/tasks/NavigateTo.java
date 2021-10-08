package catalog.tasks;

import catalog.ui.login.CatalogLoginPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable theCatalogLoginPage(){
        return Task.where("{0} opens the Catalog login page",
                Open.browserOn().the(CatalogLoginPage.class));
    }
}
