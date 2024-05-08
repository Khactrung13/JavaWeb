package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.danhmucbo;
import BO.sanphambo;
import Entity.DanhMuc;
import Entity.SanPham;

/**
 * Servlet implementation class adminsuasanpham
 */
@WebServlet("/adminsuasanpham")
public class adminsuasanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminsuasanpham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		danhmucbo dmuc = new danhmucbo();
		ArrayList<DanhMuc> dm = dmuc.getDanhmuc();
		request.setAttribute("dm",dm);
		
		sanphambo bll = new sanphambo();
		ArrayList<SanPham> ds =bll.getListSanPham();
		request.setAttribute("dssp", ds);
		
		String id = request.getParameter("id");
		SanPham sp =bll.LaySanPham(Integer.parseInt(id));
		HttpSession session =request.getSession();
		session.setAttribute("sp",sp);
		request.setAttribute("sp",sp);
		RequestDispatcher rd = request.getRequestDispatcher("adminsuasanpham.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
