package eshop.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import eshop.beans.Book;
import eshop.dao.IBookPeer;

public class BookPeer extends SimpleJdbcDaoSupport implements IBookPeer {

	public List<Book> searchBooks(String keyword) {

		List<Book> books = null;

		String sql = RequetePeer.getRequeteParametre(RequetePeer.REQUETE_SELECT_BOOK_BY_KEYWORD, keyword.trim(),
				keyword.trim());

		RowMapper<Book> parameterizedRowMapper = getBookRowMapper();

		books = getSimpleJdbcTemplate().query(sql, parameterizedRowMapper);

		return books;
	}

	public List<Book> getBooksByCategory(String categoryId) {

		List<Book> books = null;

		String sql = RequetePeer.getRequeteParametre(RequetePeer.REQUETE_SELECT_BOOK_BY_CATEGORIE, categoryId);

		RowMapper<Book> parameterizedRowMapper = getBookRowMapper();

		books = getSimpleJdbcTemplate().query(sql, parameterizedRowMapper);

		return books;
	}

	public Book getBookById(String bookID) {

		Book book = null;

		String sql = RequetePeer.getRequeteParametre(RequetePeer.REQUETE_SELECT_BOOK_BY_ID, bookID);

		RowMapper<Book> parameterizedRowMapper = getBookRowMapper();

		book = getSimpleJdbcTemplate().queryForObject(sql, parameterizedRowMapper);

		return book;
	}

	/**
	 * @return book row mapper
	 */
	private RowMapper<Book> getBookRowMapper() {

		RowMapper<Book> rowMapper = new RowMapper<Book>() {

			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

				Book book = new Book();
				book.setId(rs.getString(FieldPeer.FIELD_BOOK_ID.getField()));
				book.setTitle(rs.getString(FieldPeer.FIELD_BOOK_TITLE.getField()));
				book.setAuthor(rs.getString(FieldPeer.FIELD_BOOK_AUTHOR.getField()));
				book.setPrice(rs.getDouble(FieldPeer.FIELD_BOOK_PRICE.getField()));

				return book;
			}
		};
		return rowMapper;
	}

}
