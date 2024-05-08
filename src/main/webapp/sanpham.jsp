
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
</head>
<body>
	<h3 style="margin-top: 20px;margin-left: 40px;">Sản phẩm mới nhất </h3>
	<table>
				<%
				ArrayList<SanPham> dssp = (ArrayList<SanPham>) request.getAttribute("ds") ;
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
								src="files/<%=dssp.get(i).getHinhanh()%>"> <br>
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
								src="files/<%=dssp.get(i).getHinhanh()%>"> <br>
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
								src="files/<%=dssp.get(i).getHinhanh()%>"> <br>
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
	<form style="    width: 100%;
    text-align: center;margin-bottom:50px">
    
   
	<%int trang =(int) request.getAttribute("endp"); %>
	 Trang hiện tại : <%=request.getAttribute("tr")%>/<%=trang %> <br>
	<%for(int i=1;i<=trang;i++){%>
	
	<a style="margin-right: 5px;color: black;font-weight: bold;" href="sanpham?trang=<%=i%>"><%=i%></a>
	<%} %>
	</form>
</body>
</html>