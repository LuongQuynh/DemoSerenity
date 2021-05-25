package AutomationTesting.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetInfoLogin implements Ability {
    private String username;
    private String password;

    public GetInfoLogin(String username, String password){
        this.username=username;
        this.password=password;
    }


    public static GetInfoLogin fromHerLoginProfile() {
        FileReader reader = null;
        Properties properties = null;
        try{
            reader= new FileReader("src\\test\\resources\\loginInfo.properties");
            properties = new Properties();
            properties.load(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new GetInfoLogin(
                properties.getProperty("Username"),
                properties.getProperty("Password")
        );

    }

    public static GetInfoLogin getInfoLogin (Actor actor) {
        return actor.abilityTo(GetInfoLogin.class);
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
