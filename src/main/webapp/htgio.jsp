<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="BO.giohangbo"%>
<%@page import="Entity.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body style="background: aliceblue;width: 1425px;">
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>

	<jsp:include page="siderbar.jsp"></jsp:include>
		<div class="maincontent"
			style="width: 84%;  height: auto; float: right; background: antiquewhite;padding-bottom: 20px;">
	<%
	if (session.getAttribute("dn") != null) {
	%>
	<%
	KhachHang kh = (KhachHang) session.getAttribute("dn");
	%>
	<B style="font-size: 20px;    float: left;    margin-left: 30px;">Giỏ hàng của <%=kh.getTenKhachHang()%></B>
	<%
	} else {
	%>
	<B style="font-size: 20px;margin-left: 30px;    float: left;">Giỏ hàng</B>

	<%}%>
	<p style="font-size: 20px;
    margin-left: 480px;
    font-weight: bold;
    color: blue;"><a href="sanpham">Chọn sản phẩm</a></p>
	<p style="color: red; font-weight: bold;margin-left: 30px;">${mess3}</p>

	<%
	//giohangbo g= new giohangbo();
	if (session.getAttribute("gh") != null) {
		//g = new giohangbo();
		giohangbo g = (giohangbo) session.getAttribute("gh");
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		int sh = g.ds.size();
	%>
	<table border="1" style="margin-bottom: 20px;
    width: 95%;
    margin-left: 30px;">
		<tr>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Mã
				sản phẩm </td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Tên
				sản phẩm </td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Hình ảnh  </td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Số
				lượng</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Giá</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Thành tiền </td>
			<td></td>
		</tr>

		<%
		for (int i = 0; i < sh; i++) {
		%>
		<tr>
			<td style="text-align: center;"><%=g.ds.get(i).getMasanpham()%></td>
			<td style="text-align: center;"><%=g.ds.get(i).getTensanpham()%></td>
			<td><img style="width: 100%; height: 150px;"
								src="files/<%=g.ds.get(i).getHinhanh()%>"></td>
			<td style="text-align: center;"><a
				style="font-size: 20px; font-weight: bold;"
				href="cong?ms=<%=g.ds.get(i).getMasanpham()%>">+</a> <%=g.ds.get(i).getSoluongmua()%>
				<a style="font-size: 20px; font-weight: bold;"
				href="tru?ms=<%=g.ds.get(i).getMasanpham()%>">-</a></td>
			<td style="text-align: center;"><%=currencyVN.format(g.ds.get(i).getGia())%></td>
				<td style="text-align: center;"><%=currencyVN.format(g.ds.get(i).getThanhtien())%></td>
			<td style="text-align: center;"><a style="    color: red;
    font-weight: bold;"
				href="xoa?ms=<%=g.ds.get(i).getMasanpham()%>">Xoá </a></td>

		</tr>

		<%}%>

	</table>
	<b style="    float: right;
    margin-right: 40px;
    font-size: 20px;
    font-weight: bold;
    color: red;"> Tổng tiền = <%=currencyVN.format(g.Tongtien())%></b>
	<a style="margin-left: 280px;font-size: 20px;color:red" href="xoatatca">Xoá tất cả </a>
	<a style="margin: 150px;font-size: 20px;color:green" href="xacnhancontroller">Xác nhận đặt mua
	</a>
	<%
	}
	%>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</html>