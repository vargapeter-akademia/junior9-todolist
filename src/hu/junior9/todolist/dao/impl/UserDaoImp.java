package hu.junior9.todolist.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.junior9.todolist.TodoListException;
import hu.junior9.todolist.dao.AbstractDao;
import hu.junior9.todolist.dao.UserDao;
import hu.junior9.todolist.entity.User;

public class UserDaoImp extends AbstractDao implements UserDao {

	private static final String CREATE_STATEMENT = "INSERT INTO " + //
			"user(email, password_hash, name) VALUES(?, ?, ?);";
	
	private static final String FIND_BY_EMAIL_AND_PASSWORD_STATEMENT = "SELECT " +
			"id, email, password_hash, name, is_admin FROM user WHERE "
			+ "email = ? AND password_hash = ?;";

	@Override
	public void createUser(User user) {
		try (	Connection con = getConnection();
				PreparedStatement stm = con.prepareStatement(CREATE_STATEMENT)) {
			stm.setString(1, user.getEmail());
			stm.setString(2, user.getPasswordHash());
			stm.setString(3, user.getName());
			
			stm.executeUpdate();
			
		} catch (SQLException e) {
			throw new TodoListException(e);
		}
	}

	@Override
	public User findUserByEmailAndPassword(String email, String password) {
		try (	Connection con = getConnection();
				PreparedStatement stm = con.prepareStatement(FIND_BY_EMAIL_AND_PASSWORD_STATEMENT)) {
			stm.setString(1, email);
			stm.setString(2, password);
			
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					return new User(
							rs.getInt("id"),
							rs.getString("email"),
							rs.getString("password_hash"),
							rs.getString("name"),
							rs.getBoolean("is_admin"));
				} else {
					return null;
				}
			}
			
		} catch (SQLException e) {
			throw new TodoListException(e);
		}
	}

}
