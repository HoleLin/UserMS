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

@WebServlet(name = "ShowInfoServlet", urlPatterns = "/ShowInfoServlet")
public class ShowInfoServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取SqlSession
		SqlSession sqlSession = SQLManager.getSqlSession();
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
