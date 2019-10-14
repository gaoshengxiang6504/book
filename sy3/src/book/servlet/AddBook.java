package book.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import book.domain.Book;
import book.utils.JDBCUtils;
import book.dao.BookDao;

/**
 * Servlet implementation class AddBook
 */
@SuppressWarnings("unused")
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BookDao bookDao=new BookDao();
		Book book =new Book();
		book.setBookName(request.getParameter("bookName"));
		book.setAuthor(request.getParameter("author"));
		book.setPress(request.getParameter("press"));
		book.setIsbn(request.getParameter("isbn"));
		book.setCategory(request.getParameter("category"));
		book.setPrice(request.getParameter("price"));
		boolean b=bookDao.insert(book);
		//System.out.print(b);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/ListBooks");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
