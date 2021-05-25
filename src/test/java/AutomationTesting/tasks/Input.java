package AutomationTesting.tasks;

import AutomationTesting.abilities.GetInfoLogin;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static AutomationTesting.ui.LoginPageUI.*;


public class Input implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.keyValues(getInfoLogin(actor).getUsername()).into(USER_NAME),
                Enter.keyValues(getInfoLogin(actor).getPassword()).into(PASSWORD),
                Click.on(LOGIN_BTN)

        );
    }
    public static Performable validData() {
        return Tasks.instrumented(Input.class);
    }

    private GetInfoLogin getInfoLogin(Actor actor){
        return GetInfoLogin.getInfoLogin(actor);
    }

}
