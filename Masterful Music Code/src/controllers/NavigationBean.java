package controllers;

public class NavigationBean {
	
	private String homePage = "<jsp:forward page='/index.jsp' />";
	private String newAlbumPage = "<jsp:forward page=''/newAlbumPage.jsp' />";
	
	public String homePageNavigation () {
		return homePage;
	}
	public String newAlbumNavigation () {
		return newAlbumPage;
	}
}
