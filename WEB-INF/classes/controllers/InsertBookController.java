package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BookDAO;
import models.Book;


// Servlet implementation for inserting a new book
@WebServlet("/insert")
public class InsertBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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

		// Insert the new book into the database
		try {
			dao.insertBook(book);

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
			
		// Redirect the user to the books page
		response.sendRedirect("./books");
	}
}
