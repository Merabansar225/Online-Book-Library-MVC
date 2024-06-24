package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.BookDAO;
import models.Book;


@WebServlet("/books")
public class BooksController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	// GET request to retrieve all books
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookDAO dao = new BookDAO();
		ArrayList<Book> allBooks = dao.getAllBooks();
		request.setAttribute("books", allBooks);
		RequestDispatcher rd = request.getRequestDispatcher("viewBooks.jsp");
		rd.include(request, response);

	}


	// POST request to add a new book
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Retrieve book details from the request parameters
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String date = request.getParameter("date");
		String genres = request.getParameter("genres");
		String characters = request.getParameter("characters");
		String synopsis = request.getParameter("synopsis");

		BookDAO dao = new BookDAO();
		Book book = new Book(title, author, date, genres, characters, synopsis);

		// Print the book details for debugging
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("Date: " + date);
		System.out.println("Genres: " + genres);
		System.out.println("Characters: " + characters);
		System.out.println("Synopsis: " + synopsis);

		// Insert the new book into the database
		try {
			dao.insertBook(book);

		} catch (SQLException se) {
			System.out.println(se.getMessage());


		}
		// Redirect the user to the books page
		response.sendRedirect("./books");
	}

	// PUT request to update a book
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Retrieve book details from the request parameters
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String date = request.getParameter("date");
		String genres = request.getParameter("genres");
		String characters = request.getParameter("characters");
		String synopsis = request.getParameter("synopsis");

		BookDAO dao = new BookDAO();
		Book book = new Book(id, title, author, date, genres, characters, synopsis);

		// Update the book in the database
		try {
			dao.updateBook(book);

		} catch (SQLException se) {
			System.out.println(se.getMessage());

		}
		
		// Redirect the user to the books page
		response.sendRedirect("./books");


	}

	// DELETE request to delete a book
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Retrieve the book ID from the request parameters
		int book = Integer.parseInt(request.getParameter("id"));

		BookDAO dao = new BookDAO();

		// Delete the book from the database
		try {
			dao.deleteBook(book);

		} catch (SQLException se) {
			System.out.println(se.getMessage());

		}

		// Redirect the user to the books page
		response.sendRedirect("./books");


	}
}
