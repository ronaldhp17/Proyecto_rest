package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class ValidateResponsePut implements Question<Boolean> {
    private String valueSearch;

    public ValidateResponsePut(String valueSearch) {
        this.valueSearch = valueSearch;
    }

    public static ValidateResponsePut is(String valueSearch) {
        return new ValidateResponsePut(valueSearch);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String response = SerenityRest.lastResponse().body().asString();
        return response.contains(valueSearch);
    }
}
