package eshop.model;

import java.sql.Connection;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import eshop.beans.Book;
import eshop.beans.Category;
import eshop.beans.Customer;
import eshop.dao.IBookPeer;
import eshop.dao.ICategoryPeer;
import eshop.dao.IOrderPeer;

@Component("dataManager")
public class DataManager {

	/**
	 * Appel de BookPeer
	 */

	@Autowired
	@Qualifier("bookPeer")
	private IBookPeer bookPeer;

	@Autowired
	@Qualifier("categoryPeer")
	private ICategoryPeer categoryPeer;

	@Autowired
	@Qualifier("orderPeer")
	private IOrderPeer orderPeer;

	public Connection getConnectionLookup() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			if (ctx != null) {
				Context envContext = (Context) ctx.lookup("java:/comp/env");
				if (envContext != null) {
					DataSource ds = (DataSource) envContext
							.lookup("jdbc/mysql");
					if (ds != null) {
						conn = ds.getConnection();
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Could not connect to DB: " + e.getMessage());
			e.printStackTrace(System.out);
		}
		return conn;
	}

	public String getCategoryName(String categoryID) {
		Category category = categoryPeer.getCategoryById(categoryID);
		return (category == null) ? null : category.getName();
	}

	public List<Category> getCategories() {
		return categoryPeer.getAllCategories();
	}

	public List<?> getSearchResults(String keyword) {
		return bookPeer.searchBooks(keyword);
	}

	public List<?> getBooksInCategory(String categoryID) {
		return bookPeer.getBooksByCategory(categoryID);
	}

	public Book getBookDetails(String bookID) {
		return bookPeer.getBookById(bookID);
	}

	public long insertOrder(Customer customer, Hashtable<?, ?> shoppingCart) {
		return orderPeer.insertOrder(customer, shoppingCart);
	}

}
