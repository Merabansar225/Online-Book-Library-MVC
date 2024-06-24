package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BookDAO;
import models.Book;

//Servlet implementation for searching books via ID and Title
@WebServlet("/search")
public class SearchBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Retrieve the search input from the search bar
		String searchBarInput = request.getParameter("search");

		BookDAO bookDAO = new BookDAO();
		
		// Perform a search for books based on the search input
		List<Book> searchResults = bookDAO.searchBook(searchBarInput);

		// Set the search results as an attribute in the request
		request.setAttribute("books", searchResults);

		// Forward the request to the viewBooks.jsp page to display the search results
		RequestDispatcher rd = request.getRequestDispatcher("viewBooks.jsp");
		rd.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Call the doGet method to handle the search operation
		doGet(request, response);
	}
}

