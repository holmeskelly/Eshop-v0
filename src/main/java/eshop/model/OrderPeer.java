package eshop.model;

import java.util.Enumeration;
import java.util.Hashtable;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import eshop.beans.CartItem;
import eshop.beans.Customer;
import eshop.dao.IOrderPeer;

public class OrderPeer extends SimpleJdbcDaoSupport implements IOrderPeer {

	public Long insertOrder(Customer customer, Hashtable<?, ?> shoppingCart) {

		Long returnValue = 0L;
		Long orderId = System.currentTimeMillis();

		String sql = RequetePeer.getRequeteParametre(RequetePeer.REQUETE_INSERT_ORDER,
				FieldPeer.FIELD_ORDER_MARK.getField(), FieldPeer.FIELD_ORDER_MARK.getField(),
				FieldPeer.FIELD_ORDER_MARK.getField(), FieldPeer.FIELD_ORDER_MARK.getField(),
				FieldPeer.FIELD_ORDER_MARK.getField(), FieldPeer.FIELD_ORDER_MARK.getField());

		getSimpleJdbcTemplate().update(sql, orderId, customer.getContactName(), customer.getDeliveryAddress(),
				customer.getCcName(), customer.getCcNumber(), customer.getCcExpiryDate());

		// Insert items into the OrderDetails table
		Enumeration<?> enumList = shoppingCart.elements();
		while (enumList.hasMoreElements()) {
			CartItem cartItem = (CartItem) enumList.nextElement();
			sql = RequetePeer.getRequeteParametre(RequetePeer.REQUETE_INSERT_ORDER_DETAILS,
					FieldPeer.FIELD_ORDER_MARK.getField(), FieldPeer.FIELD_ORDER_MARK.getField(),
					FieldPeer.FIELD_ORDER_MARK.getField(), FieldPeer.FIELD_ORDER_MARK.getField(),
					FieldPeer.FIELD_ORDER_MARK.getField(), FieldPeer.FIELD_ORDER_MARK.getField());

			getSimpleJdbcTemplate().update(sql, orderId, cartItem.getBookID(), cartItem.getQuantity(),
					cartItem.getPrice(), cartItem.getTitle(), cartItem.getAuthor());
		}

		returnValue = orderId;

		return returnValue;
	}

}
