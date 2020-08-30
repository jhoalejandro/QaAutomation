package co.com.aut.example.photos.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

@Subject("El album id de la foto")
public class PhotoAlbumIdQuestion implements Question<Integer>{

	@Override
	public Integer answeredBy(Actor actor) {
		// TODO Auto-generated method stub
		return lastResponse().jsonPath().getInt("[0].albumId");
	}
	
	public static PhotoAlbumIdQuestion photoAlbumIdIs() {
			return new PhotoAlbumIdQuestion();
	}

}
