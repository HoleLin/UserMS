package web;

import entity.User;
import org.apache.ibatis.session.SqlSession;
import util.SQLManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteUserServlet", urlPatterns = "/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		SqlSession sqlSession = SQLManager.getSqlSession();
		sqlSession.delete(SQLManager.NAMESPACE + "delete", username);
		sqlSession.commit();
		// 更新Session中userList
		List<User> userList = sqlSession.selectList(SQLManager.NAMESPACE + "findAll");
		HttpSession session = request.getSession();
		session.setAttribute("userList", userList);
		request.getRequestDispatcher("show_info.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
