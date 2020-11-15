package co.com.aut.example.photos.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.aut.example.photos.models.PhotoModel;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.util.EnvironmentVariables;

public class PhotoTask implements Task {

	private PhotoModel photoModel;
	private EnvironmentVariables env;

	public PhotoTask(PhotoModel photoModel) {
		this.photoModel = photoModel;
	}

	@Override
//	public <T extends Actor> void performAs(T actor) {
//		actor.attemptsTo(Get.resource(PhotoModel.getApiServiceName())
//				.with(request -> request.header(null)
//						.queryParam("tittle", photoModel.gettittle())
//						.queryParam("url", photoModel.getUrl())));
//	}
//

	public <T extends Actor> void performAs(T actor) {
		System.out.println(
				"LoginTaskJAG" + EnvironmentSpecificConfiguration.from(env).getProperty("my.webservice.endpoint"));
		System.out.println("Titulo" + photoModel.gettittle());
		actor.attemptsTo(Get.resource(PhotoModel.getApiServiceName()).with(request -> request
				.queryParam("tittle", photoModel.gettittle()).queryParam("url", photoModel.getUrl())));
	}

	public static PhotoTask getPhotoInformation(PhotoModel photoModel) {
		return instrumented(PhotoTask.class, photoModel);
	}
}
