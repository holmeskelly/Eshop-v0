/**
 * 
 */
package eshop.model;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author kholmes
 * 
 */
public enum RequetePeer {

	REQUETE_SELECT_BOOK_BY_KEYWORD("requete.select.book.by.keyword"),

	REQUETE_SELECT_BOOK_BY_CATEGORIE("requete.select.book.by.categorie"),

	REQUETE_SELECT_BOOK_BY_ID("requete.select.book.by.id"),

	REQUETE_SELECT_CATEGORY_BY_ID("requete.select.category.by.id"),

	REQUETE_SELECT_ALL_CATEGORY("requete.select.all.category"),

	REQUETE_INSERT_ORDER("requete.insert.order"),
	
	REQUETE_INSERT_ORDER_DETAILS("requete.insert.order.detail")
	
	;

	private String requete;

	/**
	 * @param requete
	 */
	private RequetePeer(String requete) {
		this.requete = requete;
	}

	/**
	 * @return the requete
	 */
	public String getRequete() {
		return requete;
	}

	public static String getRequeteParametre(RequetePeer requetePeer,
			Object... objects) {

		String requete = null;

		PropertyResourceBundle propertyResourceBundle = (PropertyResourceBundle) ResourceBundle
				.getBundle("eshop.requete.requete", Locale.FRANCE);

		for (RequetePeer peer : RequetePeer.values()) {

			if (peer.equals(requetePeer)) {

				String valueRequete = propertyResourceBundle.getString(peer
						.getRequete());

				String format = objects == null ? valueRequete : MessageFormat
						.format(valueRequete, objects);

				requete = format;
			}
		}

		return requete;
	}

}
