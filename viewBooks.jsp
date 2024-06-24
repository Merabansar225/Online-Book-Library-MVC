<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Autumn Tales Collection</title>

<!-- Include Bootstrap CSS and JavaScript + jQuery -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- Include FontAwesome -->
<script src="https://kit.fontawesome.com/c44302f88f.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

<!-- Custom CSS and JavaScript -->
<link rel="stylesheet" href="./css/main.css" type="text/css" />

<!-- Google Font -->
<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville&display=swap" rel="stylesheet">


<style>
@import
	url('https://fonts.googleapis.com/css2?family=Dancing+Script&family=Fasthand&family=Inconsolata&family=Libre+Baskerville&family=Permanent+Marker&display=swap')
	;

h1 {
	font-size: 42px;
	font-family: 'Permanent Marker', cursive;
}

.subheading {
	font-size: 18px;
	font-weight: normal;
	font-family: 'Dancing Script', cursive;
}

.card {
	height: 100%;
}

.card-body {
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	margin
}
</style>
</head>

<body>

<!-- Header --> 

	<div class="header">
		<h1>Autumn Tales Collection &nbsp; &#x1F342;</h1>
		<h2 class="subheading">Leaves may fall, but our stories will lift you up!</h2>
 		<div class="row"> <!-- It helps organize the layout of the elements on the page. If you remove this, the layout might not be as intended, and the elements could become misaligned. -->
 			<div class="col-md-8"> <!-- this is a bootstrap grid system that ensures the search tab and add new book button are in the correct place-->
				<!-- Search Tab -->
				<form class="form-inline search-form" action="./search" method="get">
					<input class="form-control mr-sm-2 search-input" type="search"
						name="search" placeholder="Search">
					<button class="btn btn-primary" type="submit">
						<i class="fa-solid fa-search"></i> &nbsp; Search
					</button>
				</form>
			</div>
			<!-- Add new book button -->
			<div class="col-md-4">
				<a href="./insertBook.jsp" class="btn btn-primary"> <i
					class="fas fa-book-medical"></i> &nbsp; Add New Book
				</a>
			</div>
 		</div>
 	</div>




<!-- Book Display using Cards from Bootstrap-->
<div class="container mt-3">
  <div class="row">
    <c:forEach var="book" items="${books}">
      <div class="col-md-4">
        <div class="card mb-4">
          <div class="card-body">
            <h5 class="card-title">${book.title}</h5>
            <h6 class="card-subtitle mb-2 text-muted">${book.author}</h6>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#booksInfo${book.id}">
              View Details
            </button>
          </div>
        </div>
      </div>

      <!-- Book Details Pop-up Modal -->
      <div class="modal fade" id="booksInfo${book.id}" tabindex="-1" role="dialog" aria-labelledby="booksInfo${book.id}" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="booksInfoTitle">${book.title}</h5><br>
              <h4 class="modal-subtitle text-muted" id="booksInfoAuthor">${book.author}</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <p><strong>ID:</strong> ${book.id}<br></p>
              <p><strong>Date:</strong> ${book.date}<br></p>
              <p><strong>Genres:</strong> ${book.genres}<br></p>
              <p><strong>Characters:</strong> ${book.characters}<br></p>
              <p><strong>Synopsis:</strong> ${book.synopsis}</p>
            </div>
				<div class="modal-footer">
					<div class="action-buttons">
						<a href="./update?id=${book.id}" class="btn btn-warning"
							data-toggle="tooltip" data-placement="top" title="Edit"> <i
							class="fas fa-edit"></i>
						</a> &nbsp; <a href="./delete?id=${book.id}" class="btn btn-danger"
							data-toggle="tooltip" data-placement="top" title="Delete">
							<i class="fas fa-trash"></i>
						</a>
					</div>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>




</body>
</html>

