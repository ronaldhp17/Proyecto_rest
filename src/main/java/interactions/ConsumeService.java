package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.Actor;

public class ConsumeService {

    private ConsumeService() {
    }

    public static WithPost withPost(String body) {
        return Tasks.instrumented(WithPost.class, body);
    }

    public static WithPut withPut(String body) {
        return Tasks.instrumented(WithPut.class, body);
    }
}
