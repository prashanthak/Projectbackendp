package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.domain.User;

@Repository("userDao")
public interface UserDao {
User saveOrUpdateUser(User user);
User getUser(int id);
void deleteUser(int id);

List<User> getAllUsers();
}
