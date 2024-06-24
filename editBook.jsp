<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book Details</title>

<!-- Include Bootstrap CSS and JavaScript - Even though jQuery and Popper.js are not directly used in the code, they are dependencies for Bootstrap's JavaScript components. It's recommended to keep them for the Bootstrap components to work correctly.-->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- Custom CSS and FontAwesome -->
<link rel="stylesheet" href="./css/edit.css" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

<!-- Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Libre+Baskerville&display=swap" rel="stylesheet">

</head>

<body>

	<!-- Header -->
	<div class="header">
		<h2>Update Book Details&nbsp;&#x1F342;</h2>
	</div>

	<!-- Form container -->
	<div class="container">
		<form action="./update" method="POST">

			<label for="name">Id</label> 
			<input type="text" id="id" name="id" value="${currBook.id}" readonly class="form-control"> <br>

			<label for="title">Title</label> 
			<input type="text" id="title" name="title" value="${currBook.title}" class="form-control"> <br> 
			
			<label for="author">Author</label> 
			<input type="text" id="author" name="author" value="${currBook.author}" class="form-control"> <br> 
				
			<label for="date">Date</label>
			<input type="text" id="date" name="date" value="${currBook.date}" class="form-control"> <br> 
			
			<label for="genres">Genres</label>
			<input type="text" id="genres" name="genres" value="${currBook.genres}" class="form-control"> <br> 
			
			<label for="characters">Characters</label> 
			<input type="text" id="characters" name="characters" value="${currBook.characters}" class="form-control"> <br> 
				
			<label for="synopsis">Synopsis</label>
			<input type="text" id="synopsis" name="synopsis" value="${currBook.synopsis}" class="form-control"> 
			
			<input type="submit" value="Update Book" class="btn btn-primary">

		</form>
	</div>

</body>
</html>