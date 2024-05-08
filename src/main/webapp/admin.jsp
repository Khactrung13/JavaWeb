
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="Entity.hoadon"%>
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
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body style="    background: aliceblue;    width: 1410px;">
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
					style="color: white;  margin-right: 10px;margin-left: 10px;"
					class="nav-link" href="adminloaicontroller">Quản lý loại sản phẩm   </a></li>
				<li class="nav-item"><a
					style="color: white;    margin-right: 10px;margin-left: 10px;"
					class="nav-link" href="adminsanphamcontroller"> Quản lý sản phẩm   </a></li>
				<li class="nav-item"><a
					style="color: white;   margin-right: 10px;margin-left: 10px;"
					class="nav-link" href="adminhoadon"> Quản lý hoá đơn  </a></li>

				<li class="nav-item "><a
					style="color: white;     margin-right: 10px;margin-left: 10px;"
					class="nav-link" href="dangxuatadmin"> Đăng xuất : Admin</a></li>
			</ul>

		</div>
	</nav>
	<p style="text-align: center;
    font-size: 35px;
    font-weight: bold;
    color: red;">Quản lý hoá đơn </p>
    <form style="
    float: right;
    margin-left: 740px;"class="form-inline my-2 my-lg-0" action="adminhoadon" method="POST">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Từ khoá ....." aria-label="Search" name="tukhoa">
				<button style="color: white; border: 1px solid; width: 30%;background: black;"
					class="btn btn-outline-success my-2 my-sm-0" type="submit"
					name="timkiem">Tìm kiếm</button>
			</form>
			<br>
	<%
	ArrayList<hoadon> ls = (ArrayList<hoadon>)request.getAttribute("hoadon"); 
	String ktra1=null;
	String ktra=null;
	 Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		Date n1 = new Date();
			SimpleDateFormat dd = new SimpleDateFormat("dd-MM-yyyy");%>
	<%for(hoadon lsb1 :ls){
		if(lsb1.getDamua()==1){
			 ktra = "1";
		}
		else{
			ktra1="1";
		}
	} %>
	<%if(ktra1==null&&ktra==null){ %>
		<p style="font-weight: bold;
    color: red;
    width: 100%;
    text-align: center;
    margin-top: 20px;">Không tìm thấy tên khách hàng!!!!!</p>
	
	<%} %>
	<%if(ktra!=null){ %>
	<p style="font-size: 20px;    margin-left: 25px;
    font-weight: bold;">Đã thanh toán </p>
	<table border="1" style="margin-bottom: 20px; width:95%;    margin-left: 25px;background: antiquewhite;">
		<tr>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Mã hoá đơn </td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;width: 200px;">Mã khách </td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;width: 220px;">Tên khách hàng</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">SDT</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Địa chỉ</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Ngày mua </td>
	
		</tr>
		<%for(hoadon lsb :ls){ %>
		<%if(lsb.getDamua()==1){ %>
		<tr>
			<td style="text-align: center;"><%=lsb.getMahd()%></td>
			<td style="text-align: center;"><%=lsb.getIdkh()%></td>
			<td style="text-align: center;"><%=lsb.getTenkh()%></td>
			<td style="text-align: center;"><%=lsb.getDienthoai()%></td>
			<td style="text-align: center;"><%=lsb.getDiachi()%></td>
			<td style="text-align: center;"><%=dd.format(lsb.getNgaymua())%></td>

			<td style="text-align: center;"><a href="adminchitietcontroller?mahd=<%=lsb.getMahd()%>" >Xem chi tiết </a></td>
		</tr>
		<%}%>
		<%}%>
		
	</table>
	<%} %>
	<%if(ktra1!=null){ %>
	<p style="font-size: 20px;    margin-left: 25px;
    font-weight: bold;">Chưa thanh toán </p>
	<table border="1" style="margin-bottom: 120px; width:95%;    margin-left: 25px;background: antiquewhite;">
		<tr>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Mã hoá đơn </td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;width: 200px;">Mã khách </td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;width: 220px;">Tên khách hàng</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">SDT</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Địa chỉ</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Ngày mua </td>
	
		</tr>
		<%for(hoadon lsb :ls){ %>
		<%if(lsb.getDamua()==0){ %>
			<tr>
			<td style="text-align: center;"><%=lsb.getMahd()%></td>
			<td style="text-align: center;"><%=lsb.getIdkh()%></td>
			<td style="text-align: center;"><%=lsb.getTenkh()%></td>
			<td style="text-align: center;"><%=lsb.getDienthoai()%></td>
			<td style="text-align: center;"><%=lsb.getDiachi()%></td>
			<td style="text-align: center;"><%=dd.format(lsb.getNgaymua())%></td>
		
			<td style="text-align: center;"><a href="adminchitietcontroller?mahd=<%=lsb.getMahd()%>" >Xem chi tiết </a></td>
		</tr>
		<%}%>
		<%}%>	
	</table>
	<%} %>

</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</html>