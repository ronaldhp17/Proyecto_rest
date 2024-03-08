package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static utils.enums.RestService.UPDATE_EMPLOYE;

public class WithPut implements Interaction {
    private String body;

    public WithPut(String body) {
        this.body = body;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to(UPDATE_EMPLOYE.toString()).with(requestSpecification -> requestSpecification.
                headers("Content-Type", "application/json").body(body)));
    }
}
