package web;

import entity.User;
import org.apache.ibatis.session.SqlSession;
import util.SQLManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TransitServlet", urlPatterns = "/TransitServlet")
public class TransitServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		SqlSession sqlSession = SQLManager.getSqlSession();
		User user = sqlSession.selectOne(SQLManager.NAMESPACE + "checkUsername", username);
		request.setAttribute("user", user);
		request.getRequestDispatcher("edit_info.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
