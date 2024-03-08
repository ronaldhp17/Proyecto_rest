package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateResponseGetEmploye implements Question<Boolean> {
    private String valueSearch;

    public ValidateResponseGetEmploye(String valueSearch) {
        this.valueSearch = valueSearch;
    }

    public static ValidateResponseGetEmploye is(String valueSearch) {
        return new ValidateResponseGetEmploye(valueSearch);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String response = SerenityRest.lastResponse().body().asString();
        return response.contains(valueSearch);
    }
}
