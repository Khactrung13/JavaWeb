package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.danhmucbo;
import BO.khachhangbo;
import BO.sanphambo;
import Entity.DanhMuc;
import Entity.KhachHang;
import Entity.SanPham;


/**
 * Servlet implementation class doimatkhau
 */
@WebServlet("/doimatkhau")
public class doimatkhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doimatkhau() {
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
			HttpSession session = request.getSession();
			String matkhaucu = request.getParameter("matkhaucu");
			
			String matkhaumoi = request.getParameter("matkhaumoi");
			matkhaumoi = khachhangbo.toSha1(matkhaumoi);
			String matkhaumoi1 = request.getParameter("matkhaumoi2");
			matkhaumoi1 = khachhangbo.toSha1(matkhaumoi1);
			
			if (matkhaucu == null) {
				request.getRequestDispatcher("doimatkhau.jsp").forward(request, response);
			}
			KhachHang a = (KhachHang) session.getAttribute("dn");
			khachhangbo bll = new khachhangbo();
			danhmucbo dmuc = new danhmucbo();
			ArrayList<DanhMuc> ds = dmuc.getDanhmuc();
			request.setAttribute("dm",ds);

			sanphambo sp  = new sanphambo();
			ArrayList<SanPham> dssp = sp.getListSanPham();
			request.setAttribute("ds",dssp);
			matkhaucu = khachhangbo.toSha1(matkhaucu);
			KhachHang b = bll.KiemTraTaiKhoan1(a.getEmail(), matkhaucu);
			if (b != null) {
				if(matkhaucu.equals(matkhaumoi)) {
					request.setAttribute("mess5", "Mật khẩu mới không được trùng với mật khẩu cũ!	");
					request.getRequestDispatcher("doimatkhau.jsp").forward(request, response);
				}
				if (matkhaumoi.equals(matkhaumoi1)) {
					bll.Doimatkhau(a.getId(), matkhaucu, matkhaumoi);
					request.getRequestDispatcher("sanpham").forward(request, response);
				} else {
					request.setAttribute("mess5", "Mật khẩu nhập lại không chính xác !!!	");
					request.getRequestDispatcher("doimatkhau.jsp").forward(request, response);
				}
			} else if(b==null){
				request.setAttribute("mess5", "Mật khẩu không chính xác !!!	");
				request.getRequestDispatcher("doimatkhau.jsp").forward(request, response);
			}

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
