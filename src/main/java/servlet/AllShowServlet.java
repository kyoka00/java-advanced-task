package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.entity.Products;
import db.service.Search;

/**
 * Servlet implementation class MenuAllShow
 */
@WebServlet("/AllShowServlet")
public class AllShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Products> resultList= Search.select("");
		int count = Search.count("");
		request.setAttribute("list", resultList);
		request.setAttribute("count",count);
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Products> resultList= Search.select("");
		int count = Search.count("");
		request.setAttribute("list", resultList);
		request.setAttribute("count",count);
		request.getRequestDispatcher("menu.jsp").forward(request, response);
		
	}

}
