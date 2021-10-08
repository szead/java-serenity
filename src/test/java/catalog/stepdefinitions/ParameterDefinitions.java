package catalog.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class ParameterDefinitions {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        if (actorName.equals("Canvas")) {
//            SerenityRest.config()
            return OnStage.theActorCalled(actorName).whoCan(CallAnApi.at("https://szead-spring-test.herokuapp.com/"));
        } else {
            return OnStage.theActorCalled(actorName);
        }
    }

    @Before
    public void setTheStage() {
//        SerenityRest.setDefaultParser(Parser.TEXT);
        OnStage.setTheStage(new OnlineCast());
    }
}
