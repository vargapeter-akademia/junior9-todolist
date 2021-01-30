package hu.junior9.todolist.dao;

import hu.junior9.todolist.entity.User;

public interface UserDao {

	void createUser(User user);
	User findUserByEmailAndPassword(String email, String password);
	
}
