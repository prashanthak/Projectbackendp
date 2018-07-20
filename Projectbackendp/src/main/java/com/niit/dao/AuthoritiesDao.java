package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.domain.Authorities;

@Repository("authoritiesDao")
public interface AuthoritiesDao {
Authorities saveOrUpdateAuthorities(Authorities authorities);
Authorities getAuthorities(int id);
void deleteAuthorities(int id);

List<Authorities> getAllAuthorities();
}
