<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑图书</title>
<style>
   .ps{background-color:#99CCFF}
</style>
</head>
<body>
<form action="/sy3/EditBook" method="post">
<input type="hidden" name="id" value="${book.id}">
<table align="center" border="0">
<tr><td><p align="center" class="ps"><b>编辑图书</b></p></td></tr>
<tr align="right"><td>书名:<input name="bookName" type="text" value="${book.bookName}"></td></tr>
<tr align="right"><td>作者:<input name="author" type="text" value="${book.author}"></td></tr>
<tr align="right"><td>出版社:<input name="press" type="text" value="${book.press}"></td></tr>
<tr align="right"><td>ISBN:<input name="isbn" type="text" value="${book.isbn}"></td></tr>
<tr align="left"><td>图书类别:
<select name="category">
<option value="${book.category}" selected>${book.category}</option>
<option value="程序设计">程序设计</option>
<option value="数据库">数据库</option>
<option value="图像处理">图像处理</option>
</select>
</td></tr>
<tr align="right"><td>单价:<input name="price" type="text" value="${book.price}"></td></tr>
<tr align="left"><td><input type="submit" value="确定">
 <input type="reset" value="重置">
 <a href="/sy3/ListBooks"><input type="button" value="返回"></a></td>
</table>
</form>
</body>
</html>