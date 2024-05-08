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
<body style="background: aliceblue;width: 1425px;">
<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div id="main">
	<jsp:include page="siderbar.jsp"></jsp:include>
		<div class="maincontent"
			style="width: 85%;  height: auto; float: right; background: antiquewhite;padding-bottom: 20px;">
	<p style="    font-size: 20px;
    font-weight: bold;
    color: green;
    margin-top: 20px;
    margin-left: 20px;">Cảm ơn quý khách đã mua hàng!!!</p>
	</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</html>