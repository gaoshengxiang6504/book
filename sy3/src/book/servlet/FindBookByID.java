package book.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import book.utils.JDBCUtils;
import book.dao.BookDao;
import book.domain.Book;

/**
 * Servlet implementation class FindBookByID
 */
@SuppressWarnings("unused")
@WebServlet("/FindBookByID")
public class FindBookByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindBookByID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bookDao=new BookDao();
		Book book =bookDao.find(request.getParameter("id"));
		request.setAttribute("book",book);
		 //System.out.println(book.getBookName());
		 RequestDispatcher dispatcher=request.getRequestDispatcher("/edit.jsp");
		 dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
