package co.com.choucair.services.dummyapi.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.ModelToDummyapi;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import questions.*;
import tasks.CreateUserRest;
import tasks.UpdateUser;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static utils.Constant.*;
import static utils.enums.RestService.*;

public class StepdefinitionsRestDummyapi {
    @When("i queriying employees")
    public void iQueriyingEmployees() throws InterruptedException {
        Thread.sleep(60000);
        theActorInTheSpotlight().attemptsTo(Get.resource(GET_EMPLOYEES.toString()));
    }

    @Then("employees are displayed")
    public void employeesAreDisplayed() {
        theActorInTheSpotlight().should(seeThat(ValidateResponseGetEmployees.is(VALUE_GET_EMPLOYEES)));
    }

    @When("i queriyin a employ by id")
    public void iQueriyinAEmployById() throws InterruptedException {
        Thread.sleep(60000);
        theActorInTheSpotlight().attemptsTo(Get.resource(GET_AN_EMPLOY.toString()));
    }

    @Then("the employ is displayed")
    public void theEmployIsDisplayed() {
        theActorInTheSpotlight().should(seeThat(ValidateResponseGetEmploye.is(VALUE_GET_EMPLOYE)));
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
        Thread.sleep(60000);
        theActorInTheSpotlight().attemptsTo(Delete.from(DELETE_EMPLOY.toString()));
    }

    @Then("i should see success deleted")
    public void iShouldSeeSuccessDeleted() {
        theActorInTheSpotlight().should(seeThat(ValidateResponseDelete.is(VALUE_DELETE_EMPLOYE)));
    }
}
