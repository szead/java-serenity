package catalog.questions;

import catalog.ui.dashboard.CatalogNavbar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("the logged in username is '#username'")
public class LoggedIn implements Question<Boolean>{

    private String username;

    public LoggedIn(String username) {
        this.username = username;
    }

    public static LoggedIn with(String username) {
        return new LoggedIn(username);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CatalogNavbar.USERNAME.of(username).resolveFor(actor).isDisplayed();
    }

}
