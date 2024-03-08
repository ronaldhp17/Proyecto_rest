package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import utils.Constant;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.Constant.VALUE_CREATE_EMPLOYE;
import static utils.Constant.VALUE_UPDATE_EMPLOYE;
import static utils.enums.RestService.CREATE_EMPLOYE;
import static utils.enums.RestService.UPDATE_EMPLOYE;

public class ValidateResponsePut implements Question<Boolean> {
    private int code;

    public ValidateResponsePut(int code) {
        this.code = code;
    }

    public static ValidateResponsePut is(int code) {
        return new ValidateResponsePut(code);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        int response = SerenityRest.lastResponse().statusCode();
        return response == code;
    }
}
