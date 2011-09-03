/**
 * 
 */
package eshop.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import eshop.beans.Book;

/**
 * @author kholmes
 * 
 */
@ContextConfiguration(locations = "/eshop/dao/applicationContext-Dao-test.xml")
public class BookPeerContextTests extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private IBookPeer bookPeer;

	@Test
	public void testGetBooksByCategory() {

		String categoryId = "1";

		List<Book> booksByCategory = bookPeer.getBooksByCategory(categoryId);

		Assert.assertNotNull(booksByCategory);
	}

}
