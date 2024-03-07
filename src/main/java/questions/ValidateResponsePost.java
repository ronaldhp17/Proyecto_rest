package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import utils.Constant;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.Constant.VALUE_CREATE_EMPLOYE;
import static utils.enums.RestService.CREATE_EMPLOYE;

public class ValidateResponsePost implements Question<Boolean> {
    private int code;

    public ValidateResponsePost(int code) {
        this.code = code;
    }

    public static ValidateResponsePost is(int code) {
        return new ValidateResponsePost(code);
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int response = SerenityRest.lastResponse().statusCode();
        return response == code;
    }
}
