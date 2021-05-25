package AutomationTesting.tasks;

import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class Launch implements Task {

    LoginPage loginPage;

    @Override
    @Step("{0} open the login page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(loginPage )
        );
    }
    public static Performable theLoginPage(){
        return Tasks.instrumented(Launch.class);
    }
}
