package AutomationTesting.features.search;

import AutomationTesting.abilities.GetInfoLogin;
import AutomationTesting.tasks.Input;
import AutomationTesting.tasks.Launch;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class LoginToGuruDemo {
    Actor Rose = Actor.named("Rose");

    @Managed
    WebDriver herBrowser;

    @Before
    public void roseOnTheStage(){
        Rose.can(BrowseTheWeb.with(herBrowser))
        .whoCan(GetInfoLogin.fromHerLoginProfile());
    }


    @Test
    public void should_be_able_to_login_to_Guru99Page(){
        Rose.wasAbleTo(Launch.theLoginPage());
        Rose.attemptsTo(Input.validData());
        Rose.should(eventually(seeThat(TheWebPage.title(), containsString("Guru99 Bank Manager HomePage"))));
    }
}
