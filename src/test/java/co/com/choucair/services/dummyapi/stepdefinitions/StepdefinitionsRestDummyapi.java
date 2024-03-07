package co.com.choucair.services.dummyapi.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.ModelToDummyapi;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import questions.ValidateResponsePost;
import questions.ValidateResponsePut;
import tasks.CreateUserRest;
import tasks.UpdateUser;
import utils.Constant;

import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.assertj.core.api.Assertions.assertThat;
import static utils.Constant.*;
import static utils.enums.RestService.*;

public class StepdefinitionsRestDummyapi {
    @When("i queriying employees")
    public void iQueriyingEmployees() throws InterruptedException {
        TimeUnit.SECONDS.sleep(60);
        theActorInTheSpotlight().attemptsTo(Get.resource(GET_EMPLOYEES.toString()));
    }

    @Then("employees are displayed")
    public void employeesAreDisplayed() throws InterruptedException {
        TimeUnit.SECONDS.sleep(60);
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(VALUE_GET_EMPLOYEES);
    }

    @When("i queriyin a employ by id")
    public void iQueriyinAEmployById() throws InterruptedException {
        TimeUnit.SECONDS.sleep(60);
        theActorInTheSpotlight().attemptsTo(Get.resource(GET_AN_EMPLOY.toString()));
    }

    @Then("the employ is displayed")
    public void theEmployIsDisplayed() throws InterruptedException {
        TimeUnit.SECONDS.sleep(60);
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(VALUE_GET_EMPLOYE);
    }

    @When("i create an user")
    public void iCreateAnUser(io.cucumber.datatable.DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(CreateUserRest.with(ModelToDummyapi.setData(dataTable).get(0)));
    }

    @Then("i should see success create")
    public void iShouldSeeSuccessCreate() {
        theActorInTheSpotlight().should(seeThat(ValidateResponsePost.is(VALUE_CREATE_EMPLOYE)));
    }

    @When("i update an user with Put method")
    public void iUpdateAnUserWithPutMethod(io.cucumber.datatable.DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(UpdateUser.with(ModelToDummyapi.setData(dataTable).get(0)));
    }

    @Then("i should see success update")
    public void iShouldSeeSuccessUpdate() {
        theActorInTheSpotlight().should(seeThat(ValidateResponsePut.is(VALUE_UPDATE_EMPLOYE)));
    }

    @When("i delete an user")
    public void iDeleteAnUser() throws InterruptedException {
        TimeUnit.SECONDS.sleep(60);
        theActorInTheSpotlight().attemptsTo(Delete.from(DELETE_EMPLOY.toString()));
    }

    @Then("i should see success deleted")
    public void iShouldSeeSuccessDeleted() throws InterruptedException {
        TimeUnit.SECONDS.sleep(60);
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(VALUE_DELETE_EMPLOYE);
    }
}
