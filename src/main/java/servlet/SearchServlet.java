package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String searchValue = request.getParameter("searchValue");
		List<Products> resultList = new ArrayList();
		int count = 0;
		
		if(Util.isNullOrEmpty(searchValue)) {
			resultList= Search.select("");
			count = Search.count("");
			
		}else {
			resultList= Search.select(searchValue);
			count = Search.count(searchValue);
		}
		request.setAttribute("list", resultList);
		request.setAttribute("count",count);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
