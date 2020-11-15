package co.com.aut.example.photos.steps;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.util.EnvironmentVariables;

public class AutenticarseAbility implements Ability {

	private EnvironmentVariables env;
	private String nombre;
	private String clave;

	public String nombre() {
		return nombre;
	}

	public String clave() {
		return clave;
	}

	public AutenticarseAbility(String rol) {
		//this.nombre = EnvironmentSpecificConfiguration.from(env).getProperty("my.webservice.endpoint");
		this.nombre = 		env.getProperty("my.webservice.endpoint");

		this.clave = "clave";
	}

	public static AutenticarseAbility como(String rol) {
		return new AutenticarseAbility(rol);
	}

	public static AutenticarseAbility as(Actor actor) {
		return actor.abilityTo(AutenticarseAbility.class);
	}
}
