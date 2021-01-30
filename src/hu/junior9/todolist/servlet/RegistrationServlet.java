package hu.junior9.todolist.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.junior9.todolist.dao.UserDao;
import hu.junior9.todolist.dao.impl.UserDaoImp;
import hu.junior9.todolist.entity.User;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		User user = new User();
		user.setEmail(email);
		user.setPasswordHash(password);
		user.setName(name);
		
		UserDao userDao = new UserDaoImp();
		userDao.createUser(user);
		
		request.getRequestDispatcher("index.jsp")
			.forward(request, response);
		
	}

}
