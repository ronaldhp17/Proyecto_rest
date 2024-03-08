package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateResponsePost implements Question<Boolean> {
    private String valueSearch;

    public ValidateResponsePost(String valueSearch) {
        this.valueSearch = valueSearch;
    }

    public static ValidateResponsePost is(String valueSearch) {
        return new ValidateResponsePost(valueSearch);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String response = SerenityRest.lastResponse().body().asString();
        return response.contains(valueSearch);
    }
}
