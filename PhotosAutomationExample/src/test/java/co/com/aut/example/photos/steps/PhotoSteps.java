package co.com.aut.example.photos.steps;

import static co.com.aut.example.photos.tasks.PhotoTask.getPhotoInformation;
import static co.com.aut.example.photos.models.PhotoModel.Builder.withTittle;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import static co.com.aut.example.photos.questions.PhotoIdQuestion.photoIdIs;
import static co.com.aut.example.photos.questions.PhotoAlbumIdQuestion.photoAlbumIdIs;

import static org.hamcrest.CoreMatchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PhotoSteps {

	private String theRestApiBaseUrl;
	private EnvironmentVariables environmentVariables;

	String titulo;
	String url;
	Integer id;

	private static final Actor ACTOR = Actor.named("Alejandro");

	@Before
	public void setupScenario() {
		theRestApiBaseUrl = environmentVariables.getProperty("restapi.baseurl");
		ACTOR.whoCan(CallAnApi.at(theRestApiBaseUrl)); 
	}

	@Given("que tengo una fotografia con id {int}")
	public void setId(Integer id) {
		this.id=id;
	}

	@Given(".*la fotografia con titulo (.+)$")
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Given("con url {string}")
	public void setUrl(String url) {
		this.url=url;
	}

	@When("consulto la fotografia")
	public void getPhoto() {
		ACTOR.attemptsTo(getPhotoInformation (withTittle(titulo)
				.andWithUrl(url)));
	}

	@Then("el titulo de la fotografia es {string}")
	public void assertPhotoTitulo(String titulo) {
	}

	@Then("el id de la fotografia es {int}")
	public void assertPhotoId(Integer id) {
		ACTOR.should(seeThat(photoIdIs(), equalTo(id)));	}

	@Then("el id del album es {int}")
	public void assertAlbumId(Integer albumId) {
		ACTOR.should(seeThat(photoAlbumIdIs(), equalTo(albumId)));	}

}

