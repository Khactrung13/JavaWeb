
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="Entity.SanPham"%>
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
<script type="text/javascript"
	src="<%=request.getContextPath()%>/library/ckeditor/ckeditor.js"></script>
</head>
<body style="background: aliceblue; width: 1410px;">
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
					style="color: white; margin-right: 10px; margin-left: 10px;"
					class="nav-link" href="adminsanphamcontroller"> Quản lý sản
						phẩm </a></li>
				<li class="nav-item"><a
					style="color: white; margin-right: 10px; margin-left: 10px;"
					class="nav-link" href="adminhoadon"> Quản lý hoá đơn </a></li>

				<li class="nav-item "><a
					style="color: white; margin-right: 10px; margin-left: 10px;"
					class="nav-link" href="dangxuatadmin"> Đăng xuất : Admin</a></li>
			</ul>

		</div>
	</nav>
	<form style="margin-left: 1100px; padding-top: 5px;"
		class="form-inline my-2 my-lg-0" action="adminsanphamcontroller"
		method="POST">
		<input class="form-control mr-sm-2" type="search"
			placeholder="Từ khoá ....." aria-label="Search" name="tukhoa1">
		<button
			style="color: white; border: 1px solid; width: 30%; background: black;"
			class="btn btn-outline-success my-2 my-sm-0" type="submit"
			name="timkiem">Tìm kiếm</button>
	</form>
	<%
	SanPham sp = (SanPham) request.getAttribute("sp");
	response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8");
	%>
	<form action="adminsuasanphamcontroller" method="post"
		enctype="multipart/form-data"
		style="border: 1px solid; background: antiquewhite; width: 95%; margin-left: 25px; margin-bottom: 20px; margin-top: 20px">
		<h1 style="text-align: center; padding-top: 20px; color: red">Quản
			lý sản phẩm</h1>
		<p
			style="margin-bottom: 5px; margin-left: 150px; font-size: 18px; font-weight: bold;">Mã
			sản phẩm</p>
		<input style="margin-left: 150px; margin-bottom: 5px; width: 80%;"
			type="text" placeholder="Mã sản phẩm .... " name="masp"
			value="<%=sp.getMa()%>">
		<p
			style="margin-bottom: 5px; margin-left: 150px; font-size: 18px; font-weight: bold;">Tên
			sản phẩm</p>
		<input style="margin-left: 150px; margin-bottom: 5px; width: 80%;"
			type="text" placeholder="Tên sản phẩm.... " name="tensp"
			value="<%=sp.getTensp()%>">
		<p
			style="margin-bottom: 5px; margin-left: 150px; font-size: 18px; font-weight: bold;">Giá
		</p>
		<input style="margin-left: 150px; margin-bottom: 5px; width: 80%;"
			type="text" placeholder="Giá  .... " name="gia"
			value="<%=sp.getGia()%>">
		<p
			style="margin-bottom: 5px; margin-left: 150px; font-size: 18px; font-weight: bold;">Số
			lượng</p>
		<input style="margin-left: 150px; margin-bottom: 5px; width: 80%;"
			type="text" placeholder="Số lượng .... " name="soluong"
			value="<%=sp.getSoluong()%>">
		<p
			style="margin-bottom: 5px; margin-left: 150px; font-size: 18px; font-weight: bold;">Hình
			ảnh</p>
		<input style="margin-bottom: 5px; margin-left: 150px;" type="file"
			name="hinhanh" value="<%=sp.getHinhanh()%>">

		<p
			style="margin-bottom: 5px; margin-left: 150px; font-size: 18px; font-weight: bold;">Tóm
			tắt</p>
		<p style="width: 80%; margin-left: 150px;">
			<textarea style="margin-left: 150px; width: 80%;" rows="10"
				cols="123" name="tomtat" id="editor"><%=sp.getTomtat()%></textarea>
		</p>
		<p
			style="margin-bottom: 5px; margin-left: 150px; font-size: 18px; font-weight: bold;">Nội
			dung</p>
		<p style="width: 80%; margin-left: 150px;">
			<textarea style="margin-left: 150px; width: 80%;" rows="10"
				cols="123" name="noidung" id="editor1"><%=sp.getNoidung()%></textarea>
		</p>
		<p
			style="margin-bottom: 5px; margin-left: 150px; font-size: 18px; font-weight: bold;">Danh
			mục</p>
		<%
		ArrayList<DanhMuc> dss = (ArrayList<DanhMuc>) request.getAttribute("dm");
		%>
		<select name="iddanhmuc"
			style="margin-bottom: 5px; margin-left: 150px; font-size: 18px; width: 30%; font-weight: bold; text-align: center;">
			<%
			for (DanhMuc loai : dss) {
				if (sp.getIddanhmuc() == loai.getId()) {
			%>
			<option selected value="<%=loai.getId()%>"><%=loai.getTendanhmuc()%></option>
			<%
			} else {
			%>
			<option value="<%=loai.getId()%>"><%=loai.getTendanhmuc()%></option>
			<%
			}
			}
			%>
		</select> <br> <input
			style="margin-left: 150px; margin-bottom: 25px; width: 80%; background: darkkhaki; font-size: 20px; font-weight: bold; margin-top: 20px;"
			name="sua" type="submit" value="Sửa sản phẩm ">
		<p
			style="color: red; font-weight: bold; width: 100%; text-align: center;">${mess}</p>
	</form>
	<%
	ArrayList<SanPham> ds = (ArrayList<SanPham>) request.getAttribute("dssp");
	if (ds.size() == 0) {
	%>
	<p
		style="font-weight: bold; color: red; width: 100%; text-align: center; margin-top: 20px;">Không
		tìm thấy sản phẩm !!!!!</p>
	<%
	} else {
	%>
	<table border="1"
		style="margin-bottom: 20px; width: 95%; margin-left: 25px; background: antiquewhite;">
		<tr>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">ID</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Mã
				sản phẩm</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Tên
				sản phẩm</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">
				Giá</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Số
				lượng</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Hình
				ảnh</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Tóm
				tắt</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Nội
				dung</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Id
				danh mục</td>
		</tr>

		<%
		Locale localvn = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localvn);
		for (SanPham spp : ds) {
		%>
		<tr>
			<td style="text-align: center;"><%=spp.getId()%></td>
			<td style="text-align: center;"><%=spp.getMa()%></td>
			<td style="text-align: center;"><%=spp.getTensp()%></td>
			<td style="text-align: center;"><%=currencyVN.format(spp.getGia())%></td>
			<td style="text-align: center;"><%=spp.getSoluong()%></td>
			<td><img style="width: 100%; height: 150px;"
				src="files/<%=spp.getHinhanh()%>"></td>
			<td style="text-align: center;"><%=spp.getTomtat()%></td>
			<td style="text-align: center;"><%=spp.getNoidung()%></td>
			<td style="text-align: center;"><%=spp.getIddanhmuc()%></td>
			<td style="text-align: center;"><a style="margin-right: 20px;"
				href="adminsuasanpham?id=<%=spp.getId()%>">Sửa</a> <a
				style="color: red;" href="adminxoasanpham?id=<%=spp.getId()%>">Xoá</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>
	<script>
		CKEDITOR.replace('editor');
		CKEDITOR.replace('editor1');
	</script>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</html>