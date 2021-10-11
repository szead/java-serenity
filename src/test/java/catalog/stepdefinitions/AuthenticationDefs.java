package catalog.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.Matchers.containsString;

import io.restassured.parsing.Parser;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import net.serenitybdd.screenplay.rest.interactions.Get;
import catalog.ui.dashboard.CatalogNavbar;
import catalog.tasks.LogIn;
import catalog.tasks.NavigateTo;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
//https://serenity-bdd.github.io/theserenitybook/latest/serenity-screenplay-ensure.html
public class AuthenticationDefs {
    @Given("{actor} creates a canvas account")
    public void canvasCreatesACanvasAccount(Actor actor) {
//        actor.attemptsTo(Post.to("/user"));
    }

    private EnvironmentVariables environmentVariables;

    @When("{actor} logs in to catalog")
    public void sheLogsInToCatalog(Actor actor) {
        String password = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("custom.password");
        System.out.println(password);
        System.out.println(System.getProperty("custom.password"));
        actor.attemptsTo(
                NavigateTo.theCatalogLoginPage(),
                LogIn.with("adam.szentivanyi+serenity_test@instructure",password));
    }

    @Then("{actor} see the catalog homepage")
    public void sheSeeTheCatalogHomepage(Actor actor) {
        actor.attemptsTo(net.serenitybdd.screenplay.ensure.Ensure
                .that(CatalogNavbar.LOGO)
                .isDisplayed());
        actor.should(
                seeThat(
                        Presence.of(CatalogNavbar.LOGO).asABoolean(),
                        equalTo(true)));
    }

    @Given("{actor} sends a health check in API to {string}")
    public void aliceSendsAHealthCheckInAPITo(Actor actor, String endpoint) {

        actor.wasAbleTo(Get.resource(endpoint));
    }

    @Then("{actor} get back OK")
    public void sheGetBackOK(Actor actor) {
        actor.should(
                seeThatResponse("Response is 200",
                        response -> response.statusCode(200)));
        actor.should(
                seeThatResponse(response -> response.using().defaultParser(Parser.TEXT).body(containsString("OK")))
        );
        actor.attemptsTo(
                Ensure.that("Health Check is okay",
                        response -> response.statusCode(200)
                                .using()
                                .defaultParser(Parser.TEXT)
                                .body(equalTo("OK"))));
    }

    @Then("{actor} get back {string}")
    public void sheGetBack(Actor actor, String expectedResponseBody) {
        actor.attemptsTo(
                Ensure.that("Health check json is okay",
                        response -> response.body("health", equalTo(expectedResponseBody))));
    }
}
