package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.entity.Users;
import db.service.passCheck;
import utilityAll.Util;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/TaskLoginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("pass");
		String url = "index.jsp";
		String msg;
		String msgId;
		String msgPass;
		 HttpSession session = request.getSession();
		
		if(Util.isNullOrEmpty(loginId) && Util.isNullOrEmpty(password)) {
			
			msg ="IDとパスワードが未入力です";
			request.setAttribute("msg", msg);
			
			msgId = "IDは必須です";
			request.setAttribute("msgId", msgId);
			
			msgPass ="Passwordは必須です";
			request.setAttribute("msgPass", msgPass);
			
			
		}else if(Util.isNullOrEmpty(loginId)) {
			msgId = "IDは必須です";
			request.setAttribute("msgId", msgId);
			
		}else if(Util.isNullOrEmpty(password)) {
			msgPass ="Passwordは必須です";
			request.setAttribute("msgPass", msgPass);
			
		}else {
			boolean result;
			result =passCheck.loginCheck(loginId, password);
			if(result == true) {
				Users u = passCheck.loginUser(loginId, password);
				session.setAttribute("userInfo",u);

				url = "AllShowServlet";
			}else {
				msg ="IDかパスワードが間違っています";
				request.setAttribute("msg", msg);
			}
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
