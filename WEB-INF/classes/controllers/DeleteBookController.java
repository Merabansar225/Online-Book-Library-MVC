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

//Servlet implementation for deleting a new book
@WebServlet("/delete")
public class DeleteBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Retrieve the book ID from the request parameters
		int id = Integer.parseInt(request.getParameter("id"));

		BookDAO dao = new BookDAO();
		
		// Delete the book from the database
		try {
			dao.deleteBook(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Redirect the user to the books page
		response.sendRedirect("./books");
		System.out.println(id);
		
		
	}

	
}
