
<%@page import="Entity.DanhMuc"%>
<%@page import="Controller.chitietsanpham"%>

<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="Controller.sanpham"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList"
	import="Entity.SanPham"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

</head>
<body
	style="height: 700px; padding: 0; margin: 0; background: aliceblue;    width: 1420px;">
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div id="main">
		
		<jsp:include page="siderbar.jsp"></jsp:include>
		<div class="maincontent"
			style="width: 85%; border: solid; height: 500px; float: right; background: antiquewhite;">
			<h2 style="margin-top: 20px; color: red;margin-left: 20px;">Chi tiết sản phẩm</h2>
			<%
			SanPham ds =(SanPham)request.getAttribute("ds") ;
			Locale localvn = new Locale("vi", "VN");
			NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localvn);
			%>
			<img
				style="width: 50%; height: 300px; border: 1px solid; float: left; margin-right: 50px;margin-left: 20px;"
				src="images/<%=ds.getHinhanh()%>"> <br>
				
			<h3>
				Tên sản phẩm :
				<%out.print(ds.getTensp());%>
			</h3>
			<p>
				Mã sản phẩm :
				<%out.print(ds.getMa());%>
			</p>
			<p>
				Giá:<%out.print(currencyVN.format(ds.getGia()));%>
			</p>
			<p >
				Số lượng :<%out.print(ds.getSoluong());%>
			</p> 
			<p style="float: left;">
				Tóm tắt :<%=ds.getTomtat()%>
			</p>
			<p style="float: left;">
				Nội dung :<%out.print(ds.getNoidung());%>
			</p>
			<a
				style="border: 1px solid; color: white; background: coral; font-size: 25px; font-weight: bold; text-decoration: none;"
				href="giocontroller?ms=<%=ds.getMa()%>&ts=<%=ds.getTensp()%>&anh=<%=ds.getHinhanh()%>&g=<%=ds.getGia()%>">Thêm vào giỏ hàng </a>


		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</html>
