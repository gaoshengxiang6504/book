package book.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import book.domain.Book;
import book.utils.JDBCUtils;
import book.dao.*;

/**
 * Servlet implementation class ListBooks
 */
@SuppressWarnings("unused")
@WebServlet("/ListBooks")
public class ListBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=utf-8");
		 BookDao bookDao=new BookDao();
		 ArrayList<Book> list=bookDao.listAll();
		 request.setAttribute("list",list);
		 RequestDispatcher dispatcher=request.getRequestDispatcher("/list.jsp");
		 dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
