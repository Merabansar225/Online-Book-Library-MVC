package controllers;

import java.sql.SQLException;
import com.google.gson.Gson;
import database.BookDAO;
import models.Book;

//Class for SOAP operations related to books
public class SOAP {
	BookDAO dao = new BookDAO();
	
	// Get all books and convert them to JSON format
	public String getAllBooks() {

		Gson gson = new Gson();
		return gson.toJson(dao.getAllBooks());
	}

	// Insert a book into the database
	public String insertBook(Book book) {

		try {
			dao.insertBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error inserting book";
		}

		return "Book inserted!!";
	}

	// Update a book in the database
	public String updateBook(Book book) {
		try {
			dao.updateBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error updating book";}
		return "Book updated!!";
	}

	// Delete a book from the database
	public String deleteBook(int book) {

		try {dao.deleteBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error deleting book";}
		return "Book deleted!!";}


}