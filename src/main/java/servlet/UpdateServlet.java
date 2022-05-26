package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.service.UpdateDelete;
import utilityAll.Util;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String productIdS = request.getParameter("productId");
		String productName =request.getParameter("productName");
		String priceS = request.getParameter("price");
		String categoryS = request.getParameter("category");
		String description = request.getParameter("description");
		String nullError ="必須項目です";
		String url = "GetCategory";
		String updateMsg;
		
		if(!Util.isNullOrEmpty(productIdS) && !Util.isNullOrEmpty(productName) && !Util.isNullOrEmpty(priceS)) {
			Integer price = Integer.parseInt(priceS);
			Integer productId = Integer.parseInt(productIdS);
			Integer category = Integer.parseInt(categoryS);
			//if(Util.isNullOrEmpty(description)) {
				//description = "";
				boolean result = UpdateDelete.update(productId, category,productName, price,  description);
				if(result == true) {
					url = "AllShowServlet";
					updateMsg = "更新しました";
					session.setAttribute("menuMsg",updateMsg);
					
				}else {
					updateMsg ="更新できません";
					session.setAttribute("updatetMsg",updateMsg);
				}
				
			//}
			
		}else {
		
			if (Util.isNullOrEmpty(productIdS)) {
				session.setAttribute("nullErrorId", nullError);
			}
			if(Util.isNullOrEmpty(productName)) {
				session.setAttribute("nullErrorName", nullError);
			}
			if(Util.isNullOrEmpty(priceS)) {
				session.setAttribute("nullErrorPrice", nullError);
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
