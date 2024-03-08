package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateResponseGetEmployees implements Question<Boolean> {
    private final String valueSearch;

    public ValidateResponseGetEmployees(String valueSearch) {
        this.valueSearch = valueSearch;
    }

    public static ValidateResponseGetEmployees is(String valueSearch) {
        return new ValidateResponseGetEmployees(valueSearch);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String response = SerenityRest.lastResponse().body().asString();
        return response.contains(valueSearch);
    }
}
