package catalog.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import catalog.ui.login.LoginForm;

public class LogIn implements Task {

    private final String email;
    private final String password;

    public LogIn(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static LogIn with(String username, String password) {
        return instrumented(LogIn.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(LoginForm.EMAIL),
                Enter.theValue(password).into(LoginForm.PASSWORD),
                Click.on(LoginForm.SUBMIT)
        );
    }
}
