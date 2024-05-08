<%@page import="java.util.ArrayList"%>
<%@page import="Entity.DanhMuc"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="sidebar"
			style="height: 499px; float: left; background: aliceblue;padding-left: 20px;">
			<b>Danh mục sản phẩm</b>
			<%		
					
					ArrayList<DanhMuc> dss = (ArrayList<DanhMuc>)request.getAttribute("dm");
					for (DanhMuc loai : dss) { 
				
					%>

			<h3
				style=" width: 100%;
	/* padding: 20px; */ margin-top: 20px; margin-bottom: 20px;">
				<a style="color: black; text-decoration: none;" href="timkiem?id=<%=loai.getId()%>&sp=<%=loai.getTendanhmuc()%>"> <%=loai.getTendanhmuc()%>
				</a>
			</h3>

			<%
					}
					%>
		</div>
</body>
</html>