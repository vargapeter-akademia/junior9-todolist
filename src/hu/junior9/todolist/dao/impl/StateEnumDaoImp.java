package hu.junior9.todolist.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.junior9.todolist.TodoListException;
import hu.junior9.todolist.dao.AbstractDao;
import hu.junior9.todolist.dao.StateEnumDao;
import hu.junior9.todolist.entity.StateEnum;

public class StateEnumDaoImp extends AbstractDao implements StateEnumDao {

	private static final String FIND_DEFAULT_STM = "SELECT id, name FROM state "
			+ "WHERE is_default = true;";
	
	private static final String FIND_ALL_STM = "SELECT id, name FROM state;";
	
	@Override
	public StateEnum findDefaultState() {
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(FIND_DEFAULT_STM);
				ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				return new StateEnum(rs.getInt("id"), rs.getString("name"));
			} else {
				throw new TodoListException("Nincsen alapértelmezett státusz konfigurálva.");
			}
		} catch (SQLException e) {
			throw new TodoListException(e);
		}
	}

	@Override
	public List<StateEnum> findAll() {
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(FIND_ALL_STM);
				ResultSet rs = ps.executeQuery()) {
			List<StateEnum> result = new ArrayList<>();
			while (rs.next()) {
				result.add(new StateEnum(rs.getInt("id"), rs.getString("name")));
			}
			return result;
		} catch (SQLException e) {
			throw new TodoListException(e);
		}
	}

}
