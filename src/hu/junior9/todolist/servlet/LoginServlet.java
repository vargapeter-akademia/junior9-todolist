package hu.junior9.todolist.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.junior9.todolist.dao.UserDao;
import hu.junior9.todolist.dao.impl.UserDaoImp;
import hu.junior9.todolist.entity.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDao userDao = new UserDaoImp();
		User user = userDao.findUserByEmailAndPassword(email, password);

		if (user != null) {
			request.getSession()
					.setAttribute("loggedInUser", user);
			
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		} else {
			// error átadása a login.jsp-oldalnak
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}
	}

}
