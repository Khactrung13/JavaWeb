<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body style="background: beige;width: 1460px;">
	<form action="doimatkhau" method="post"
		style="border: 1px solid; width: 30%; margin-top: 200px; margin-left: 520px; background: antiquewhite;">
		<p style="text-align: center; font-size: 30px; font-weight: bold;">Đổi
			mật khẩu</p>
		<p style="color: red; font-weight: bold; margin-left: 40px;">${mess5}</p>
		<input style="width: 80%; margin-left: 40px; margin-bottom: 20px;"
			type="password" placeholder="Nhập mật khẩu cũ " name="matkhaucu">
		<input style="width: 80%; margin-left: 40px; margin-bottom: 20px;"
			type="password" placeholder="Nhập mật khẩu mới" name="matkhaumoi"><input
			style="width: 80%; margin-left: 40px; margin-bottom: 20px;"
			type="password" placeholder="Nhập  lại mật khẩu mới"
			name="matkhaumoi2"> <br>
		<button
			style="    border: 1px solid;width: 80%; margin-left: 40px; margin-bottom: 20px; background: bisque;">Đồng
			ý</button>
		<p
			style="width: 80%; margin-left: 40px; margin-bottom: 20px; background: bisque; border: 1px solid; text-align: center; font-size: 18px;">
			<a style="text-decoration: none; color: black;" href="sanpham">Huỷ</a>
		</p>

	</form>
</body>
</html>