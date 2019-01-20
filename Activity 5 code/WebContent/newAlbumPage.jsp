<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Masterful Music New Album Page</title>
<jsp:include page="/includes/navBarTop.jsp" />
</head>
<body>
	<form name="newAlbumForm" action="" method="post">
		<h1>Welcome to Masterful Music</h1><br /><br/>
		<label for="AlbumTitleInput">ALBUM TITLE</label><br />
		<input type="text" value="Enter the album title..." name="AlbumTitleInput"/><br/><br/>
		<label for="ArtistTitleInput">ALBUM ARTIST</label><br/>
		<input type="text" value="Enter the album artist..." name="ArtistTitleInput" /><br/><br/>
		<input type="submit" value="Submit" name="newAlbumBTN" />
	</form>
</body>
</html>