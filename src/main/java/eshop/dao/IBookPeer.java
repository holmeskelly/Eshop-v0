/**
 * 
 */
package eshop.dao;

import java.util.List;

import eshop.beans.Book;

/**
 * @author kholmes
 * 
 */
public interface IBookPeer {

	/**
	 * 
	 * @param keyword
	 * @return list of books
	 */
	List<Book> searchBooks(String keyword);

	/**
	 * 
	 * @param categoryId
	 * @return list of books by category
	 */
	List<Book> getBooksByCategory(String categoryId);

	/**
	 * 
	 * @param bookID
	 * @return book
	 */
	Book getBookById(String bookID);
}
