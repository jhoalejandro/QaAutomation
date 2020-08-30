package co.com.aut.example.photos.models;

public class PhotoModel {

	private static final String  API_SERVICE_NAME = "/photos";

	private Integer albumId;
	private Integer id;
	private String tittle;
	private String url;
	private String thumbnailUrl;

	public static String getApiServiceName() {
		return API_SERVICE_NAME;
	}
	public Integer getAlbumId() {
		return albumId;
	}
	public Integer getId() {
		return id;
	}
	public String gettittle() {
		return tittle;
	}
	public String getUrl() {
		return url;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}


	public static class Builder {

		private PhotoModel photoModel = new PhotoModel();


		private Builder (String tittle)
		{
			photoModel.tittle=tittle;
		}
		
		public static  Builder withTittle (String tittle)
		{
			return new Builder(tittle);
		}
		
		public  PhotoModel andWithUrl (String url)
		{
			photoModel.url= url;			
			return photoModel;
		}

	}

}
