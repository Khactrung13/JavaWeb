
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="Entity.SanPham"%>
<%@page import="java.util.ArrayList"%>
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
<body
	style="height: 700px; padding: 0; margin: 0; background: aliceblue;width: 1425px;">
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div id="main">
		
		<jsp:include page="siderbar.jsp"></jsp:include>
		<div class="maincontent"
			style="width: 85%; height: auto; float: right; background: antiquewhite;">
			<h2 style="margin-top: 20px;margin-left: 20px;">Từ khoá : <%=request.getAttribute("timkiem1")%></h2>
			   <p style="color:red;font-weight:bold;margin-top: 20px;margin-left: 20px;">${mess}</p>
			   <%if(request.getAttribute("timkiem")!=null){ %>
			<table>
				<%
				response.setCharacterEncoding("UTF-8");
				request.setCharacterEncoding("utf-8");
				ArrayList<SanPham> dssp = (ArrayList<SanPham>) request.getAttribute("timkiem") ;
				int n = dssp.size();
				Locale localvn = new Locale("vi","VN");
				NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localvn);
				%>

				<%
				for (int i = 0; i < n; i++) {
					
				%>
				<tr>
					<td
						style="padding-top: 30px; padding-left: 40px; padding-bottom: 30px; padding-right: 50px;">
						<form style="border: 1px solid; width: 300px; text-align: center;">
							<a href="chitietsanpham?ql=sanpham&id=<%out.print(dssp.get(i).getId());%>"><img style="width: 100%; height: 150px;"
								src="images/<%=dssp.get(i).getHinhanh()%>"> <br>
							<p style="margin-top: 5px;color:black">
								Tên sản phẩm :<%out.print(dssp.get(i).getTensp());%>
							</p>
							<p style="color:black">

								Giá:<%out.print(currencyVN.format(dssp.get(i).getGia()));%>
							</p></a>
						</form>
					</td>
					
					<%
					i++;
					if (i < n) {
					%>
					<td>
						<form style="border: 1px solid; width: 300px; text-align: center;">
							<a href="chitietsanpham?ql=sanpham&id=<%out.print(dssp.get(i).getId());%>"><img style="width: 100%; height: 150px;"
								src="images/<%=dssp.get(i).getHinhanh()%>"> <br>
							<p style="margin-top: 5px;color:black">
								Tên sản phẩm :<%out.print(dssp.get(i).getTensp());%>
							</p>
							<p style="color:black">

								Giá:<%out.print(currencyVN.format(dssp.get(i).getGia()));%>
							</p></a>
						</form>
					</td>
					<%
					}
					%>

					<%
					i++;
					if (i < n) {
					%>
					<td>
						<form style="border: 1px solid; width: 300px; text-align: center;margin-left: 50px;">
							<a href="chitietsanpham?ql=sanpham&id=<%out.print(dssp.get(i).getId());%>"><img style="width: 100%; height: 150px;"
								src="images/<%=dssp.get(i).getHinhanh()%>"> <br>
							<p style="margin-top: 5px;color:black">
								Tên sản phẩm :<%out.print(dssp.get(i).getTensp());%>
							</p>
							<p style="color:black">

								Giá:<%out.print(currencyVN.format(dssp.get(i).getGia()));%>
							</p></a>
						</form>
					</td>
					<%
					}
					%>
					<%}%>
				</tr>
			</table>

<%} %>
		<form style="    width: 100%;
    text-align: center;margin-bottom:50px">
    
   
	<%int trang =(int) request.getAttribute("endp");
	//int id = (int)request.getAttribute("id");
	String tukhoa= (String)request.getAttribute("timkiem1");
	%>
	 Trang hiện tại : <%=request.getAttribute("tr")%>/<%=trang %> <br>
	<%for(int i=1;i<=trang;i++){%>
	
	<a style="margin-right: 5px;color: black;font-weight: bold;" href="timkiem?trang=<%=i%>&tukhoa=<%=tukhoa%>"><%=i%></a>
	<%} %>
	</form>
		
		</div>
		</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</html>