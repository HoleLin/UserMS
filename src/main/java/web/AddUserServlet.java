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

@WebServlet(name = "AddUserServlet", urlPatterns = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String nickName = request.getParameter("nickName");
		String email = request.getParameter("email");
		String tag = request.getParameter("tag");

		User user = new User(userName, passWord, nickName, email);
		SqlSession sqlSession = SQLManager.getSqlSession();
		sqlSession.insert(SQLManager.NAMESPACE + "insertUser", user);
		sqlSession.commit();
		if (tag.equals("add")) {
			// 更新Session中userList
			List<User> userList = sqlSession.selectList(SQLManager.NAMESPACE + "findAll");
			HttpSession session = request.getSession();
			session.setAttribute("userList", userList);
			request.getRequestDispatcher("show_info.jsp").forward(request, response);
		}else if (tag.equals("login")){
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
