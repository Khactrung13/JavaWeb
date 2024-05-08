<%@page import="Entity.lichsu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
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
<body style="background: aliceblue">
<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div id="main">
	<jsp:include page="siderbar.jsp"></jsp:include>
		<div class="maincontent"
			style="width: 85%;  height: auto; float: right; background: antiquewhite;padding-bottom: 20px;">
	<%if(session.getAttribute("dn")!=null){ %>
	<% KhachHang kh =(KhachHang)session.getAttribute("dn");
	 Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		Date n1 = new Date();
			SimpleDateFormat dd = new SimpleDateFormat("dd-MM-yyyy"); %>
	<B style="font-size: 30px;    margin-left: 25px;">Lịch sử mua hàng </B>
	<B style="float: right;
    font-size: 20px;
    font-weight: bold;
    color: red;
    margin: 15px;">Tổng số tiền đã thanh toán : 98.000.000 Vnđ  </B>
	 <p style="color:red;font-weight:bold">${mess3}</p>
	<%
	ArrayList<lichsu> ls = (ArrayList<lichsu>)request.getAttribute("lichsu"); 
	String ktra1=null;
	String ktra=null;%>
	<%for(lichsu lsb1 :ls){
		if(lsb1.getDamua()==1){
			 ktra = "1";
		}
		else{
			ktra1="1";
		}
	} %>
	<%if(ktra1==null&&ktra==null){ %>
		<p style="font-weight: bold;    margin-left: 25px;
    color: red;">Quý khách chưa mua hàng !!!!!</p>
	
	<%} %>
	<%if(ktra!=null){ %>
	<p style="font-size: 20px;    margin-left: 25px;
    font-weight: bold;">Đã thanh toán </p>
	<table border="1" style="margin-bottom: 20px; width:95%;    margin-left: 25px;">
		<tr>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Mã hoá đơn </td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;width: 200px;">Tên sản phẩm </td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;width: 220px;">Ảnh</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Ngày mua</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Số lượng </td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Giá</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Thành tiền</td>
		</tr>
		<%for(lichsu lsb :ls){ %>
		<%if(lsb.getDamua()==1){ %>
		<tr>
			<td style="text-align: center;"><%=lsb.getMahd()%></td>
			<td style="text-align: center;"><%=lsb.getTensp()%></td>
			<td style="width: 204px;"><img style="height: 150px;width: 100%;" src="files/<%=lsb.getHinhanh()%>"></td>
			<td style="text-align: center;"><%=dd.format(lsb.getNgaymua())%></td>
			<td style="text-align: center;"><%=lsb.getSoluong()%></td>
			<td style="text-align: center;"><%=currencyVN.format(lsb.getGiasp())%></td>
			<td style="text-align: center;"><%=currencyVN.format(lsb.getThanhtien())%></td>
		</tr>
		<%}%>
		<%}%>
		
	</table>
	<%} %>
	<%if(ktra1!=null){ %>
	<p style="font-size: 20px;    margin-left: 25px;
    font-weight: bold;">Chưa thanh toán </p>
	<table border="1" style="margin-bottom: 120px; width:95%;    margin-left: 25px;">
		<tr>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Mã hoá đơn </td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;width: 200px;">Tên sản phẩm </td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;width: 220px;">Ảnh</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Ngày mua</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Số lượng </td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Giá</td>
			<td style="text-align: center; font-size: 20px; font-weight: bold;">Thành tiền</td>
		</tr>
		<%for(lichsu lsb :ls){ %>
		<%if(lsb.getDamua()==0){ %>
		<tr>
			<td style="text-align: center;"><%=lsb.getMahd()%></td>
			<td style="text-align: center;"><%=lsb.getTensp()%></td>
			<td style="width: 204px;"><img style="height: 150px;width: 100%;" src="files/<%=lsb.getHinhanh()%>"></td>
			<td style="text-align: center;"><%=dd.format(lsb.getNgaymua())%></td>
			<td style="text-align: center;"><%=lsb.getSoluong()%></td>
			<td style="text-align: center;"><%=currencyVN.format(lsb.getGiasp())%></td>
			<td style="text-align: center;"><%=currencyVN.format(lsb.getThanhtien())%></td>
		</tr>
		<%}%>
		<%}%>	
	</table>
	<%} %>
	<%} %>
	</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</html>