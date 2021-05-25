package AutomationTesting.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPageUI {
    public final static Target USER_NAME = Target.the("username ").located(By.name("uid"));
    public final static Target PASSWORD = Target.the("password").located(By.name("password"));
    public final static Target LOGIN_BTN = Target.the("loginBtn").located(By.name("btnLogin"));


}
