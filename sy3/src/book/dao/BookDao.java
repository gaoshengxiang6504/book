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
	// ����û��Ĳ���
	public boolean insert(Book book) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		// ������ݵ�����
		conn = JDBCUtils.getConnection();
		// ���Statement����
		stmt = conn.createStatement();
		// ����SQL���
		
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
	//����
	/*public static void main(String [] args){
		BookDao bd =new BookDao();
		Book book =new Book();
		//book.setId(4);�����ɲ�д
		book.setBookName("oracle");
		book.setAuthor("����");
		book.setPress("���������");
		book.setIsbn("978-0");
		book.setCategory("���ݿ�");
		book.setPrice(33);
		boolean b=bd.insert(book);
			 System.out.println(b);
		
	}*/
	// ��ѯ���е�Book����
	public ArrayList<Book> listAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			// ������ݵ�����
			conn = JDBCUtils.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "SELECT * FROM Book";
			rs = stmt.executeQuery(sql);
			// ��������
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
	//����
	/*public static void main(String [] args){
		BookDao bd =new BookDao();
		List<Book> list =bd.listAll();
		 for(int i=0;i<list.size();i++){
			 System.out.println(list.get(i).getBookName());}
		
	}*/
	// ����id����ָ����user
	public Book find(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// ������ݵ�����
			conn = JDBCUtils.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "SELECT * FROM Book WHERE id=" + id;
			rs = stmt.executeQuery(sql);
			// ��������
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
		// ɾ���û�
		public boolean delete(String id) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				// ������ݵ�����
				conn = JDBCUtils.getConnection();
				// ���Statement����
				stmt = conn.createStatement();
				// ����SQL���
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
		// �޸��û�
		public boolean update(Book book) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				// ������ݵ�����
				conn = JDBCUtils.getConnection();
				// ���Statement����
				stmt = conn.createStatement();
				// ����SQL���
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
			book.setId(4);//�����ɲ�д
			book.setBookName("oracle");
			book.setAuthor("����");
			book.setPress("���������");
			book.setIsbn("978-0");
			book.setCategory("���ݿ�");
			book.setPrice("77");
			boolean b=bd.update(book);
				 System.out.println(b);
			
		}*/
	}


