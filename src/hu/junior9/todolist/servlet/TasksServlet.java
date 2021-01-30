package hu.junior9.todolist.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.junior9.todolist.dao.TaskDao;
import hu.junior9.todolist.dao.impl.TaskDaoImp;
import hu.junior9.todolist.entity.Task;
import hu.junior9.todolist.entity.User;

public class TasksServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = (User) req.getSession().getAttribute("loggedInUser");
		TaskDao taskDao = new TaskDaoImp();
		List<Task> tasks = taskDao.findAllTasksByUser(user);
		
		req.setAttribute("tasks", tasks);
		req.getRequestDispatcher("tasks.jsp")
			.forward(req, resp);
	}

}
