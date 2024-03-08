package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateResponseDelete implements Question<Boolean>{
    private String valueSearch;

    public ValidateResponseDelete(String valueSearch) {
        this.valueSearch = valueSearch;
    }

    public static ValidateResponseDelete is(String valueSearch) {
        return new ValidateResponseDelete(valueSearch);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String response = SerenityRest.lastResponse().body().asString();
        return response.contains(valueSearch);
    }
}
