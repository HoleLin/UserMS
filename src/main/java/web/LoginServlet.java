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

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String username = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		// 创建MyBatis sqlSession
		SqlSession sqlSession = SQLManager.getSqlSession();
		User user = sqlSession.selectOne(SQLManager.NAMESPACE + "checkUsername", username);
		// 验证参数
		// 进行跳转
		if (user != null) {
			if (user.getPassWord().equals(passWord)) {
				request.getRequestDispatcher("/ShowInfoServlet").forward(request, response);
			} else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
