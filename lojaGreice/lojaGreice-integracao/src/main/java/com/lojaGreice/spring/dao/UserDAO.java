package com.lojaGreice.spring.dao;

import java.util.List;


import com.lojaGreice.spring.model.User;

public interface UserDAO {
	public List<User> list();

	public void save(User usuario);
}
