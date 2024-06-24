<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Book Details</title>

<!-- Include Bootstrap CSS and JavaScript -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- Custom CSS and FontAwesome -->
<link rel="stylesheet" href="./css/insert.css" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

<!-- Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Libre+Baskerville&display=swap" rel="stylesheet">

</head>

<body>

	<!-- Header -->
	<div class="header">
		<h2>Insert New Book &nbsp; &#x1F342;</h2>
	</div>

	<!-- Form container -->
	<div class="container">
		<form action="./insert" method="POST">

			<label for="title">Title</label> 
			<input type="text" id="title" name="title" class="form-control" placeholder="Add Book Title" required> <br> 
			
			<label for="author">Author</label> 
			<input type="text" id="author" name="author" class="form-control" placeholder="Who are the authors?" required> <br> 
				
			<label for="date">Date Published</label>
			<input type="date" id="date" name="date" class="form-control" required> <br> 
			
			<label for="genres">Genres</label>
			<input type="text" id="genres" name="genres" class="form-control" placeholder="Genres of the Book" required> <br> 
			
			<label for="characters">Characters</label> 
			<input type="text" id="characters" name="characters" class="form-control" placeholder="Main Characters of the Book" required> <br> 
				
			<label for="synopsis">Synopsis</label>
			<input type="text" id="synopsis" name="synopsis" class="form-control" placeholder="Provide a synopsis" required> 
			
			<input type="submit" value="Insert Book" class="btn btn-primary">

		</form>
	</div>

</body>
</html>