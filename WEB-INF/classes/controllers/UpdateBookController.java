package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BookDAO;
import models.Book;

//Servlet implementation for updating a new book
@WebServlet("/update")
public class UpdateBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Retrieve the book ID from the request parameters
		int id = Integer.parseInt(request.getParameter("id"));
		BookDAO dao = new BookDAO();
		
		// Get the book details by ID from the database
		Book book = dao.getBookByID(id);
		
		// Remove double quotes from the synopsis to avoid formatting issues
		book.setSynopsis(book.getSynopsis().replace("\"", ""));
		request.setAttribute("currBook", book);
		
		// Print the book details for debugging
		System.out.println(id + book.getTitle() + book.getAuthor() + 
				book.getDate() + book.getGenres() + book.getCharacters() + book.getSynopsis());

		// Forward the request to the editBook.jsp page to display the book details for editing
		RequestDispatcher rd = request.getRequestDispatcher("editBook.jsp");
		rd.include(request, response);
		

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		BookDAO dao = new BookDAO();
		Book bk = new Book();

		// Retrieve updated book details from the request parameters
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String date = req.getParameter("date");
		String genres = req.getParameter("genres");
		String characters = req.getParameter("characters");
		String synopsis = req.getParameter("synopsis");
		
		// Set the updated book details
		bk.setId(id);
		bk.setTitle(title);
		bk.setAuthor(author);
		bk.setDate(date);
		bk.setGenres(genres);
		bk.setCharacters(characters);
		bk.setSynopsis(synopsis);
		
	
		// Update the book in the database
		try {
			
			dao.updateBook(bk);
		} catch (SQLException se) {
			System.out.println(se.getMessage());

		}
		
		// Redirect the user to the books listing page
		resp.sendRedirect("./books");
		

	}
}



