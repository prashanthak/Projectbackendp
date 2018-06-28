package com.niit.dao;

import java.util.List;

import com.niit.domain.CartItem;
import com.niit.domain.User;

public interface CartItemDao {
User getUser(String email);
void saveOrUpdateCartItem(CartItem cartItem);
List<CartItem>getCartItems(String email);
void removeCartItem(int itemId);
}
