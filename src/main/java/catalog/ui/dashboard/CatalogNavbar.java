package catalog.ui.dashboard;


import net.serenitybdd.screenplay.targets.Target;

public class CatalogNavbar {

    public static Target LOGO = Target.the("Nav Logo").locatedBy("//h1");
    public static Target USERNAME = Target.the("Username {0}").locatedBy("//button[@id='accountDropdown']//span[contains(text(),'{0}')]");
}
