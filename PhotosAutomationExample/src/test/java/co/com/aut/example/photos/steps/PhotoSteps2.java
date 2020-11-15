package co.com.aut.example.photos.steps;

import static co.com.aut.example.photos.tasks.PhotoTask.getPhotoInformation;
import static co.com.aut.example.photos.models.PhotoModel.Builder.withTittle;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.util.EnvironmentVariables;


public class PhotoSteps2 {

	String titulo;
	String url;
	Integer id;
	private EnvironmentVariables environmentVariables;
	private static final Actor ACTOR = Actor.named("Juan");
	private boolean pruebaexitosa = true;

	@Given("la foto con id {int}")
	public void setId(Integer id) {
		System.out.println("given");
	}

	@When("la consulta la fotografia")
	public void getPhoto() {
		System.out.println("accion " + environmentVariables.getProperty("restapi.baseurl"));
	}

	@Then("^la consulta de la fotografia es (.+)$")
	public void assertPhotoTitulo(String titulo) {
		System.out.println("assert " + titulo);
		if (titulo.contentEquals("alejo")) {
			pruebaexitosa = false;
		}
	}

}
