This README file contains the instructions for the MVC Assignment project and the SOAP project.

# MVC ASSIGNMENT - AUTUMN TALES COLLECTION

This is my MVC application project for the Cloud and Enterprise Module which allows you to manage a bookstore's inventory by allowing you to Create, Read, Update, and Delete (CRUD) books in the database. The structure of the application is created by using Bootstrap's cards functionality. 

## PACKAGES AND CLASSES OVERVIEW
- controllers: This package contains all controller classes which handle incoming HTTP requests, and correspond to specific operations:

	- BooksController.java: This is the main controller with the doGet, doPost, doPut and doDelete functionalities.
	- DeleteBookController.java: This controller handles the deletion of books.
	- InsertBookController.java: This controller manages the insertion of new books.
	- SearchBookController.java: This controller controls the search operation for books.
	- UpdateBookController.java: This controller is responsible for updating a books information.


- database: This package includes classes related to database connectivity and CRUD operations:
	- BookDAO.java: This class communicates with my mySQL database, and provides all CRUD operations for books.


- models: This package contains a model class which defines the structure of the book object:
	- Book.java: This class represents the structure of a book object.

- web app: This directory contains the view component (JSP files) and CSS stylesheets:
	- viewBooks.jsp: The main page of the website showing all books.
	- insertBook.jsp: The page with a form for inserting a new book into the system.
	- updateBook.jsp: The page with a form for updating existing book details.
	- css directory: Contains stylesheets corresponding to each JSP page.

## RUNNING THE APPLICATION
To run the application, simply navigate to the controllers package and run the BooksController class.

## NOTES ON STYLES
The styling for the JSP pages is contained within the css directory in the webapp folder. Each page has a corresponding stylesheet:

	- edit.css for the editBook.jsp
	- insert.css for the insertBook.jsp
	- main.css for the viewBooks.jsp

