/**
 * 
 */
package eshop.model;

/**
 * @author kholmes
 * 
 */
public enum FieldPeer {

	FIELD_BOOK_ID("book_id"),

	FIELD_BOOK_TITLE("title"),

	FIELD_BOOK_AUTHOR("author"),

	FIELD_BOOK_PRICE("price"),

	FIELD_ORDER_MARK("?")

	;

	private String field;

	/**
	 * @param field
	 */
	private FieldPeer(String field) {
		this.field = field;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

}
