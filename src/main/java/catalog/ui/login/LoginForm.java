package catalog.ui.login;

import net.serenitybdd.screenplay.targets.Target;


public class LoginForm {

    public static Target EMAIL = Target.the("Email").locatedBy("#pseudonym_session_unique_id");
    public static Target PASSWORD = Target.the("Password").locatedBy("#pseudonym_session_password");
    public static Target SUBMIT = Target.the("Submit").locatedBy("//button[contains(text(),'Log In')]");

}
