<%@page import="Entity.DanhMuc"%>
<%@page import="Entity.SanPham"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="main">
		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
		<jsp:include page="siderbar.jsp"></jsp:include>
		</div>
		<div class="col-lg-13 col-md-13 col-sm-12 col-xs-12">
		<div class="maincontent"
			style="width: 84%; height: auto; float: right; background: antiquewhite;">
			<jsp:include page="sanpham.jsp"></jsp:include>
		</div>
		</div>
	</div>
</body>
</html>