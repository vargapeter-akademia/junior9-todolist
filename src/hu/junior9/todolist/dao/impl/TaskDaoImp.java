package hu.junior9.todolist.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import hu.junior9.todolist.TodoListException;
import hu.junior9.todolist.dao.AbstractDao;
import hu.junior9.todolist.dao.TaskDao;
import hu.junior9.todolist.entity.StateEnum;
import hu.junior9.todolist.entity.Task;
import hu.junior9.todolist.entity.User;

public class TaskDaoImp extends AbstractDao implements TaskDao {

	private static final String CREATE_STM = "INSERT INTO task(summary, due_date, " //
			+ "user_id, state_id) values(?, ?, ?, ?);";

	@Override
	public void createTask(Task task) {
		try (Connection con = getConnection(); //
				PreparedStatement ps = con.prepareStatement(CREATE_STM)) {
			ps.setString(1, task.getSummary());

			ps.setTimestamp(2, Optional.ofNullable(task.getDueDate())
					.map(Timestamp::valueOf)
					.orElse(null));

			ps.setInt(3, task.getUser()
					.getId());
			ps.setInt(4, task.getState()
					.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			throw new TodoListException(e);
		}

	}

	private static final String FIND_ALL_BY_USER = "select \n" + 
	"	task.id as id,\n" +
			"    task.summary as summary,\n" + 
	"    task.due_date as due_date,\n"
			+ "    task.user_id as user_id,\n" + "    user.name as user_name,\n" + "    task.state_id as state_id,\n" + "    state.name as state_name\n" + "from task\n"
			+ "join user on user.id = task.user_id\n" + "join state on task.state_id = state.id\n" + "where user_id = ?;";

	@Override
	public List<Task> findAllTasksByUser(User user) {
		try (Connection con = getConnection(); //
				PreparedStatement ps = con.prepareStatement(FIND_ALL_BY_USER)) {
			ps.setInt(1, user.getId());

			List<Task> result = new ArrayList<>();
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					
					User relatedUser = new User();
					relatedUser.setId(rs.getInt("user_id"));
					relatedUser.setName(rs.getString("user_name"));
					
					StateEnum state = new StateEnum(
						rs.getInt("state_id"),
						rs.getString("state_name")
					);
					
					Task task = new Task(
						rs.getInt("id"),
						rs.getString("summary"),
						Optional.ofNullable(rs.getTimestamp("due_date"))
							.map(Timestamp::toLocalDateTime).orElse(null),
						relatedUser,
						state
					);
					
					result.add(task);
				}
				return result;
			}

		} catch (SQLException e) {
			throw new TodoListException(e);
		}
	}

}
