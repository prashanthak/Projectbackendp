package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.domain.CartItem;
import com.niit.domain.CustomerOrder;
import com.niit.domain.User;
@SuppressWarnings({"deprecation","unused"})
@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {
	@Autowired
	private SessionFactory sessionFactory;
	public User getUser1(String email) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, email);
		return user;
		}

		public void saveOrUpdateCartItem(CartItem cartItem) {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(cartItem);

		}

		public List<CartItem> getCartItems(String email) {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from CartItem where user.email=?");
			query.setString(0, email);
			List<CartItem> cartItems=query.list();
			return cartItems;
		}

		public void removeCartItem(int itemId) {
			Session session=sessionFactory.getCurrentSession();
			CartItem cartItem=(CartItem)session.get(CartItem.class, itemId);
			session.delete(cartItem);
			
		}

		@Override
		public User getUser(String email) {
			String s="from User where email='"+email+"'";
			Query q=sessionFactory.getCurrentSession().createQuery(s);
			List<User> ulist=q.list();
			return ulist.get(0);
		}

		
	}