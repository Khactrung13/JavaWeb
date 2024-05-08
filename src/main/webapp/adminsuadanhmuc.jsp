
<%@page import="Entity.DanhMuc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body style="background: aliceblue;    width: 1410px;">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"
		style="width: 1425px;">
		<a class="navbar-brand" style="margin-left: 10px; margin-right: 10px;"
			href="adminhoadon">Trang chủ </a>
		<button style="width: 10%;" class="navbar-toggler" type="button"
			data-toggle="collapse" data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a
					style="color: white; margin-right: 10px; margin-left: 10px;"
					class="nav-link" href="adminloaicontroller">Quản lý loại sản
						phẩm </a></li>
				<li class="nav-item"><a
					style="color: white; margin-right: 10px;margin-left: 10px;" class="nav-link"
					href="adminsanphamcontroller"> Quản lý sản phẩm </a></li>
				<li class="nav-item"><a
					style="color: white; margin-right: 10px;margin-left: 10px;" class="nav-link"
					href="adminhoadon"> Quản lý hoá đơn </a></li>

				<li class="nav-item "><a
					style="color: white; margin-right: 10px;margin-left: 10px;" class="nav-link"
					href="dangxuatadmin"> Đăng xuất : Admin</a></li>
			</ul>

		</div>
	</nav>
	<%DanhMuc dm = (DanhMuc)request.getAttribute("dm"); %>
	<form style="margin-left: 1100px; padding-top: 5px;"
		class="form-inline my-2 my-lg-0" action="adminloaicontroller"
		method="POST">
		<input class="form-control mr-sm-2" type="search"
			placeholder="Từ khoá ....." aria-label="Search" name="tukhoa1">
		<button
			style="color: white; border: 1px solid; width: 30%; background: black;"
			class="btn btn-outline-success my-2 my-sm-0" type="submit"
			name="timkiem">Tìm kiếm</button>
	</form>
	<form action="adminsuadanhmuccontroller" method="post"
		style="border: 1px solid; background: antiquewhite; width: 95%; margin-left: 25px; margin-bottom: 20px; margin-top: 20px">
		<h1 style="text-align: center; padding-top: 20px; color: red">Quản
			lý danh mục sản phẩm</h1>
		<p
			style="margin-bottom: 5px; margin-left: 150px; font-size: 25px; font-weight: bold;">Tên
			loại</p>
		<input style="margin-left: 150px; margin-bottom: 5px; width: 80%;"
			type="text" placeholder="Tên loại .... " name="tenloai"
			value="<%=dm.getTendanhmuc()%>"> <br> <input
			style="margin-left: 150px; margin-bottom: 25px; width: 80%; background: darkkhaki; font-size: 20px; font-weight: bold; margin-top: 20px;"
			name="them" type="submit" value="Sửa danh mục sản phẩm ">
		
	</form>
	<%
	ArrayList<DanhMuc> dsloai = (ArrayList<DanhMuc>)request.getAttribute("dsloai");
	if(dsloai.size()==0) {%>
	<p
		style="font-weight: bold; color: red; width: 100%; text-align: center; margin-top: 20px;">Không
		tìm thấy tên danh mục !!!!!</p>
	<%}else{ %>
	<table border="1"
		style="margin-bottom: 20px; width: 95%; margin-left: 25px; background: antiquewhite;">
		<tr>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Mã
				loại</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Tên
				loại</td>
		</tr>

		<%
				
					for (DanhMuc loai : dsloai) { 
					%>
		<tr>
			<td style="text-align: center;"><%=loai.getId()%></td>
			<td style="text-align: center;"><%=loai.getTendanhmuc()%></td>
			<td style="text-align: center;"><a style="margin-right: 20px;"
				href="adminsuadanhmuc?id=<%=loai.getId()%>">Sửa</a> <a
				href="adminxoadanhmuc?id=<%=loai.getId()%>">Xoá</a></td>
		</tr>
		<%
					}
					%>
	</table>
	<%} %>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</html>