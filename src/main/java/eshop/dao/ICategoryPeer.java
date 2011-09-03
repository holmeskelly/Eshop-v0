/**
 * 
 */
package eshop.dao;

import java.util.List;

import eshop.beans.Category;

/**
 * @author kholmes
 * 
 */
public interface ICategoryPeer {

	/**
	 * 
	 * @param categoryId
	 * @return category
	 */
	Category getCategoryById(String categoryId);

	/**
	 * 
	 * @return list all categories
	 */
	List<Category> getAllCategories();
}
