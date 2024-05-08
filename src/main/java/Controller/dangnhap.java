package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.khachhangbo;
import Entity.KhachHang;


/**
 * Servlet implementation class dangnhap
 */
@WebServlet("/dangnhap")
public class dangnhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("utf-8");
			HttpSession session =request.getSession();
			String taikhoan = request.getParameter("txtun");
			String matkhau = request.getParameter("txtpass");
			matkhau = khachhangbo.toSha1(matkhau);
			khachhangbo bll = new khachhangbo();
			if(session.getAttribute("dn")==null) {
				session.setAttribute("dn","1");
				request.getRequestDispatcher("dangnhap.jsp").forward(request, response);
			}else {
			KhachHang a = bll.DangNhap1(taikhoan,matkhau);
			if(a==null) {
				request.setAttribute("mess", "Tên đăng nhập hoặc mật khẩu không chính xác .Vui lòng kiểm tra lại !!!	");
				request.getRequestDispatcher("dangnhap.jsp").forward(request, response);
				
			}else {
				session.setAttribute("dn1",a.getTenKhachHang());
				session.setAttribute("dn",a);
				request.getRequestDispatcher("sanpham").forward(request, response);
			}}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
