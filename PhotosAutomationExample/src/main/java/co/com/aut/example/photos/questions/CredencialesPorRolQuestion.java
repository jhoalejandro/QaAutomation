package co.com.aut.example.photos.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.thucydides.core.util.EnvironmentVariables;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;

@Subject("Las credenciales de usuario")
public class CredencialesPorRolQuestion implements Question<String> {

	private EnvironmentVariables environmentVariables;

	@Override
	public String answeredBy(Actor actor) {
		// TODO Auto-generated method stub
		return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("my.webservice.endpoint");
	}

	public static CredencialesPorRolQuestion elUsuarioEs() {
		return new CredencialesPorRolQuestion();
	}

}
