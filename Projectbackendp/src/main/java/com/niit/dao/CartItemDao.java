package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.domain.CartItem;
import com.niit.domain.CustomerOrder;
import com.niit.domain.User;
@Repository("cartItemDao")
public interface CartItemDao {
User getUser(String email);
void saveOrUpdateCartItem(CartItem cartItem);
List<CartItem>getCartItems(String email);
void removeCartItem(int itemId);

}
