package hu.junior9.todolist.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.junior9.todolist.dao.StateEnumDao;
import hu.junior9.todolist.dao.TaskDao;
import hu.junior9.todolist.dao.impl.StateEnumDaoImp;
import hu.junior9.todolist.dao.impl.TaskDaoImp;
import hu.junior9.todolist.entity.Task;
import hu.junior9.todolist.entity.User;

public class CreateTaskServlet extends HttpServlet {
// DateTimeFormatter.ISO_LOCAL_DATE_TIME
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String summary = req.getParameter("summary");
		String dueDateParam = req.getParameter("dueDate");

		LocalDateTime dueDate = Optional.ofNullable(dueDateParam)
				.map(LocalDateTime::parse)
				.orElse(null);

		User user = (User) req.getSession()
				.getAttribute("loggedInUser");
		StateEnumDao stateEnumDao = new StateEnumDaoImp();

		Task task = new Task();
		task.setSummary(summary);
		task.setDueDate(dueDate);
		task.setUser(user);
		task.setState(stateEnumDao.findDefaultState());

		TaskDao taskDao = new TaskDaoImp();
		taskDao.createTask(task);
		resp.sendRedirect(req.getServletContext().getContextPath() + "/tasks");
	}

}
