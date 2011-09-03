package eshop.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import eshop.beans.Category;
import eshop.dao.ICategoryPeer;

public class CategoryPeer extends SimpleJdbcDaoSupport implements ICategoryPeer {

	public Category getCategoryById(String categoryId) {

		Category category = null;

		String sql = RequetePeer.getRequeteParametre(
				RequetePeer.REQUETE_SELECT_CATEGORY_BY_ID, categoryId);

		RowMapper<Category> categoryRowMapper = getCategoryRowMapper();

		category = getSimpleJdbcTemplate().queryForObject(sql,
				categoryRowMapper);

		return category;
	}

	public List<Category> getAllCategories() {

		List<Category> categories = null;

		String sql = RequetePeer.getRequeteParametre(RequetePeer.REQUETE_SELECT_ALL_CATEGORY);

		RowMapper<Category> categoryRowMapper = getCategoryRowMapper();

		categories = getSimpleJdbcTemplate().query(sql, categoryRowMapper);

		return categories;
	}

	/**
	 * 
	 * @return row mapper
	 */
	private RowMapper<Category> getCategoryRowMapper() {

		RowMapper<Category> rowMapper = new RowMapper<Category>() {

			public Category mapRow(ResultSet rs, int rowNum)
					throws SQLException {

				Category category = new Category(rs.getInt(1), rs.getString(2));

				return category;
			}
		};

		return rowMapper;
	}
}
