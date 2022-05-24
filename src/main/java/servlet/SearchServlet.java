package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.entity.Products;
import db.service.Search;
import utilityAll.Util;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchMenuServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String searchValue = request.getParameter("searchValue");
		String orderValue = request.getParameter("order");
		List<Products> resultList;
		int count = 0;
		String orderby ="product_id";
		
		if(!Util.isNullOrEmpty(orderValue)) {
		switch (orderValue) {
		case "3":
			orderby ="category_id";
			break;
		case "4":
			orderby ="price";
			break;
		case "5":
			orderby ="price desc";
			break;
		case "6":
			orderby ="p.created_at";
			break;
		case "7":
			orderby ="p.created_at desc";
			break;
		}
		}
		
		if(Util.isNullOrEmpty(searchValue)) {
			resultList= Search.select("", orderby);
			count = Search.count("");
			
		}else {
			
			resultList= Search.select(searchValue, orderby);
			count = Search.count(searchValue);
		}
		session.setAttribute("list", resultList);
		request.setAttribute("count",count);
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
