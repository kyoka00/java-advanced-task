package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilityAll.Util;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String productIdS = request.getParameter("productId");
		String productName =request.getParameter("productName");
		String priceS = request.getParameter("price");
		String categoryS = request.getParameter("category");
		String description = request.getParameter("description");
		String nullError ="必須項目です";
		
		if(!Util.isNullOrEmpty(productIdS) && !Util.isNullOrEmpty(productName) && !Util.isNullOrEmpty(priceS)) {
			Integer price = Integer.parseInt(priceS);
			Integer productId = Integer.parseInt(productIdS);
			if(Util.isNullOrEmpty(description)) {
				description = "";
			}
			
		}else {
			if (Util.isNullOrEmpty(productId)) {
				request.setAttribute("nullErrorId", nullError);
			}else if(Util.isNullOrEmpty(productName)) {
				request.setAttribute("nullErrorName", nullError);
			}else if(Util.isNullOrEmpty(priceS)) {
				request.setAttribute("nullErrorPrice", nullError);
			}
		}
		
	}

}
