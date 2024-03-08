package tasks;

import interactions.ConsumeService;
import models.ModelToDummyapi;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.concurrent.TimeUnit;

public class CreateUserRest implements Task {
    private ModelToDummyapi modelToDummyapi;

    public CreateUserRest(ModelToDummyapi modelToDummyapi) {
        this.modelToDummyapi = modelToDummyapi;
    }

    public static CreateUserRest with(ModelToDummyapi modelToDummyapi) {
        return Instrumented.instanceOf(CreateUserRest.class).withProperties(modelToDummyapi);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException error) {
            throw new RuntimeException(error);
        }
        actor.attemptsTo(ConsumeService.withPost(modelToDummyapi.toString()));
    }
}
