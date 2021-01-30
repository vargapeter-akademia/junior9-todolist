package hu.junior9.todolist.dao;

import java.util.List;

import hu.junior9.todolist.entity.Task;
import hu.junior9.todolist.entity.User;

public interface TaskDao {
	
	void createTask(Task task);
	List<Task> findAllTasksByUser(User user);
	
}
