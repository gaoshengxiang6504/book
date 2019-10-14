package book.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import book.domain.Book;
import book.utils.JDBCUtils;
@SuppressWarnings("unused")
public class BookDao  {
	// 添加用户的操作
	public boolean insert(Book book) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		// 获得数据的连接
		conn = JDBCUtils.getConnection();
		// 获得Statement对象
		stmt = conn.createStatement();
		// 发送SQL语句
		
	    String sql = "INSERT INTO book(id,bookName,author,press,isbn,category,price) "+
					"VALUES("
					+ book.getId()
					+ ",'"
					+ book.getBookName()
					+ "','"
					+ book.getAuthor()
					+ "','"
					+ book.getPress()
					+ "','"
					+ book.getIsbn()
					+ "','"
					+book.getCategory()
					+"','"
					+book.getPrice()+"')";
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	//测试
	/*public static void main(String [] args){
		BookDao bd =new BookDao();
		Book book =new Book();
		//book.setId(4);自增可不写
		book.setBookName("oracle");
		book.setAuthor("黑马");
		book.setPress("人民出版社");
		book.setIsbn("978-0");
		book.setCategory("数据库");
		book.setPrice(33);
		boolean b=bd.insert(book);
			 System.out.println(b);
		
	}*/
	// 查询所有的Book对象
	public ArrayList<Book> listAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "SELECT * FROM Book";
			rs = stmt.executeQuery(sql);
			// 处理结果集
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getString("id"));
				book.setBookName(rs.getString("bookName"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setIsbn(rs.getString("isbn"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getString("price"));
				list.add(book);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	//测试
	/*public static void main(String [] args){
		BookDao bd =new BookDao();
		List<Book> list =bd.listAll();
		 for(int i=0;i<list.size();i++){
			 System.out.println(list.get(i).getBookName());}
		
	}*/
	// 根据id查找指定的user
	public Book find(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "SELECT * FROM Book WHERE id=" + id;
			rs = stmt.executeQuery(sql);
			// 处理结果集
			while (rs.next()) {
					Book book = new Book();
					book.setId(rs.getString("id"));
					book.setBookName(rs.getString("bookName"));
					book.setAuthor(rs.getString("author"));
					book.setPress(rs.getString("press"));
					book.setIsbn(rs.getString("isbn"));
					book.setCategory(rs.getString("category"));
					book.setPrice(rs.getString("price"));
				    return book;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.release(rs, stmt, conn);
			}
			return null;
		}
	/*public static void main(String [] args){
		BookDao bd =new BookDao();
		Book book =bd.find("1");
		 System.out.println(book.getBookName());
		}*/
		// 删除用户
		public boolean delete(String id) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				// 获得数据的连接
				conn = JDBCUtils.getConnection();
				// 获得Statement对象
				stmt = conn.createStatement();
				// 发送SQL语句
				String sql = "DELETE FROM Book WHERE id=" + id;
				int num = stmt.executeUpdate(sql);
				if (num > 0) {
					return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.release(rs, stmt, conn);
			}
			return false;
		}
		/*public static void main(String [] args){
			BookDao bd =new BookDao();
			boolean b=bd.delete("6");
			 System.out.println(b);
			}*/
		// 修改用户
		public boolean update(Book book) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				// 获得数据的连接
				conn = JDBCUtils.getConnection();
				// 获得Statement对象
				stmt = conn.createStatement();
				// 发送SQL语句
				String sql = "UPDATE Book set bookName='" + book.getBookName()
						+ "',author='" + book.getAuthor() + "',press='"
						+ book.getPress()+ "',isbn='" +book.getIsbn()
						+"',category='"+book.getCategory()+ "',price='"+book.getPrice()
						+ "' WHERE id=" + book.getId();
				int num = stmt.executeUpdate(sql);
				if (num > 0) {
					return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.release(rs, stmt, conn);
			}
			return false;
		}
		/*public static void main(String [] args){
			BookDao bd =new BookDao();
			Book book =new Book();
			book.setId(4);//自增可不写
			book.setBookName("oracle");
			book.setAuthor("黑马");
			book.setPress("人民出版社");
			book.setIsbn("978-0");
			book.setCategory("数据库");
			book.setPrice("77");
			boolean b=bd.update(book);
				 System.out.println(b);
			
		}*/
	}


