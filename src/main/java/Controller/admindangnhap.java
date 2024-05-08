package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.adminbo;
import Entity.Admin;

/**
 * Servlet implementation class admindangnhap
 */
@WebServlet("/admindangnhap")
public class admindangnhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admindangnhap() {
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
			String taikhoan = request.getParameter("txtten");
			String matkhau = request.getParameter("txtmatkhau");
			adminbo bll = new adminbo();
			Admin a = bll.DangNhap1(taikhoan, matkhau);
			if(a==null) {
				request.setAttribute("mess", "Tên đăng nhập hoặc mật khẩu không chính xác .Vui lòng kiểm tra lại !!!	");
				request.getRequestDispatcher("dangnhapadmin.jsp").forward(request, response);
				
			}else {

				session.setAttribute("dnadmin",a);
				request.getRequestDispatcher("adminhoadon").forward(request, response);
			}
			request.getRequestDispatcher("adminhoadon").forward(request, response);
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
