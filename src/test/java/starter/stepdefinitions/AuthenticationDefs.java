package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class AuthenticationDefs {
    @When("{actor} logs in to catalog")
    public void sheLogsInToCatalog(Actor actor) {

    }

    @Given("{actor} creates a canvas account")
    public void canvasCreatesACanvasAccount(Actor actor) {
        actor.attemptsTo(Get.resource("healthcheck"));
    }

    @Then("{actor} see the catalog homepage")
    public void sheSeeTheCatalogHomepage(Actor actor) {

    }
}
