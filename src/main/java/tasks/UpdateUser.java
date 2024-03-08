package tasks;

import interactions.ConsumeService;
import models.ModelToDummyapi;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.concurrent.TimeUnit;

public class UpdateUser implements Task {

    private ModelToDummyapi modelToDummyapi;

    public UpdateUser(ModelToDummyapi modelToDummyapi) {
        this.modelToDummyapi = modelToDummyapi;
    }

    public static UpdateUser with(ModelToDummyapi modelToDummyapi) {
        return Instrumented.instanceOf(UpdateUser.class).withProperties(modelToDummyapi);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(ConsumeService.withPut(modelToDummyapi.toString()));
    }
}
