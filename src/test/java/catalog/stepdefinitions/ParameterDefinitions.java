package catalog.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class ParameterDefinitions {

    private EnvironmentVariables environmentVariables;

    @ParameterType(".*")
    public Actor actor(String actorName) {
        if (actorName.equals("Canvas")) {
            String api_url = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("heroku.api");
            return OnStage.theActorCalled(actorName).whoCan(CallAnApi.at(api_url));
        } else {
            return OnStage.theActorCalled(actorName);
        }
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
}
