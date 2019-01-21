<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Search for Albums</title>
</head>
<body>
	<%-- Form to execute the search --%>
	<form name="searchForm" action="#{restClient.fetchAlbum()}" method="get">
		<label for="AlbumTitleSearch">ALBUM TITLE</label><br />
		<input type="text" value="Enter the album title to search..." name="AlbumTitleSearch"/><br/><br/>
		<label for="ArtistTitleSearch">ALBUM ARTIST</label><br/>
		<input type="text" value="Enter the album artist to search..." name="ArtistTitleSearch" /><br/><br/>
		<input type="submit" value="Search" name="searchAlbumBTN" />
	</form>
	<%-- Find out how to use an object to save the page parameters and submit them to the action method --%>
	
	<%-- Space to display the album searched for --%>
	<p name="SearchLististDisplay">
	
	</p>
</body>
</html>