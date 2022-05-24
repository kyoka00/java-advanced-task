package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.service.Insert;
import utilityAll.Util;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertNewInfo")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String productIdS = request.getParameter("productId");
		String productName =request.getParameter("productName");
		String priceS = request.getParameter("price");
		String categoryS = request.getParameter("category");
		String description = request.getParameter("description");
		String nullError ="必須項目です";
		String url = "insert.jsp";
		String insertMsg;
		
		if(!Util.isNullOrEmpty(productIdS) && !Util.isNullOrEmpty(productName) && !Util.isNullOrEmpty(priceS)) {
			Integer price = Integer.parseInt(priceS);
			Integer productId = Integer.parseInt(productIdS);
			Integer category = Integer.parseInt(categoryS);
			if(Util.isNullOrEmpty(description)) {
				description = "";
				boolean result = Insert.insert(productId, category,productName, price,  description);
				if(result == true) {
					url = "AllShowServlet";
					insertMsg = "新規情報を登録しました";
					request.setAttribute("menuMsg",insertMsg);
					
				}else {
					insertMsg ="新規登録に失敗しました";
					request.setAttribute("insertMsg",insertMsg);
				}
				
			}
			
		}else {
			insertMsg ="※の値を入力してください";
			request.setAttribute("insertMsg",insertMsg);
			if (Util.isNullOrEmpty(productIdS)) {
				request.setAttribute("nullErrorId", nullError);
			}
			if(Util.isNullOrEmpty(productName)) {
				request.setAttribute("nullErrorName", nullError);
			}
			if(Util.isNullOrEmpty(priceS)) {
				request.setAttribute("nullErrorPrice", nullError);
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
