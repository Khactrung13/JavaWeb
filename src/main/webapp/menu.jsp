<%@page import="BO.giohangbo"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entity.DanhMuc"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
input[type=text], input[type=password] {
	width: 30%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}

/* Extra styles for the cancel button */
.cancelbtn {
	padding: 14px 20px;
	background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
	float: left;
	width: 50%;
}

/* Add padding to container elements */
.container {
	padding: 16px;
}

/* Clear floats */
.clearfix::after {
	content: "";
	clear: both;
	display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
	.cancelbtn, .signupbtn {
		width: 50%;
	}
}

.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"
		>
		<a class="navbar-brand" style="margin-left: 10px; margin-right: 10px;"
			href="sanpham">Trang chủ </a>
		<button style="width: 10%;" class="navbar-toggler" type="button"
			data-toggle="collapse" data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item dropdown"><a
					style="color: white; margin-left: 10px; font-size: 18px; margin-right: 10px;"
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Danh mục sản phẩm </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<%
							ArrayList<DanhMuc> dss = (ArrayList<DanhMuc>) request.getAttribute("dm");
							for (DanhMuc loai : dss) {
							%>
						<a class="dropdown-item" 
							href="timkiem?id=<%=loai.getId()%>&sp=<%=loai.getTendanhmuc()%>"><%=loai.getTendanhmuc()%></a>

						<%
							}
							%>

					</div></li>
				<li class="nav-item"><a
					style="color: white; margin-left: 10px; margin-right: 10px; font-size: 18px;"
					class="nav-link" href="htgiocontroller">Giỏ hàng(<% 
						giohangbo g= new giohangbo();
					  if(session.getAttribute("gh")!=null){
					  g=(giohangbo)session.getAttribute("gh");
					  int sh=g.ds.size();
					   out.print(sh);}
					   else{
						   out.print(0);
					   }%>) </a></li>
				
				<li class="nav-item"><a
					style="color: white; margin-left: 10px; margin-right: 10px; font-size: 18px;"
					class="nav-link" href="lichsumuahangcontroller"> Lịch sử mua hàng </a></li>
				<li class="nav-item"><a
					style="color: white; margin-left: 10px; margin-right: 10px; font-size: 18px;"
					class="nav-link" href="lichsumuahangcontroller"> Theo giỏi đơn hàng </a></li>
				<li class="nav-item"><a
					style="color: white; margin-left: 10px; margin-right: 10px; font-size: 18px;"
					class="nav-link" href="lichsumuahangcontroller"> Liên hệ</a></li>
				<li class="nav-item"><a
					style="color: white; margin-left: 10px; margin-right: 10px; font-size: 18px;"
					class="nav-link" href="lichsumuahangcontroller"> Đánh giá  </a></li>
				<li class="nav-item"><a
					style="color: white; margin-left: 10px; margin-right: 10px; font-size: 18px;"
					class="nav-link" href="lichsumuahangcontroller">Hỗ trợ</a></li>
					
				<li class="nav-item dropdown"><a
					style="color: white; margin-left: 10px; font-size: 18px; margin-right: 10px;"
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Quản lý tài khoản  </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<%
						response.setCharacterEncoding("UTF-8");
						request.setCharacterEncoding("utf-8");
							if (session.getAttribute("dn") != null) {
						%>
								<a  class="dropdown-item" href="dangxuat"> Thông tin cá nhân<%=
										session.getAttribute("dn1")%></a>
						<a  class="dropdown-item" href="dangxuat"> Đăng xuất :<%=
										session.getAttribute("dn1")%></a>
						<a class="dropdown-item"  href="doimatkhau"> Đổi mật khẩu </a>
						<%
					} else {%>

						<a class="dropdown-item"
							 href="dangnhap"> Đăng nhập</a>
						<a class="dropdown-item"
							 href="dangky"> Đăng ký </a>
				<%} %>

					</div></li>
				
			</ul>
			<form class="form-inline my-2 my-lg-0" action="timkiem" method="POST">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Từ khoá ....." aria-label="Search" name="tukhoa">
				<button style="color: white; border: 1px solid; width: 30%;"
					class="btn btn-outline-success my-2 my-sm-0" type="submit"
					name="timkiem">Tìm kiếm</button>
			</form>
		</div>
	</nav>

</body>
</html>